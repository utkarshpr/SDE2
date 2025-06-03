package Thread;

public class Main {
    public static void main(String[] args) {
//        Counter c= new Counter();
//        MyThread m1= new MyThread(c);
//        MyThread m2= new MyThread(c);
//        m1.start();
//        m2.start();
//        try {
//            m1.join();
//            m2.join();
//        }catch (Exception e){
//
//        }
//        System.out.println(c.getCurrent());
        BankAccount bankAccount=new BankAccount();
        Runnable r1= new Runnable() {
            @Override
            public void run() {
                bankAccount.withdraw(50);
            }
        };

        Thread tx1=new Thread(r1);
        Thread tx2=new Thread(r1);
        try{
            tx1.start();
            tx2.start();
        }catch (Exception e){

        }
    }
}
