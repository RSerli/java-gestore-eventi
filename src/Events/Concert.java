package Events;

import Exceptions.DateWrong;
import Exceptions.NameEventError;
import Exceptions.WrongTotalSeats;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concert extends Occurrence{

    private Double ticketPrice;
    private LocalTime startingTime;
    
    // Constructor
    public Concert(String title, LocalDate date, int totalSeats, Double ticketPrice, LocalTime startingTime) throws NameEventError, DateWrong, WrongTotalSeats {
        super(title, date, totalSeats);
        this.ticketPrice = ticketPrice;
        this.startingTime = startingTime;
    }

    // Getter e Setter

    public Double getTicketPrice() {
        return ticketPrice;
    }
    
    public LocalTime getStartingTime() {
        return startingTime;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setStartingTime(LocalTime startingTime) {
        this.startingTime = startingTime;
    }

    // Method to format features

    public String DateTimeFormatter (){
        DateTimeFormatter formatterDataTemplate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String DataFormatted = date.format(formatterDataTemplate);
        DateTimeFormatter formatterTimeTemplate = DateTimeFormatter.ofPattern("HH:mm");
        String TimeFormatted = this.startingTime.format(formatterTimeTemplate);
        return DataFormatted + " " + TimeFormatted;
    }

    public String PrizeFormatter (){
        BigDecimal convertedTicketPrice = new BigDecimal(this.ticketPrice);
        NumberFormat formatterCurrencyTemplate = NumberFormat.getCurrencyInstance(Locale.ITALY);
        String formattedTicketPrize = formatterCurrencyTemplate.format(convertedTicketPrice);
        return formattedTicketPrize;
    }

    // .toString() override
    @Override
    public String toString() {
        return this.DateTimeFormatter() + " - " + this.title + " " + this.PrizeFormatter();
    }
}
