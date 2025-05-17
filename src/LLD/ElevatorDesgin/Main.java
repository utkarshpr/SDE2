package LLD.ElevatorDesgin;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        LiftManager manager = new LiftManager(2, 1); // 2 passenger lifts, 1 service lift

        // Schedule automatic tick
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(manager::tick, 0, 1, TimeUnit.SECONDS);

        // Send requests in background (example)
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                manager.requestLift(0, 3);
                Thread.sleep(2000);
                manager.requestLift(2, 5);
                Thread.sleep(3000);
                manager.requestLift(1, 4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();



    }
}
