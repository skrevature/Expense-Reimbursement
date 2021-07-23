package employee;

public class Address {

	String City;
	String State;
	int Zipcode;
	
	public Address(String City, String State, int Zipcode) {
		this.City = City;
		this.State = State;
		this.Zipcode = Zipcode;
	}
	
	public void setCity(String City) {
		this.City = City;
	}
	
	public String getCity() {
		return City;
	}
	
	public void setState(String State) {
		this.State = State;
	}
	
	public String getState() {
		return State;
	}
	
	public void setZipcode(int Zipcode) {
		this.Zipcode = Zipcode;
	}
	
	public Integer getZipcode() {
		return Zipcode;
	}
	
	@Override
	public String toString() {
		return City + ", " + State + " " + Zipcode;
	}
	
}
