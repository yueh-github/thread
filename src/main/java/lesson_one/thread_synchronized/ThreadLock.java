package lesson_one.thread_synchronized;

import thread_utils.SynchronizedNumber;

/**
 * Created by yuehao on 2017/4/27.
 */
public class ThreadLock implements Runnable {

    private SynchronizedNumber atomicNumber = new SynchronizedNumber();

    public static void main(String[] args) {
        ThreadLock r = new ThreadLock();
        Thread ta = new Thread(r, "Thread-A");
        Thread tb = new Thread(r, "Thread-B");
        ta.start();
        tb.start();
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            this.fix(10);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " : 当前foo对象的x值= " + atomicNumber.getX());
        }
    }

    public int fix(int y) {
        return atomicNumber.fix(y);
    }
}
