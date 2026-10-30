public class CinemaShow {
    private final String movie;
    private final int totalSeats;
    private int bookedSeats;
    public CinemaShow(String movie, int totalSeats) {
        if (totalSeats <= 0) throw new IllegalArgumentException("Seats must be positive");
        this.movie = movie;
        this.totalSeats = totalSeats;
    }
    public boolean book(int count) {
        if (count <= 0 || bookedSeats + count > totalSeats) return false;
        bookedSeats += count;
        return true;
    }
    public int availableSeats() { return totalSeats - bookedSeats; }
    public static void main(String[] args) {
        CinemaShow show = new CinemaShow("Java: The Movie", 100);
        System.out.println("Booking 4: " + show.book(4));
        System.out.println("Booking 200: " + show.book(200));
        System.out.println(show.movie + " available seats: " + show.availableSeats());
    }
}
