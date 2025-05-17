package LLD.ElevatorDesgin;

public class ServiceLift extends Lift {

    ServiceLift(int id) {
        super(id, 15);
    }


    @Override
    public boolean canAcceptRequest() {
        return peopleCount<capacity;
    }
}
