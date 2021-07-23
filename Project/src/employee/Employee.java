package employee;

public class Employee {

	private int empNo;
	private String empName;
	private double biweekly;
	private Address address;
	
	public Employee(int empNo, String empName, double biweekly, Address address) {
		this.empNo = empNo;
		this.empName = empName;
		this.biweekly = biweekly;
		this.address = address;
		
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setBiweekly(double biweekly) {
		this.biweekly = biweekly;
	}
	public Double getBiweekly() {
		return biweekly;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Address getAddress() {
		return address;
	}
	
	@Override
	public String toString() {
		return "Employee #: " + empNo + " Name: " + empName +
				" Biweekly Pay: $" + biweekly + " Address: " + address;				
	}

}
