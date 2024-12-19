import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class SynchronizedBuffer implements Buffer{
//    private int buffer = -1;
//    private boolean occupied = false;

    private final Lock accessLock = new ReentrantLock();

    private final Condition canWrite = accessLock.newCondition();
    private final Condition canRead = accessLock.newCondition();

    private int buffer = -1;
    private boolean occupied = false;

    public void set(int value) throws InterruptedException {
        accessLock.lock();
        try {
            if (occupied) {
                System.out.println("producer tries to write.");
                displayState("buffer full. producer waits");
//            wait();
                canWrite.await();
            }
            buffer = value;
            occupied = true;
            displayState("producer writes " + buffer);
//        notifyAll();
            canRead.signal();
        }
        // added after
        finally {
            accessLock.unlock();
        }
    }
    public int get() throws InterruptedException {
    // added after line 40-41 and try catch
        int readValue = 0;
        accessLock.lock();
        try {
            if (!occupied) {
                System.out.println("consumer tries to read.");
                displayState("buffer empty. consumer waits.");
//                wait();
                canRead.await();
            }
            occupied = false;
//            displayState("consumer reads " + buffer);
//            notifyAll();
//            return buffer;
            // added after line 53-54-55-56 and finally block
            readValue = buffer;
            displayState("consumer reads " + readValue);
            canWrite.signal();
        } finally {
            accessLock.unlock();
        }
        return  readValue;
    }
    private void displayState(String operation) {
        System.out.printf("%-40s%d\t\t%b\n\n", operation, buffer, occupied);
    }
}
