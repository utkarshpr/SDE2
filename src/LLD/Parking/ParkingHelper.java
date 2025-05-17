package LLD.Parking;

public class ParkingHelper {

    int status; // 201 success, 404 failure
    String spotId;
    String vehicleNumber;
    String ticketId;

    public ParkingHelper(int status, String spotId, String vehicleNumber, String ticketId) {
        this.status = status;
        this.spotId = spotId;
        this.vehicleNumber = vehicleNumber;
        this.ticketId = ticketId;
    }

    @Override
    public String toString() {
        return "ParkingResult{" +
                "status=" + status +
                ", spotId='" + spotId + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", ticketId='" + ticketId + '\'' +
                '}';
    }
}