import java.util.*;
public class Employee {
    static int empCounter = 1;
    Integer empId;
    String empName;
    List<Booking> empBookings;
    Type role;

    public Employee(String empName, Type role) {
        this.empId=empCounter++;
        this.empName = empName;
        this.empBookings = new ArrayList<>();
        this.role = role;
    }

    public Integer getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public List<Booking> getEmpBookings() {
        return empBookings;
    }

    public Type getRole() {
        return role;
    }
}
