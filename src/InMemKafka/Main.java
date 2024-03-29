package InMemKafka;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class Message {
    private final String topic;
    private final String content;

    public Message(String topic, String content) {
        this.topic = topic;
        this.content = content;
    }

    public String getTopic() {
        return topic;
    }

    public String getContent() {
        return content;
    }
}

class InMemoryKafka {
    private final Map<String, BlockingQueue<Message>> topics;
    private final Map<String, List<BlockingQueue<Message>>> subscribers;
    private final ReadWriteLock lock;

    public InMemoryKafka() {
        topics = new ConcurrentHashMap<>();
        subscribers = new ConcurrentHashMap<>();
        lock = new ReentrantReadWriteLock();
    }

    public void createTopic(String topic) {
        lock.writeLock().lock();
        try {
            topics.putIfAbsent(topic, new LinkedBlockingQueue<>());
            subscribers.putIfAbsent(topic, new ArrayList<>());
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void produce(String topic, String message) {
        BlockingQueue<Message> queue = topics.get(topic);
        if (queue == null) {
            throw new IllegalArgumentException("Topic '" + topic + "' does not exist.");
        }
        queue.offer(new Message(topic, message));
    }

    public void subscribe(String topic, BlockingQueue<Message> subscriber) {
        lock.writeLock().lock();
        try {
            List<BlockingQueue<Message>> topicSubscribers = subscribers.get(topic);
            if (topicSubscribers == null) {
                throw new IllegalArgumentException("Topic '" + topic + "' does not exist.");
            }
            topicSubscribers.add(subscriber);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void startConsumers() {
        topics.forEach((topic, queue) -> {
            List<BlockingQueue<Message>> topicSubscribers = subscribers.get(topic);
            if (topicSubscribers != null) {
                for (BlockingQueue<Message> subscriber : topicSubscribers) {
                    new Thread(() -> {
                        while (true) {
                            try {
                                Message message = queue.take();
                                subscriber.offer(message);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                    }).start();
                }
            }
        });
    }
}

public class Main {
    public static void main(String[] args) {
        InMemoryKafka kafka = new InMemoryKafka();
        kafka.createTopic("topic1");
        kafka.createTopic("topic2");

        BlockingQueue<Message> subscriber1 = new LinkedBlockingQueue<>();
        BlockingQueue<Message> subscriber2 = new LinkedBlockingQueue<>();

        kafka.subscribe("topic1", subscriber1);
        kafka.subscribe("topic2", subscriber2);

        kafka.produce("topic1", "Hello from topic1!");
        kafka.produce("topic2", "Hello from topic2!");

        kafka.startConsumers();

        try {
            System.out.println(subscriber1.take().getContent()); // Output: Hello from topic1!
            System.out.println(subscriber2.take().getContent()); // Output: Hello from topic2!
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
