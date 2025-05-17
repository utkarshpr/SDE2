package LLD.Parking;

abstract class ParkingSpot {
    protected  final String spot;
    protected  final int type;
    protected final boolean isActive;
    protected volatile boolean isOccupied;

    public ParkingSpot(String spot,int type,boolean isActive){
        this.isActive=isActive;
        this.spot=spot;
        this.type=type;
        this.isOccupied=false;
    }

    public String getSpot() {
        return spot;
    }

    public int getType() {
        return type;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public synchronized  boolean parkVechile(){
        if(!isActive || isOccupied) return  false;
        isOccupied=true;
        return  true;

    }
    public synchronized  void removeVechile(){
        isOccupied=false;

    }
}

class TwoWheeler extends ParkingSpot {

    public TwoWheeler(String spot, int type, boolean isActive) {
        super(spot, 2, isActive);
    }
}

class FourWheeler extends ParkingSpot{

    public FourWheeler(String spot, int type, boolean isActive) {
        super(spot, 4, isActive);
    }
}

class ParkingSpotFactory{
    public static  ParkingSpot createPrakingSpot(int type, String spotId, boolean isActive){
        if(type == 2){
            return new TwoWheeler(spotId,type,isActive);
        }else if(type ==4){
            return new FourWheeler(spotId,type,isActive);
        }
        throw new IllegalArgumentException("Unsupported parking spot type: " + type);
    }
}