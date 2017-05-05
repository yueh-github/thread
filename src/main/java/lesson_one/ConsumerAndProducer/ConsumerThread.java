package lesson_one.ConsumerAndProducer;

/**
 * Created by yuehao on 2017/4/27.
 */
public class ConsumerThread extends Thread {

    private Godown godown;

    public ConsumerThread(Godown godown) {
        this.godown = godown;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        while (true) {
            try {
                Thread.sleep(100);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            godown.consume(threadName, 10);
        }
    }
}
