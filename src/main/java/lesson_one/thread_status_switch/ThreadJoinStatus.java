package lesson_one.thread_status_switch;

/**
 * Created by yuehao on 2017/4/27.
 */
public class ThreadJoinStatus extends Thread {

    //其实join的作用可以用来保证启动线程后面的代码执行顺序，如果不用Join，那么线程后面的代码会立即执行，就是异步执行
    //如果在调用join方法，那么意识就是主线程的代码等待子线程的执行完毕，才会执行后续的代码

    public static void main(String[] args) {
        ThreadJoinStatus t1 = new ThreadJoinStatus();
        t1.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("主线程第" + i + "次执行！");
            if (i > 2) {
                try {
                    //t1线程合并到主线程中，主线程停止执行过程，转而执行t1线程，直到t1执行完毕后继续。
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
