package threadJoin;

/**
 * Created by yuehao on 2017/5/10.
 */
public class JoinThread {

    public static void main(String[] args) {
        FathreThread fathreThread = new FathreThread("father_thread");
        fathreThread.start();
    }

    //join() 的作用：让“主线程”等待“子线程”结束之后才能继续运行。

    //在Father主线程中，通过new Son()新建“子线程s”。接着通过s.start()启动“子线程s”，并且调用s.join()。
    // 在调用s.join()之后，Father主线程会一直等待，直到“子线程s”运行完毕；在“子线程s”运行完毕之后，Father主线程才能接着运行。
    // 这也就是我们所说的“join()的作用，是让主线程会等待子线程结束之后才能继续运行”！

    static class FathreThread extends Thread {
        public FathreThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("father主线程启动~");
            SonThread sonThread = new SonThread("son_thread");
            sonThread.start();
            try {
                sonThread.join();
            } catch (Exception ex) {

            }

            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " 执行：" + i);
            }
        }
    }

    static class SonThread extends Thread {

        public SonThread(String name) {
            super(name);
        }

        @Override
        public void run() {

            for (int i = 0; i < 500; i++) {
                System.out.println(Thread.currentThread().getName() + " 执行：" + i);
            }
        }
    }
}
