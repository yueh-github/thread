package lockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by yuehao on 2017/5/23.
 */
public class LockSupportTest {


    private static Thread mainThread;


    public static void main(String[] args) {
        TestTread testTread = new TestTread();
        mainThread = Thread.currentThread();

        System.out.println("start");
        testTread.start();


        System.out.println("main 阻塞");
        LockSupport.park(mainThread);

        System.out.println("主线程执行完毕");
    }

    static class TestTread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " wakup others");
            try {
                Thread.sleep(10000);
            }catch (Exception ex){
                ex.printStackTrace();
            }
            System.out.println("唤醒主线程");
            LockSupport.unpark(mainThread);
        }
    }
}
