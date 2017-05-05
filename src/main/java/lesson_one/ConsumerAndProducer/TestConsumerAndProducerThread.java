package lesson_one.ConsumerAndProducer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yuehao on 2017/4/27.
 */
public class TestConsumerAndProducerThread {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();

        Godown godown = new Godown(atomicInteger);

        ProducerThread producerThread = new ProducerThread(godown);
        producerThread.start();

        ConsumerThread consumerThread = new ConsumerThread(godown);
        consumerThread.start();

        ConsumerThread consumerThread1 = new ConsumerThread(godown);
        consumerThread1.start();
    }
}
