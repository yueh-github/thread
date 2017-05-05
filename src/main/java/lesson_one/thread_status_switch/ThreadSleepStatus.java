package lesson_one.thread_status_switch;

/**
 * Created by yuehao on 2017/4/27.
 */
public class ThreadSleepStatus extends Thread {


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print(i);
            try {
                Thread.sleep(1);
                System.out.print("    线程睡眠1毫秒！\n");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
