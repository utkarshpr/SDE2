package LLD.ElevatorDesgin;

import java.util.ArrayList;
import java.util.List;

public class LiftManager {
    private List<Lift> lifts;

    public LiftManager(int numPassenger, int numService) {
        lifts = new ArrayList<>();
        for (int i = 0; i < numPassenger; i++) {
            lifts.add(LiftFactory.createLift(LiftType.PASSENGER, i));
        }
        for (int i = numPassenger; i < numPassenger + numService; i++) {
            lifts.add(LiftFactory.createLift(LiftType.SERVICE, i));
        }
    }
    public int requestLift(int start, int end) {
        Lift best = null;
        int minDistance = Integer.MAX_VALUE;
        for (Lift lift : lifts) {
            if (lift.canAcceptRequest()) {
                int distance = Math.abs(lift.getCurrentFloor() - start);
                if (distance < minDistance) {
                    minDistance = distance;
                    best = lift;
                }
            }
        }
        if (best != null) {
            best.addRequest(start, end);
            return best.getId();
        }
        return -1;
    }
    public void tick() {
        System.out.println("===== Tick =====");
        for (int i = 0; i < lifts.size(); i++) {
            Lift elevator = lifts.get(i);
            int prevFloor = elevator.getCurrentFloor();

            elevator.move(); // Simulates moving 1 floor

            System.out.println("Lift " + i + " moved from Floor " + prevFloor +
                    " to Floor " + elevator.getCurrentFloor() +
                    " | Direction: " + elevator.getDirection() +
                    " | Requests: " + elevator.requests);
        }

    }

    public void printStates() {
        for (Lift lift : lifts) {
            System.out.println("Lift " + lift.getId() + " - Floor: " + lift.getCurrentFloor() +
                    " Direction: " + lift.getDirection() +
                    " People: " + lift.getPeopleCount());
        }
    }
}
