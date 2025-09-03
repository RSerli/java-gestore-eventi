package Events;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event{
    private String title;
    private LocalDate date;
    private final int totalSeats;
    private int bookedSeats;

    // Constructor
    public Event(String title, LocalDate date, int totalSeats) {
        //Check if the date set by the user is correct
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The date is incorrect! The date is in the past.");
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
    

    // Metodo per prenotare
    

    // Metodo per disdire
    

    // .toString() override
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter) + " - " + title;
    }
}

