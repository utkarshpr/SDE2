package LLD.ElevatorDesgin;

import java.util.*;

abstract class Lift {
    protected int id;
    protected int currentFloor;
    protected Direction direction;
    protected Queue<Integer> requests = new LinkedList<>();
    protected int capacity;
    protected int peopleCount;

    Lift(int id ,int capacity){
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.capacity = capacity;
        this.peopleCount = 0;
    }

    public  void move(){
        if (requests.isEmpty()) {
            direction = Direction.IDLE;
            return;
        }

        int nextFloor = requests.peek();

        if (currentFloor < nextFloor) {
            currentFloor++;
            direction = Direction.UP;
        } else if (currentFloor > nextFloor) {
            currentFloor--;
            direction = Direction.DOWN;
        } else {
            // Arrived at destination
            requests.poll(); // remove from queue
            updateDirection();
        }
    }
    public abstract boolean canAcceptRequest();

    public void addRequest(int start,int end){
        if (currentFloor != start) {
            requests.offer(start);  // go to pickup
        }
        requests.offer(end);       // go to destination
        peopleCount++;
        updateDirection();
    }
    protected void  updateDirection(){
        if(requests.isEmpty()){
            direction=Direction.IDLE;
            return;
        }

        direction=currentFloor>requests.peek()?Direction.DOWN:Direction.UP;
    }
    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getId() {
        return id;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public boolean isIdle() {
        return direction == Direction.IDLE;
    }

}
