package thread_utils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yuehao on 2017/4/27.
 */
public class AtomicNumber {
    private AtomicInteger x = new AtomicInteger(100);

    public int getX() {
        return x.get();
    }

    public int fix(int y) {
        return x.getAndAdd(y);
    }
}
