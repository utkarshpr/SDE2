package Thread;

public class MyThread extends Thread{
    Counter c;
    MyThread(Counter c){
        this.c=c;
    }
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            c.increment();
        }
    }
}
