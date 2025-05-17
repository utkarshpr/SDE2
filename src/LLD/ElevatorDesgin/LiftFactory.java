package LLD.ElevatorDesgin;

public class LiftFactory {
        public static Lift createLift(LiftType type, int id) {
            switch (type) {
                case PASSENGER:
                    return new PassengerLift(id);
                case SERVICE:
                    return new ServiceLift(id);
                default:
                    throw new IllegalArgumentException("Unknown lift type");
            }
    }

}
