
import Events.Occurrence;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Occurrence ev1 = new Occurrence("Rammstein Concert", LocalDate.of(2026, 6, 15), 1500);

        System.out.println(ev1.toString());

        ev1.BookSeat();

        System.out.println(ev1.getBookedSeats());

        ev1.CancelBookedSeat();

        System.out.println(ev1.getBookedSeats());

        ev1.setDate(LocalDate.of(2025, 4, 6));
    }
}
