import java.util.HashMap;

public class ITCompany {
    HashMap<Integer,Employee> employees;

    public ITCompany() {
        this.employees = new HashMap<>();
    }

    public void addEmployee(Integer id,Employee emp)
    {
        employees.put(id,emp);
    }

    public Employee getEmp(Integer id)
    {
        return employees.get(id);
    }
}
