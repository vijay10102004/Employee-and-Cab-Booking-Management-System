import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        CabAndEmpBookingManagementSystem cabAndEmpBookingManagementSystem = new CabAndEmpBookingManagementSystem();
        Scanner sc = new Scanner(System.in);

        while(true)
        {
            System.out.println("\n1.ADD EMPLOYEE" +
                    "\n2.ADD CAR" +
                    "\n3.BOOK A RIDE" +
                    "\n4.SHOW REPORT" +
                    "\n5.EXIT");
            System.out.println("\nENTER THE CHOICE : ");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    cabAndEmpBookingManagementSystem.addEmployee();
                    break;
                case 2:
                    cabAndEmpBookingManagementSystem.addCar();
                    break;
                case 3:
                    cabAndEmpBookingManagementSystem.bookRide();
                    break;
                case 4:
                    cabAndEmpBookingManagementSystem.showMontlyReport();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}