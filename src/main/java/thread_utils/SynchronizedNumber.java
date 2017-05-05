package thread_utils;

/**
 * Created by yuehao on 2017/4/27.
 */
public class SynchronizedNumber {

    private int x = 100;

    public int getX() {
        return x;
    }

    public int fix(int y) {
        synchronized (this) {
            x = x - y;
        }
        return x;
    }
}
