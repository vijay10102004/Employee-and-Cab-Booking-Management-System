import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CabAndEmpBookingManagementSystem {
    CarCompany carCompany;
    ITCompany itCompany;
    BookingSystem bookingSystem;
    Scanner sc=new Scanner(System.in);
    public CabAndEmpBookingManagementSystem() {
        this.carCompany = new CarCompany();
        this.itCompany = new ITCompany();
        this.bookingSystem= new BookingSystem();
    }

     public void addEmployee()
     {
         System.out.print("\nENTER THE NAME OF THE EMPLOYEE : \n");
         String name = sc.nextLine();
         System.out.print("ENTER THE ROLE (1.MANAGER/2.DEVELOPER/3.INTERN/4.TESTER) : \n");
         Integer t = sc.nextInt();
         sc.nextLine();
         Type type = setType(t);
         Employee newEmployee = new Employee(name,type);
         itCompany.addEmployee(newEmployee.getEmpId(),newEmployee);
         System.out.print("\n======= Your EMP ID IS ========= "+newEmployee.getEmpId());
         System.out.print("\n============ Employee Added Successfully ========");
     }

     private Type setType(Integer type)
     {
         if(type==1)
         {
             return Type.MANAGER;
         }
         else if(type==2)
         {
             return Type.DEVELOPER;
         }
         return type==3?Type.INTERN:Type.TESTER;
     }

     public void addCar()
     {
         System.out.println("\nEnter Car Type : (1.ROLLS ROYCE/2.PORSE/3.SWEDEN)");
         CarType carType = setCarType(sc.nextInt());
         System.out.println("\nEnter the cost per Amount : ");
         Double amount = sc.nextDouble();
         Car car = new Car(carType,amount);
         carCompany.addCars(car.getCarId(),car);
         System.out.println("=============== Car Added Sucessfully =================");
     }

     private CarType setCarType(Integer type)
     {
         if(type==1)
         {
             return CarType.ROLLSROYCE;
         }
         return type==2?CarType.PORSHE:CarType.SWEDEN;
     }

     public void bookRide()
     {
         System.out.println("\nEnter Your EmpId ");
         Integer id = sc.nextInt();
         System.out.println("\nEnter PickUp Point : ");
         Character pickUpPoint = sc.next().charAt(0);
         System.out.println("\nEnter Drop Point : ");
         Character dropPoint = sc.next().charAt(0);
         Employee emp = itCompany.getEmp(id);
         Car car = allocateCar(emp,pickUpPoint,dropPoint);
         if(car==null)
         {
             System.out.println("\n==== BOOKING CANCELLED===\n");
             return;
         }
         Booking newBooking = new Booking(emp,car,dropPoint,pickUpPoint);
         Double fair = Math.abs((double) (dropPoint-pickUpPoint)) * car.getAmountPerRide();
         newBooking.addFair(fair);
         bookingSystem.addBookings(newBooking.getBookingId(),newBooking);
         System.out.println("\nBooking Succesfully Allocated Car "+car.getCarType()+" Amount Of "+newBooking.getFare());
     }

     private Car allocateCar(Employee emp,Character pTime,Character dTime)
     {
         Type type = emp.getRole();
         if(type.equals(Type.MANAGER))
         {
             return allocateCarEmpManager(pTime,dTime);
         }
         else if(type.equals(Type.DEVELOPER))
         {
             return allocateCarEmpDeveloper(pTime,dTime);
         }
         else if(type.equals(Type.TESTER))
         {
             return allocateCarEmpCommon(pTime,dTime);
         }
         else
         {
             return allocateCarEmpCommon(pTime,dTime);
         }
     }

     protected Car allocateCarEmpManager(Character pTime,Character dTime)
     {
         HashMap<Integer,Car> cars = carCompany.getCars();
         Car allotedCar = searchCarForType(cars,CarType.ROLLSROYCE,pTime,dTime);
         if(allotedCar!=null)
         {
             return allotedCar;
         }
         allotedCar = searchCarForType(cars,CarType.PORSHE,pTime,dTime);
         if(allotedCar!=null)
         {
             return allotedCar;
         }
         allotedCar = searchCarForType(cars,CarType.SWEDEN,pTime,dTime);
         if(allotedCar!=null)
         {
             return allotedCar;
         }
         return allotedCar;
     }

    protected Car allocateCarEmpDeveloper(Character pTime,Character dTime)
    {
        HashMap<Integer,Car> cars = carCompany.getCars();
        Car allotedCar = searchCarForType(cars,CarType.PORSHE,pTime,dTime);
        if(allotedCar!=null)
        {
            return allotedCar;
        }
        allotedCar = searchCarForType(cars,CarType.SWEDEN,pTime,dTime);
        if(allotedCar!=null)
        {
            return allotedCar;
        }
        return allotedCar;
    }

    protected Car allocateCarEmpCommon(Character pTime,Character dTime)
    {
        HashMap<Integer,Car> cars = carCompany.getCars();
        Car allotedCar = searchCarForType(cars,CarType.SWEDEN,pTime,dTime);
        if(allotedCar!=null)
        {
            return allotedCar;
        }
        return allotedCar;
    }

     public Car searchCarForType(HashMap<Integer,Car> cars,CarType type,Character pTime,Character dTime)
     {
         Car allotedCar = null;
         Integer distance = 0;
         for(Map.Entry<Integer,Car> car : cars.entrySet())
         {
             Car c = car.getValue();
             if(c.getCarType().equals(type) && (Math.abs(pTime-dTime) < distance || distance==0))
             {
                 distance = Math.abs(pTime-dTime);
                 allotedCar = c;
             }
         }
         return allotedCar;
     }

     public void showMontlyReport()
     {
         bookingSystem.generateReport();
     }
}
