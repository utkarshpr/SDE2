package LLD.Parking;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingLotSystem {
    private ParkingSpot[][][] parkingSpots;
    private final ReentrantLock lock = new ReentrantLock();
    private int floors, rows, columns;
    private final Map<String, String> vehicleToSpot = new ConcurrentHashMap<>();
    private final Map<String, String> ticketToSpot = new ConcurrentHashMap<>();
    private final Map<String, ParkingHelper> spotToVehicle = new ConcurrentHashMap<>();


    public void init(String[][][] parking) {
        floors = parking.length;
        rows = parking[0].length;
        columns = parking[0][0].length;

        parkingSpots = new ParkingSpot[floors][rows][columns];
        for (int f = 0; f < floors; f++) {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    String spotInfo = parking[f][r][c];
                    String[] parts = spotInfo.split("-");
                    int type = Integer.parseInt(parts[0]);
                    boolean isActive = parts[1].equals("1");
                    String spotId = f + "-" + r + "-" + c;

                    parkingSpots[f][r][c] = ParkingSpotFactory.createPrakingSpot(type, spotId, isActive);
                }
            }
        }
    }
    public ParkingHelper park(int vehicleType, String vehicleNumber, String ticketId) {
        lock.lock();
        try {
            for (int f = 0; f < floors; f++) {
                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < columns; c++) {
                        ParkingSpot spot = parkingSpots[f][r][c];
                        if (spot.type == vehicleType && spot.isActive && !spot.isOccupied) {
                            boolean canbparked = spot.parkVechile();
                            if (canbparked) {
                                String spotId = spot.getSpot();
                                vehicleToSpot.put(vehicleNumber, spotId);
                                ticketToSpot.put(ticketId, spotId);
                                ParkingHelper pr = new ParkingHelper(201, spotId, vehicleNumber, ticketId);
                                spotToVehicle.put(spotId, pr);
                                return pr;

                            }
                        }
                    }
                }
            }
            return new ParkingHelper(404, "", vehicleNumber, ticketId);
        }finally {
            lock.unlock();
        }
    }
    public int remove(String spotId, String vehicleNumber, String ticketId){
       lock.lock();
       try {
           String foundSpotId = null;
           if(!spotId.isEmpty()){
               foundSpotId=spotId;
           }else if(!vehicleNumber.isEmpty()){
               foundSpotId= vehicleToSpot.get(vehicleNumber);
           }else if(!ticketId.isEmpty()){
               foundSpotId=ticketToSpot.get(ticketId);
           }
           if(foundSpotId == null)return 404;

           String[] parts = foundSpotId.split("-");
           int f = Integer.parseInt(parts[0]);
           int r = Integer.parseInt(parts[1]);
           int c = Integer.parseInt(parts[2]);

           if (f >= floors || r >= rows || c >= columns) return 404;

           ParkingSpot spot = parkingSpots[f][r][c];

           if(!spot.isOccupied)return 404;
           spot.removeVechile();

           ParkingHelper pr=spotToVehicle.get(spotId);
           if(pr!=null){
               vehicleToSpot.remove(spotId);
               ticketToSpot.remove(spotId);
           }
           spotToVehicle.remove(spotId);
    return 201;

       }finally {
           lock.unlock();
       }
    }

    public ParkingHelper searchVehicle(String spotId, String vehicleNumber, String ticketId) {
        if (!spotId.isEmpty()) {
            ParkingHelper pr = spotToVehicle.get(spotId);
            return pr != null ? pr : new ParkingHelper(404, "", "", "");
        } else if (!vehicleNumber.isEmpty()) {
            String sId = vehicleToSpot.get(vehicleNumber);
            if (sId == null) return new ParkingHelper(404, "", "", "");
            ParkingHelper pr = spotToVehicle.get(sId);
            if (pr != null) return pr;
            return new ParkingHelper(200, sId, vehicleNumber, "");
        } else if (!ticketId.isEmpty()) {
            String sId = ticketToSpot.get(ticketId);
            if (sId == null) return new ParkingHelper(404, "", "", "");
            ParkingHelper pr = spotToVehicle.get(sId);
            if (pr != null) return pr;
            return new ParkingHelper(200, sId, "", ticketId);
        }
        return new ParkingHelper(404, "", "", "");
    }

    public int getFreeSpotsCount(int floor, int vehicleType) {
        if (floor < 0 || floor >= floors) return 0;

        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                ParkingSpot spot = parkingSpots[floor][r][c];
                if (spot.getType() == vehicleType && spot.isActive() && !spot.isOccupied()) {
                    count++;
                }
            }
        }
        return count;
    }

    public void printStatus() {
        System.out.println("Current parking status:");
        for (int f = 0; f < floors; f++) {
            System.out.println("Floor " + f + ":");
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    ParkingSpot spot = parkingSpots[f][r][c];
                    System.out.print(
                            spot.getSpot() + "(" + spot.getType() + (spot.isActive() ? "-Active" : "-Inactive") +
                                    (spot.isOccupied() ? "-Occupied" : "-Free") + ") ");
                }
                System.out.println();
            }
        }
    }
}
