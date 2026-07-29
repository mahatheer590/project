import java.util.Scanner;

class ParkingSlot {
    int slotNumber;
    boolean occupied;
    String vehicleNumber;

    ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.occupied = false;
        this.vehicleNumber = "";
    }
}

public class ParkingSystem {

    static ParkingSlot[] slots;

    public static void displaySlots() {
        System.out.println("\nParking Slot Status:");
        for (ParkingSlot slot : slots) {
            if (slot.occupied)
                System.out.println("Slot " + slot.slotNumber + " : Occupied (" + slot.vehicleNumber + ")");
            else
                System.out.println("Slot " + slot.slotNumber + " : Available");
        }
    }

    public static void parkVehicle(String vehicleNo) {
        for (ParkingSlot slot : slots) {
            if (!slot.occupied) {
                slot.occupied = true;
                slot.vehicleNumber = vehicleNo;
                System.out.println("Vehicle parked successfully at Slot " + slot.slotNumber);
                return;
            }
        }
        System.out.println("Parking Full!");
    }

    public static void removeVehicle(int slotNo) {
        if (slotNo < 1 || slotNo > slots.length) {
            System.out.println("Invalid Slot Number!");
            return;
        }

        ParkingSlot slot = slots[slotNo - 1];

        if (slot.occupied) {
            System.out.println("Vehicle " + slot.vehicleNumber + " removed from Slot " + slot.slotNumber);
            slot.occupied = false;
            slot.vehicleNumber = "";
        } else {
            System.out.println("Slot is already empty.");
        }
    }

    public static void searchVehicle(String vehicleNo) {
        for (ParkingSlot slot : slots) {
            if (slot.occupied && slot.vehicleNumber.equalsIgnoreCase(vehicleNo)) {
                System.out.println("Vehicle found at Slot " + slot.slotNumber);
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of parking slots: ");
        int n = sc.nextInt();

        slots = new ParkingSlot[n];

        for (int i = 0; i < n; i++) {
            slots[i] = new ParkingSlot(i + 1);
        }

        int choice;

        do {
            System.out.println("\n===== Parking Slot Booking System =====");
            System.out.println("1. Display Slots");
            System.out.println("2. Park Vehicle");
            System.out.println("3. Remove Vehicle");
            System.out.println("4. Search Vehicle");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    displaySlots();
                    break;

                case 2:
                    System.out.print("Enter Vehicle Number: ");
                    String vehicleNo = sc.next();
                    parkVehicle(vehicleNo);
                    break;

                case 3:
                    System.out.print("Enter Slot Number: ");
                    int slotNo = sc.nextInt();
                    removeVehicle(slotNo);
                    break;

                case 4:
                    System.out.print("Enter Vehicle Number: ");
                    vehicleNo = sc.next();
                    searchVehicle(vehicleNo);
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}