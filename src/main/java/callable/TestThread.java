package callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yuehao on 2017/5/22.
 */
public class TestThread {

    public static void main(String[] args) throws Exception{

        ExecutorService poll = Executors.newSingleThreadExecutor();

        Future future = poll.submit(new CallableTest("t1"));

        System.out.println(future.get());

        ReentrantLock reentrantLock = new ReentrantLock();
    }
}
