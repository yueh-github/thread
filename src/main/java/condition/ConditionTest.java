package condition;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yuehao on 2017/5/23.
 */
public class ConditionTest {


    private final static int size = 10;

    private static LinkedBlockingQueue list = new LinkedBlockingQueue();

    private static Lock lock = new ReentrantLock(true);

    //控制写入
    private static Condition condition1 = lock.newCondition();

    //控制读取
    private static Condition condition2 = lock.newCondition();


    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new PutThread().start();
        }

        try {
            Thread.sleep(10000);
        } catch (Exception ex) {

        }

        for (int i = 0; i < 3; i++) {
            new GetThread().start();
        }
    }


    private static void put(int i) {
        lock.lock();
        if (list.size() >= size) {
            try {
                condition1.await();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        list.offer(i);
        System.out.println(Thread.currentThread().getName() + " put  " + i);
        condition2.signal();
        lock.unlock();
    }


    private static void get() {
        try {
            lock.lock();
            if (list.size() == 0) {
                try {
                    condition2.await();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            condition1.signal();
            Integer x = (Integer) list.take();
            System.out.println(Thread.currentThread().getName() + " take " + (Integer) x);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    static class PutThread extends Thread {

        @Override
        public void run() {
            while (true){
                put(1);
            }
        }
    }

    static class GetThread extends Thread {

        @Override
        public void run() {
            while (true){
                get();
            }
        }
    }
}
