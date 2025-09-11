package Events;

import Exceptions.BookingSeatsError;
import Exceptions.DateWrong;
import Exceptions.NameEventError;
import Exceptions.WrongTotalSeats;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Occurrence{
    private String title;
    private LocalDate date;
    private final int totalSeats;
    private int bookedSeats;

    // Constructor
    public Occurrence(String title, LocalDate date, int totalSeats) throws NameEventError, DateWrong, WrongTotalSeats {
        //Check if the date set by the user is correct
        if (date.isBefore(LocalDate.now()) || date.isEqual(LocalDate.now())) {
            throw new DateWrong ("The date is incorrect! The date is in the past or is just now.");
        }
        //check of total seats
        if (totalSeats <= 0) {
            throw new WrongTotalSeats ("The total seats can't be under 0!");
        }
        //check the name of the event
        if (title.isBlank()){
            throw new NameEventError("The event name can't be null");
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
    
    public void setTitle(String title) throws NameEventError{
        if (title.isBlank()){
            throw new NameEventError("The event name can't be null");
        }
        this.title = title;
    }

    public void setDate(LocalDate date) throws DateWrong{
        if (date.isBefore(LocalDate.now()) || date.isEqual(LocalDate.now())) {
            throw new DateWrong("The date is incorrect! The date is in the past or is just now.");
        }
        this.date = date;
    }

    // Method to book one place
    public void BookSeat() throws DateWrong, BookingSeatsError{
        if (date.isBefore(LocalDate.now()) || date.isEqual(LocalDate.now())) {
            throw new DateWrong("The date of the selected event is in the past or is just now.");
        }
        if (this.bookedSeats >= this.totalSeats) {
            throw new BookingSeatsError("Impossible to book a seat for the selected event!");
        }
        bookedSeats++;
    }

    // Method to cancel a booked place
    
    public void CancelBookedSeat() throws DateWrong, BookingSeatsError{
        if (date.isBefore(LocalDate.now())) {
            throw new DateWrong("The date of the selected event is in the past.");
        }
        if (this.bookedSeats <= 0) {
            throw new BookingSeatsError("No one booked a seat for for the selected event yet!");
        }
        bookedSeats--;
    }

    // Method to book one or more seats
    public void BookSeat(int RequestedSeats) throws DateWrong, BookingSeatsError{
        if (date.isBefore(LocalDate.now()) || date.isEqual(LocalDate.now())) {
            throw new DateWrong("The date of the selected event is in the past or is just now.");
        }
        if (this.bookedSeats + RequestedSeats >= this.totalSeats) {
            throw new BookingSeatsError("Impossible to book the seats requested for the selected event!");
        }
        bookedSeats = bookedSeats + RequestedSeats;
    }

    // Method to cancel one or more booked seats
    public void CancelBookedSeat(int RequestedSeats) throws DateWrong, BookingSeatsError{
        if (date.isBefore(LocalDate.now())) {
            throw new DateWrong("The date of the selected event is in the past.");
        }
        if (this.bookedSeats - RequestedSeats <= 0) {
            throw new BookingSeatsError("The requested cencellation of the booked seats goes too much far respect actual booked seats!");
        }
        bookedSeats = bookedSeats - RequestedSeats;
    }

    // Method to view the booked and totals seats of a specific event
    public void SeatsViewer(){
        int AvailableSeats = this.totalSeats - this.bookedSeats;
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println("         " + this.title);
        System.out.println("------------------------------------------");
        System.out.println("Seats Booked: " + this.bookedSeats);
        System.out.println("Seats Free:   " + AvailableSeats);
        System.out.println("------------------------------------------");
    }

    // .toString() override
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter) + " - " + title;
    }

}

