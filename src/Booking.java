public class Booking {
    static int bookingIdCounter = 1;
    Integer bookingId = 1;
    Employee employee;
    Car car;
    Double fare ;
    Character entryPoint;
    Character destination;

    public Booking(Employee employee, Car car,Character destination,Character ePoint) {
        this.bookingId=bookingIdCounter++;
        this.employee = employee;
        this.car = car;
        this.entryPoint=ePoint;
        this.destination=destination;
        car.setRestPosition(destination);
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public Double getFare() {
        return fare;
    }

    public Character getEntryPoint() {
        return entryPoint;
    }

    public Character getDestination() {
        return destination;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Car getCar() {
        return car;
    }

    public void addFair(Double amount)
    {
        this.fare=amount;
    }

    @Override
    public String toString() {
        return "\n"+employee.getEmpName() + "Booked CarType : "
                +car.getCarType() +" Fair Amount : "+ this.fare;
    }
}
