package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    Lock lock=new ReentrantLock();
    public static void main(String[] args) {
        DeadLock d= new DeadLock();
        Runnable outer=new Runnable() {
            @Override
            public void run() {
                d.outerMathod();
            }
        };
        Runnable inner=new Runnable() {
            @Override
            public void run() {
                d.innerMethod();
            }
        };
        Thread t1=new Thread(outer);
        Thread t2=new Thread(inner);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch (Exception e){
            System.out.println("Exception :"+e);
        }
    }
    public void outerMathod(){
        lock.lock();
        try{
            System.out.println("Outer");
            innerMethod();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    private void innerMethod() {
        lock.lock();
        try{
            System.out.println("inner");
            outerMathod();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}
