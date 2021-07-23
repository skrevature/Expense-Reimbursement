package employee;

public interface EmployeeService {

	public void displayAllEmployees();
	public void calculateYearlySalary(Employee e1);
	public Employee findByEmployeeNo(int empNo);
	public void updateEmployee(Employee e1);
	public void deleteEmployee(Employee e1);
	
}
