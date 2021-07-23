package employee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UseEmployee {
	
	public static void main(String[] args) {
		
		try {
			Log my_log = new Log("EmployeeLog.txt");
			my_log.logger.info("Employee system was accessed.");
		}
		catch (Exception e) {
		}
		
		EmployeeServiceImpl imp = new EmployeeServiceImpl();
		System.out.println("Welcome!");
		Scanner s = new Scanner(System.in);
		int sw = 0; 
		while(true) {
			System.out.println("\nEnter a number from the Main Menu:\n"
					+ "1. Display all employees\n"
					+ "2. Update employee information\n"
					+ "3. Find by employee number\n"
					+ "4. Calculate an employee's yearly salary\n"
					+ "5. Delete an employee from the system\n"
					+ "6. Quit the employee management system");
			try {
				sw = s.nextInt();
				}
			catch(InputMismatchException e) {
					s.nextLine();
				}
			switch(sw) {
			case(1):
				imp.displayAllEmployees();
				break;			
			case(2):
				imp.updateEmployee();
				try {
					Log my_log = new Log("EmployeeLog.txt");
					my_log.logger.info("Employee system was updated.");
				}
				catch (Exception e) {
				}
				break;	
			case(3):
				System.out.println("Enter an ID number to find employee:");
				int id = s.nextInt();
				System.out.println("The employee with ID number " + id + " is: \n"
				+ imp.findByEmployeeNo(id).toString());
				break;		
			case(4):
				System.out.println("Enter the ID for the employee to calculate salary:");
				id = s.nextInt();
				double salary = imp.calculateYearlySalary(id);
				if(salary == -1) {
					System.out.println("There is no employee with the ID Number: " + id);
				}else {
					System.out.println("The yearly salary for Employee: " + imp.findByEmployeeNo(id).getEmpName() + " is $" + salary);
				}
				break;
			case(5):
				imp.deleteEmployee();
				break;
			case(6):
				s.close();
				try {
					Log my_log = new Log("EmployeeLog.txt");
					my_log.logger.info("Employee system was closed.");
				}
				catch (Exception e) {
				}
				System.out.println("Have a good day. Goodbye.");
				System.exit(0);
			default:
				System.out.println("Please enter a valid option.");		
			}
		}

	}
	
}