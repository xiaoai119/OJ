import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created By xfj on 2020/1/27
 * 使用COndition实现一个阻塞队列
 */
public class BlockingQueue {
    ReentrantLock lock= new ReentrantLock();
    volatile LinkedList<Integer> bq = new LinkedList<Integer>();
    int maxSize;
    Condition cPut = lock.newCondition();
    Condition cGet = lock.newCondition();

    public BlockingQueue(int maxSize){
        this.maxSize=maxSize;
    }

    Boolean put(Integer e) throws InterruptedException {
        lock.lock();
        if(bq.size()<maxSize) {
            bq.push(e);
            cGet.signal();
            return Boolean.TRUE;
        }
        else{
            try {
                cPut.await();
            } finally {
                lock.unlock();
            }
        }
        return Boolean.TRUE;
    }

    Integer get() throws InterruptedException {
        lock.lock();
        if(bq.size()>0) {
            Integer result = bq.pop();
            cPut.signal();
        }
        else{
            try {
                cPut.await();
            } finally {
                lock.unlock();
            }
        }
        return 0;
    }
}
