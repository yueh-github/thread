package countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yuehao on 2017/5/23.
 */
public class CountDownLatchTest {

    private static CountDownLatch countDownLatch;

    static {
        countDownLatch = new CountDownLatch(5);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new TestThread().start();
        }

        try {
            System.out.println("阻塞主线程，等待子线程执行完毕~~");
            countDownLatch.await();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("子线程执行完毕，执行主线程~~~~");
    }


    static class TestThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running");
            try {
                Thread.sleep(10000);
            }catch (Exception ex){
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 子线程执行完毕~~~~");
            countDownLatch.countDown();
        }
    }
}
