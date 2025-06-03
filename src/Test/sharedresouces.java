package Test;

import java.util.LinkedList;
import java.util.Queue;

public class sharedresouces {
    public static void main(String[] args) {
        Buffer b=new Buffer(5);
        Thread producer=new Thread(new Producer(b));
        Thread consumer=new Thread(new Consumer(b));
        producer.start();
        consumer.start();
    }
}

class Buffer{
    public int capacity;
    Queue<Integer> buffer=new LinkedList<>();
    boolean isFinished=false;
    Buffer(int cap){
        this.capacity=cap;
    }

    public synchronized void produce(int data) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait();
        }
        buffer.add(data);
        System.out.println("Produced: " + data);
        if(data == 10){
            isFinished=true;
            notifyAll();
            return;
        }

        notifyAll();

    }
    public synchronized  boolean consumer() throws InterruptedException {
        while (buffer.isEmpty()) {
            if(isFinished){
                notifyAll();
                System.out.println(isFinished);
                return false;
            }
            wait();
        }
        int val = buffer.poll();

        System.out.println("Consumed: " + val);
        notifyAll();
        return  true;
    }
}
class Producer implements Runnable{
    Buffer b;
    int count=0;
    Producer(Buffer b){
        this.b=b;
    }

    @Override
    public void run() {
        while (true) {
            try {
                b.produce(count);
                count++;
                Thread.sleep(100); // Optional: to slow down production a bit
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break; // exit the loop if interrupted
            }
        }
    }
}

class Consumer implements Runnable{
    Buffer b;
    Consumer(Buffer b){
        this.b=b;
    }
    @Override
    public void run() {
        while(true){
            try {
               while(b.consumer());
               break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}