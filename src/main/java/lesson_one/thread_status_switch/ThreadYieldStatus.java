package lesson_one.thread_status_switch;

import lesson_one.create_thread.CreateThreadByImplements;
import lesson_one.create_thread.CreateThredByExtends;

/**
 * Created by yuehao on 2017/4/27.
 */
public class ThreadYieldStatus {



//    Thread.yield()方法作用是：暂停当前正在执行的线程对象，并执行其他线程。
//    yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。
//    但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
//    结论：yield()从未导致线程转到等待/睡眠/阻塞状态。在大多数情况下，yield()将导致线程从运行状态转到可运行状态，但有可能没有效果。
    public static void main(String[] args) {
        CreateThredByExtends createThredByExtends = new CreateThredByExtends("线程0");
        createThredByExtends.start();

        CreateThredByExtends createThredByExtends1 = new CreateThredByExtends("线程1");
        createThredByExtends1.start();

        CreateThreadByImplements createThreadByImplements = new CreateThreadByImplements("线程2");
        new Thread(createThreadByImplements).start();
    }
}
