package executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by yuehao on 2017/5/22.
 */
public class DiscardPolicyTest {

    private static final int THREADS_SIZE = 1;

    private static final int CAPACITY = 1;


    //AbortPolicy         -- 当任务添加到线程池中被拒绝时，它将抛出 RejectedExecutionException 异常。
    //CallerRunsPolicy    -- 当任务添加到线程池中被拒绝时，会在线程池当前正在运行的Thread线程池中处理被拒绝的任务。
    //DiscardOldestPolicy -- 当任务添加到线程池中被拒绝时，线程池会放弃等待队列中最旧的未处理任务，然后将被拒绝的任务添加到等待队列中。
    //DiscardPolicy       -- 当任务添加到线程池中被拒绝时，线程池将丢弃被拒绝的任务。

    public static void main(String[] args) {

        ThreadPoolExecutor poll = new ThreadPoolExecutor(THREADS_SIZE, THREADS_SIZE, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(CAPACITY));
        poll.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            Runnable myrun = new MyRunnable("task --" + i);
            poll.submit(myrun);
        }

        poll.shutdown();

    }
}
