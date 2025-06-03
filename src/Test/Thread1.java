package Test;

public class Thread1 {

    public static void main(String[] args) {
        sharedResouce sb=new sharedResouce(10);
        Thread t1=new Thread(new printEVEN(sb));
        Thread t2=new Thread(new printODD(sb));

        t1.start();
        t2.start();
    }

}
class sharedResouce{
    public  int COUNT=1;
    public  int CAPACITY=10;

    sharedResouce(int cap){
        this.CAPACITY=cap;
    }
}

class printEVEN implements Runnable {
    sharedResouce sb;
    printEVEN(sharedResouce sb){
        this.sb=sb;
    }
    @Override
    public void run() {
        synchronized (sb){
            while(true) {
                while (sb.COUNT % 2 != 0) {
                    try {
                        sb.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (sb.CAPACITY >= sb.COUNT) {
                    System.out.println(sb.COUNT);
                    sb.COUNT++;
                }
                if (sb.COUNT > sb.CAPACITY) {
                    sb.notify();
                    break;
                }
                sb.notify();
            }
        }
    }
}

class printODD implements Runnable {
    sharedResouce sb;
    printODD(sharedResouce sb){
        this.sb=sb;
    }
    @Override
    public void run() {
        synchronized (sb){
            while(true) {
                while (sb.COUNT % 2 == 0) {
                    try {
                        sb.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (sb.CAPACITY >= sb.COUNT) {
                    System.out.println(sb.COUNT);
                    sb.COUNT++;
                }
                if (sb.COUNT > sb.CAPACITY) {
                    sb.notify();
                    break;
                }
                sb.notify();
            }
        }
    }
}