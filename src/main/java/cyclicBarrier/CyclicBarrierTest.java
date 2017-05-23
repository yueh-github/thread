package cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by yuehao on 2017/5/23.
 */
public class CyclicBarrierTest {

    private static CyclicBarrier cyclicBarrier;

    static {
        cyclicBarrier = new CyclicBarrier(6, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                System.out.println("到达cyclicBarrier设定值，先执行cyclicBarrier的线程~~~~~over");
            }
        });
    }


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new TestThread().start();
        }


        System.out.println(Thread.currentThread().getName() + " 主线程休息10秒....");
        try {
            Thread.sleep(10000);
        }catch (Exception ex){
            ex.printStackTrace();
        }


        System.out.println("新建一个线程，信号量到达目标");
        new TestThread().start();
    }

    static class TestThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " wait for CyclicBarrier.");
            try {
                Thread.sleep(10000);
                cyclicBarrier.await();
            } catch (Exception ex) {

            }
            System.out.println(Thread.currentThread().getName() + " is running");
        }
    }
}
