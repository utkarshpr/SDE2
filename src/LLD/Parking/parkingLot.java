package LLD.Parking;

public class parkingLot {
    public static void main(String[] args) {
        /*
init(parking) - Initialize lot with floors, rows, columns, spot types
park(vehicleType, vehicleNumber, ticketId) - assign spot if available
removeVehicle(spotId, vehicleNumber, ticketId) - unpark vehicle by one of these identifiers
searchVehicle(spotId, vehicleNumber, ticketId) - find vehicle location or last location
getFreeSpotsCount(floor, vehicleType) - count available spots of a type on a floor*/
        ParkingLotSystem parkingLot = new ParkingLotSystem();
        String[][][] parking = {{
                {"4-1", "4-1", "2-1", "2-0"},
                {"2-1", "4-1", "2-1", "2-1"},
                {"4-0", "2-1", "4-0", "2-1"},
                {"4-1", "4-1", "4-1", "2-1"}
        }};

        parkingLot.init(parking);
        parkingLot.printStatus();

        System.out.println("\n--- Parking vehicles ---");

        ParkingHelper p1 = parkingLot.park(4, "bh234", "tkt4534");
        System.out.println(p1);

        ParkingHelper p2 = parkingLot.park(2, "tw123", "tkt1234");
        System.out.println(p2);

        System.out.println("\nFree 4-wheeler spots on floor 0: " + parkingLot.getFreeSpotsCount(0, 4));
        System.out.println("Free 2-wheeler spots on floor 0: " + parkingLot.getFreeSpotsCount(0, 2));

        System.out.println("\n--- Searching vehicles ---");
        System.out.println(parkingLot.searchVehicle(p1.spotId, "", ""));
        System.out.println(parkingLot.searchVehicle("", "tw123", ""));
        System.out.println(parkingLot.searchVehicle("", "", "tkt4534"));

        System.out.println("\n--- Removing vehicles ---");
        System.out.println("Remove by spotId: " + parkingLot.remove(p1.spotId, "", "")); // Expect 201
        System.out.println("Remove by vehicleNumber: " + parkingLot.remove("", "tw123", "")); // Expect 201

        System.out.println("\nAfter removal - Free spots:");
        System.out.println("Free 4-wheeler spots on floor 0: " + parkingLot.getFreeSpotsCount(0, 4));
        System.out.println("Free 2-wheeler spots on floor 0: " + parkingLot.getFreeSpotsCount(0, 2));

        System.out.println("\n--- Searching removed vehicles ---");
        System.out.println(parkingLot.searchVehicle(p1.spotId, "", ""));
        System.out.println(parkingLot.searchVehicle("", "tw123", ""));



    }
}
