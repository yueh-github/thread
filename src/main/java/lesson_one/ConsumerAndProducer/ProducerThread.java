package lesson_one.ConsumerAndProducer;

/**
 * Created by yuehao on 2017/4/27.
 */
public class ProducerThread extends Thread {

    private Godown godown;

    public ProducerThread(Godown godown) {
        this.godown = godown;
    }


    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            godown.produce(threadName, 10);
        }
    }
}
