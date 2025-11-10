import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

public class BookingSystem {
    HashMap<Integer,Booking> bookings;//bookingId ---> Booking

    public BookingSystem() {
        this.bookings = new HashMap<>();
    }

    public void addBookings(Integer id,Booking booking)
    {
        bookings.put(id,booking);
    }

    public void generateReport()
    {
        Double total = 0.0;
        System.out.println("\n================== REPORT FOR IT COMPANY ===================\n");
        for(Map.Entry<Integer,Booking> bookingEntry: bookings.entrySet())
        {
            Booking booking = bookingEntry.getValue();
            Employee emp = booking.getEmployee();
            Car car = booking.getCar();
            Character sPoint = booking.getEntryPoint();
            Character ePoint = booking.getDestination();
            Double fair = booking.getFare();
            Integer distance = Math.abs(ePoint - sPoint);
            System.out.println("\n"+emp.getEmpName()+"\t\t"
                    +car.getCarType()+"\t\t"+distance
                    +" km " + "Pick Up : "
                    +sPoint+" Drop at "+ePoint
                    +" Total Amount : "+fair);
            total+=fair;
        }
        System.out.println("\n==================Total Fair Amount============ : "+total);
    }

}
