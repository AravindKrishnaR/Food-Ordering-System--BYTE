package pojo;

public class Customer extends User {

	private String address;

	public Customer() {
		super();
	}

	public String getAddress() {
		return address;
	}

	public Customer(String username, String password, String name, String email, String phoneNo, String address) {
		super(username, password, name, email, phoneNo);
		this.address = address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
