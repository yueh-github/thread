package thredWaitNotify;

/**
 * Created by yuehao on 2017/5/10.
 */
public class DemoThread extends Thread {

    public DemoThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 开始启动了~~~");
        while (true){
        }
    }
}
