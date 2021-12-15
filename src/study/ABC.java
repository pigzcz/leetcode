package study;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:johnson.zhu
 * @Date: 2021/11/21 9:23 下午
 * @Description:
 **/
public class ABC {

    public static void main(String[] args) {
//        Lock rl = new ReentrantLock();
//        rl.unlock();
//        Condition condition = rl.newCondition();
//        condition.await();
//        condition.signalAll();

        MyThread A = new MyThread("A");
        Thread a = new Thread(A);
        a.setName("A");
        MyThread B = new MyThread("B");
        Thread b = new Thread(B);
        b.setName("B");
        MyThread C = new MyThread("C");
        Thread c = new Thread(C);
        c.setName("C");
        MyThread D = new MyThread("D");
        Thread d = new Thread(D);
        d.setName("D");

        ABCLock lock = new ABCLock(a,b,c,d);

        A.setLock(lock);
        B.setLock(lock);
        C.setLock(lock);
        D.setLock(lock);
        a.start();
        b.start();


        d.start();
        c.start();
    }
    public static class MyThread implements Runnable{
        private ABCLock lock;

        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        public void setLock(ABCLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            int n = 0;
            while (true){
                lock.lock();
                n++;
                System.out.println(Thread.currentThread().getName()+"打印了"+n+"次:"+name);
                lock.unLock();
                if(n==10){
                    break;
                }
            }
        }
    }
    public static class ABCLock extends AbstractQueuedSynchronizer{

        public void lock(){
            this.acquire(1);
        }
        public void unLock(){
            this.release(1);
        }
        private int n =0;
        public ABCLock(Thread... threads) {
            n = threads.length-1;
            states = new HashMap<>(threads.length);
            int i = 0;
            for (Thread t : threads){
                states.put(t,i);
                i++;
            }
        }
        final Condition newCondition() {
            return new ConditionObject();
        }
        private Map<Thread,Integer> states;
        @Override
        protected boolean tryAcquire(int arg) {
            Thread thread = Thread.currentThread();
            while (true){
                Integer integer = states.get(thread);
                if (integer.equals(0) && compareAndSetState(0,1)){
                    for (Map.Entry<Thread,Integer> entry : states.entrySet()){
                        if (!entry.getKey().equals(thread)){
                            states.put(entry.getKey(),entry.getValue()-1);
                        }
                    }
                    setExclusiveOwnerThread(thread);
                    return true;
                }
            }

        }

        @Override
        protected boolean tryRelease(int arg) {
            Thread thread = Thread.currentThread();
            boolean b = compareAndSetState(1, 0);
            if (b && thread.equals(getExclusiveOwnerThread())){
                states.put(thread,n);
            }
            return b;
        }
    }
}
