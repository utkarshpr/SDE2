package Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private  double balance=2000;

//    public synchronized void withdraw(double amount) throws InterruptedException {
//        if(amount > balance){
//            System.out.println("Amount cannot be withdrawn :  ...... insuffcient Balance");
//
//        }
//        else{
//
//            System.out.println("Amount is withdrawn :  "+amount);
//            Thread.sleep(2000);
//            balance-=amount;
//            System.out.println("Remaning Balanace is : "+balance);
//        }
//    }

        Lock lock=new ReentrantLock();

        public synchronized void withdraw(double amount)  {
            try {
                if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                    if (amount > balance) {
                        System.out.println("Amount cannot be withdrawn :  ...... insuffcient Balance");

                    } else {
                        try {
                            System.out.println("Amount is withdrawn :  " + amount);
                            Thread.sleep(2000);
                            balance -= amount;
                            System.out.println("Remaning Balanace is : " + balance);
                        }catch (Exception e){

                        }
                        finally {
                            lock.unlock();
                        }
                    }
                }
                else{
                    System.out.println("Cannot acquire Lock");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }



}
