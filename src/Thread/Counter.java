package Thread;

public class Counter {

    private int count =0;

    public synchronized  void increment(){
        count++;
    }

    public int getCurrent(){
        return this.count;
    }
}
