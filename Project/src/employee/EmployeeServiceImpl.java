package employee;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {

	static List<Employee> team = new ArrayList<Employee>() {

			private static final long serialVersionUID = 1L;
			{
			add(new Employee(1, "Nathan Jones", 2000, new Address("Longview", "TX", 75645)));
			add(new Employee(2, "David Letterman", 2100, new Address("Tyler", "TX", 75640)));
			add(new Employee(3, "Patrick Starr", 1900, new Address("Marshall", "TX", 75605)));
			}
	};

	public void displayAllEmployees() {
		for(Employee emp : team) {
			System.out.println(emp.toString());
		}
	}

	public double calculateYearlySalary(int id) {
		double Yearly = 0;
		for(Employee emp : team) {
			if(emp.getEmpNo() == id) {
				Yearly = emp.getBiweekly()*26;
			}
		}
		return Yearly;
	}

	public Employee findByEmployeeNo(int empNo) {
		return team.stream().filter(e -> e.getEmpNo() == empNo).findFirst().orElse(null);
	}

	public void updateEmployee() {
		System.out.println("Enter the ID of the employee that you want to update:\n");
		Scanner s = new Scanner(System.in);
		int id = s.nextInt();
		int flag = 1;
		for(Employee emp : team) {
			if(emp.getEmpNo() == id) {
				flag = 0;
				int sw = 0;
				Task:
				while(true) {
					System.out.println("\nEnter a number from the Update Menu:\n"
							 + "1: Update the employee Name\n"
							 + "2: Update the employee Biweekly Pay\n"
							 + "3: Update the employee Address\n"
							 + "4: Back to Main Menu\n");
					try {
						sw = s.nextInt();
						}
					catch(InputMismatchException e) {
							s.nextLine();
						}
				switch(sw) {
				case(1):
					System.out.println("Currently updating " + emp.getEmpName() + "'s name\n");
					System.out.println("Enter the new name:\n");
					s.nextLine();
					String name = s.nextLine();
					emp.setEmpName(name);
					System.out.println("The employee's name is now set to: " + emp.getEmpName());
					break;
				case(2):
					System.out.println("Currently updating " + emp.getEmpName() + "'s Biweekly Pay\n"
							+ "It is currently set to: " + emp.getBiweekly());
					System.out.println("Enter the new Biweekly Pay:\n");
					double salary = s.nextDouble();
					emp.setBiweekly(salary);
					System.out.println("The employee's Biweekly Pay is now set to: " + emp.getBiweekly());
					break;	
				case(3):
					System.out.println("Currently updating " + emp.getEmpName() + "'s Address\n"
							+ "It is currently set to: "
							+ emp.getAddress().getCity() + ", "
							+ emp.getAddress().getState() + " "
							+ emp.getAddress().getZipcode());
					System.out.println("Enter the new city:\n");
					s.nextLine();
					String city = s.nextLine();
					System.out.println("Enter the new state:\n");
					String state = s.nextLine();
					System.out.println("Enter the new zipcode:\n");
					Integer zipcode = s.nextInt();
					emp.setAddress(new Address(city,state,zipcode));
					System.out.println("The employee's Address is now set to: "
							+ emp.getAddress().getCity() +", " + emp.getAddress().getState());
					break;
				case(4):
					break Task;
				default:
					System.out.println("Please enter a valid option.");
				}
				}
			}
			
		}
		if(flag == 1) {
			System.out.println("There is no employee with the ID: " + id);
		}
	}
	
	public void deleteEmployee() {
		System.out.println("Enter the ID of the employee that you wish to delete:\n");
		Scanner s = new Scanner(System.in);
		int id = s.nextInt();
		int flag = 1;
		for(Employee emp : team) {
			if(emp.getEmpNo() == id) {
				flag = 0;
				System.out.println("Are you sure you want to delete employee?\n" + emp.toString() + "\nEnter Yes or No:");
				s.nextLine();
				String confirm = s.nextLine();
				if(confirm.toUpperCase().equals("YES")) {
					team.remove(emp);
					try {
						Log my_log = new Log("EmployeeLog.txt");
						my_log.logger.info("An employee was delete from the system.");
					}
					catch (Exception e) {
					}
					break;
				}else if(confirm.toUpperCase().equals("NO")) {
					System.out.println("Returning to Main Menu");
					break;
				}else {
					System.out.println("Invalid option, returning to Main Menu");
					break;
				}
			}
		}
		if(flag == 1) {
			System.out.println("There was no user with the id: " + id);
		}
	}
	
	@Override
	public void calculateYearlySalary(Employee e1) {
	}
	
	
	@Override
	public void updateEmployee(Employee e1) {	
	}
	
	@Override
	public void deleteEmployee(Employee e1) {	
	}
}