
import Events.Concert;
import Events.Occurrence;
import Exceptions.BookingSeatsError;
import Exceptions.DateWrong;
import Exceptions.NameEventError;
import Exceptions.WrongTotalSeats;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //Occurrence ev1 = new Occurrence("Rammstein Concert", LocalDate.of(2026, 6, 15), 1500);
        Scanner scan = new Scanner(System.in);

        try {

             //User input Occcurence
            System.out.print("Insert the name of the event: ");
            String userInputEventName = scan.nextLine();
            System.out.print("Insert the year of the event: ");
            Integer userInputYearEvent = scan.nextInt();
            System.out.print("Insert the month of the event: ");
            Integer userInputMonthEvent = scan.nextInt();
            System.out.print("Insert the day of the month of the event: ");
            Integer userInputDayEvent = scan.nextInt();
            System.out.print("Insert the total seats of the event: ");
            Integer userInputTotalSeatsEvent = scan.nextInt();
            scan.nextLine(); // Removing buffer

            //allocate new occurrence given by the user
            Occurrence ev1 = new Occurrence(userInputEventName, LocalDate.of(userInputYearEvent, userInputMonthEvent, userInputDayEvent), userInputTotalSeatsEvent);

            //To String OverRide
            System.out.println("\n" + ev1.toString());

            // POSSIAMO AGGIUGERE UN LOOP DO/WHILE PER OGNI RICHIESTA DI PRENOTAZIONE O DISDETTA FINCHÈ NON ANNULLIAMO L'OPERAZIONE

            //Ask the user if he wants book one or more seat
            System.out.println("\nDo you want to book some seats? -Y-Yes -N-No");
            String userBookingAnswer = scan.nextLine();
            if (userBookingAnswer.equalsIgnoreCase("Y")){
                System.out.print("How many seats do you wanna book? ");
                int userSeatsRequired = scan.nextInt();
                scan.nextLine(); // Removing buffer
                try {
                    ev1.BookSeat(userSeatsRequired);
                    System.out.println("Reservation succesful!");
                } catch (DateWrong e) {
                    System.out.println("Event Date Error: " + e.getMessage());
                } catch (BookingSeatsError e){
                    System.out.println("Booking Seats Error: "+ e.getMessage());
                }
            }else{
                System.out.println("Operation revoked");
            }

            //View of Seats
            ev1.SeatsViewer();

            //Ask the user if he wants cancel one of more booked seats
            System.out.println("Do you want to cancel some booked seats? -Y-Yes -N-No");
            String userCancelAnswer = scan.nextLine();
            if (userCancelAnswer.equalsIgnoreCase("Y")){
                System.out.print("How many booked seats do you wanna cancel? ");
                int userSeatsRequired = scan.nextInt();
                try {
                    ev1.CancelBookedSeat(userSeatsRequired);
                    System.out.println("Cancellation succesful!");
                } catch (DateWrong e) {
                    System.out.println("Event Date Error: "+ e.getMessage());
                } catch (BookingSeatsError e){
                    System.out.println("Booking Seats Error: "+ e.getMessage());
                }
            }else{
                System.out.println("Operation revoked");
            }

            //View of Seats
            ev1.SeatsViewer();

        }catch(NameEventError e){
            System.out.println("Error in the name inserted by the user: "+ e.getMessage());
        }catch(DateWrong e){
            System.out.println("Error in the date inserted by the user: "+ e.getMessage());
        }catch(WrongTotalSeats e){
            System.out.println("Error in the number of total seats inserted by the user: "+ e.getMessage());
        }

       //---------------------------------------------------------------------------------------------------

        System.out.println("\n    CONCERT INPUT");
        try {
            //User input Occcurence
            System.out.print("Insert the name of the concert: ");
            String userInputConcertName = scan.nextLine();
            System.out.print("Insert the year of the concert: ");
            Integer userInputYearConcert = scan.nextInt();
            System.out.print("Insert the month of the concert: ");
            Integer userInputMonthConcert = scan.nextInt();
            System.out.print("Insert the day of the month of the concert: ");
            Integer userInputDayConcert = scan.nextInt();
            System.out.print("Insert the begin hour of the concert: ");
            Integer userInputBeginHourOfConcert = scan.nextInt();
            System.out.print("Insert the begin minutes of the concert: ");
            Integer userInputBeginMinutsOfConcert = scan.nextInt();
            System.out.print("Insert the price of the ticket: ");
            Double userInputConcrtPriceTicket = scan.nextDouble();
            System.out.print("Insert the total seats of the concerrt: ");
            Integer userInputTotalSeatsConcert = scan.nextInt();
    
            //allocate new occurrence given by the user
            Occurrence Conc1 = new Concert(userInputConcertName, LocalDate.of(userInputYearConcert, userInputMonthConcert, userInputDayConcert), userInputTotalSeatsConcert, userInputConcrtPriceTicket, LocalTime.of(userInputBeginHourOfConcert, userInputBeginMinutsOfConcert));
            
            //To String OverRide
            System.out.println("\n" + Conc1.toString());

        }catch(NameEventError e){
            System.out.println("Error in the name inserted by the user: "+ e.getMessage());
        }catch(DateWrong e){
            System.out.println("Error in the date inserted by the user: "+ e.getMessage());
        }catch(WrongTotalSeats e){
            System.out.println("Error in the number of total seats inserted by the user: "+ e.getMessage());
        }finally{
            scan.close();
        }
        
    }
}
