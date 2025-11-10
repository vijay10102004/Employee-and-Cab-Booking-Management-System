🚕 Employee–Cab Booking Management System (Java Console Application)
🧩 Overview

This project simulates a Cab Booking Management System between two companies:

ABC Pvt. Ltd. – The IT company where employees work.

BCA Cabs – The car rental company providing cab services.

Employees of ABC Pvt. Ltd. can book company cabs (managed by BCA Cabs) for daily commutes:

Home → Office

Office → Home

The system automatically allocates a car based on the employee’s role, tracks booking details, and generates a monthly usage report.

The project is implemented using Java OOP concepts and runs as a menu-driven console application.

⚙️ Features
👨‍💼 Employee Management

Add new employees with a unique Employee ID.

Assign roles (Manager, Developer, Intern, Tester).

Each role has specific cab preferences.

🚗 Car Management

Add available cars with car type and cost per ride.

Car types include:

ROLLS ROYCE

PORSHE

SWEDEN

📅 Cab Booking

Employees can book rides between pickup and drop points.

Fare is calculated as:

Fare = |Drop - Pickup| × Cost per ride


Cars are allocated based on role priority:

Manager → Rolls Royce > Porshe > Sweden

Developer → Porshe > Sweden

Tester/Intern → Sweden only

If no car is available, booking is cancelled.

📊 Monthly Report

Shows all employee bookings with:

Total rides

Total distance travelled

Total fare

Summarized in a tabular console format.

🧠 Object-Oriented Design
Class	Responsibility
Employee	Stores employee ID, name, and role.
Car	Stores car ID, car type, and cost per ride.
Booking	Represents a ride record (employee, car, fare, route).
CarCompany	Manages all cars and allocations.
ITCompany	Manages employees and lookup by ID.
BookingSystem	Maintains all bookings and report generation.
CabAndEmpBookingManagementSystem	Acts as controller — manages input, menu, and overall coordination.
Main	Contains main() and launches the console UI.


🧱 Directory Structure
src/
 ├── Car.java
 ├── CarCompany.java
 ├── CarType.java
 ├── Type.java
 ├── Employee.java
 ├── ITCompany.java
 ├── Booking.java
 ├── BookingSystem.java
 ├── CabAndEmpBookingManagementSystem.java
 └── Main.java

🚀 How to Run

Clone or copy the source code into a Java project.

Compile all .java files.

Run Main.java.

Use the console menu to interact with the system.

🧾 Future Enhancements

Add file persistence for bookings (.csv or .txt report generation).

Implement car availability time slots.

Add login authentication for employees.

Use database (MySQL/PostgreSQL) for persistent data storage.

Integrate with a REST API backend for real-world simulation.

🧑‍💻 Author

Vijay N K
Java Developer | System Design Learner | Aspiring Software Engineer
