package thredWaitNotify;

/**
 * Created by yuehao on 2017/5/10.
 */
public class NotifyThred extends Thread {


    public NotifyThred(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " call notify");
            notify();
        }

    }
}
