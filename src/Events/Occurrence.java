package Events;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Occurrence{
    private String title;
    private LocalDate date;
    private final int totalSeats;
    private int bookedSeats;

    // Constructor
    public Occurrence(String title, LocalDate date, int totalSeats) {
        //Check if the date set by the user is correct
        if (date.isBefore(LocalDate.now()) || date.isEqual(LocalDate.now())) {
            throw new IllegalArgumentException("The date is incorrect! The date is in the past or is just now.");
        }
        //check of total seats
        if (totalSeats <= 0) {
            throw new IllegalArgumentException("The total seats can't be under 0!");
        }

        this.title = title;
        this.date = date;
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }

    // Getter e Setter
    
    public String getTitle() {
        return title;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }    
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) {
        if (date.isBefore(LocalDate.now()) || date.isEqual(LocalDate.now())) {
            throw new IllegalArgumentException("The date is incorrect! The date is in the past or is just now.");
        }
        this.date = date;
    }

    // Method to book one place
    public void BookSeat() {
        if (date.isBefore(LocalDate.now()) || date.isEqual(LocalDate.now())) {
            throw new IllegalArgumentException("The date of the selected event is in the past or is just now.");
        }
        if (this.bookedSeats >= this.totalSeats) {
            throw new IllegalStateException("Impossible to book a seat for the selected event!");
        }
        bookedSeats++;
    }

    // Method to cancel a booked place
    
    public void CancelBookedSeat() {
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The date of the selected event is in the past.");
        }
        if (this.bookedSeats <= 0) {
            throw new IllegalStateException("No one booked a seat for for the selected event yet!");
        }
        bookedSeats--;
    }

    // .toString() override
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter) + " - " + title;
    }

}

