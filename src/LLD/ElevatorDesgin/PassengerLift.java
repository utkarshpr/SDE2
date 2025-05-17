package LLD.ElevatorDesgin;

public class PassengerLift extends Lift{

    PassengerLift(int id) {
        super(id, 10);
    }



    @Override
    public boolean canAcceptRequest() {
        return peopleCount<capacity;
    }
}
