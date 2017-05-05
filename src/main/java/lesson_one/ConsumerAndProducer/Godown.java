package lesson_one.ConsumerAndProducer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yuehao on 2017/4/27.
 */
public class Godown {

    private int maxNumber = 100;
    private AtomicInteger atomicInteger = new AtomicInteger();

    public Godown(AtomicInteger atomicInteger) {
        this.atomicInteger = atomicInteger;
    }


    public void produce(String name, int number) {
        synchronized (this) {
            if (atomicInteger.get() == maxNumber) {
                return;
            }
        }
        atomicInteger.addAndGet(number);
        System.out.println(name +":"+ "已经生产了" + number + "个产品，现仓储量为" + atomicInteger.get());
    }


    public void consume(String name, int number) {
        synchronized (this) {
            if (atomicInteger.get() == 0) {
                return;
            }
            atomicInteger.addAndGet(-number);
            System.out.println(name + ":" + "已经消费了" + number + "个产品，现仓储量为" + atomicInteger.get());
        }
    }
}
