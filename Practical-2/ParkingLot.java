public class ParkingLot {
    private static final int CAPACITY = 3;
    private int occupied;
    public boolean park() {
        if (occupied == CAPACITY) return false;
        occupied++;
        return true;
    }
    public boolean leave() {
        if (occupied == 0) return false;
        occupied--;
        return true;
    }
    public void display() { System.out.println("Occupied: " + occupied + "/" + CAPACITY); }
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();
        System.out.println("Park: " + lot.park());
        System.out.println("Park: " + lot.park());
        lot.display();
        System.out.println("Leave: " + lot.leave());
        lot.display();
    }
}
