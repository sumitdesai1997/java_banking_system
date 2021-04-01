package banking_system;

// abstract Account class that will become super class for all other account type classes
abstract public class Account {
	
	// declaring variable using protected access modifier
	protected int accNo;
	protected String name;
	protected int contact;
	protected String email;
	protected String city;
	protected int pincode;
	protected double balance;
	protected double interestRate;
	protected String ifsc;
	protected String upi;
	
	// constructor
	public Account(int accNo, String name, int contact, String email, String city, int pincode) {
		this.accNo = accNo;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.city = city;
		this.pincode = pincode;
		this.balance = 0.0;
		this.interestRate = 0.0;
		this.ifsc = "SBCO60466";
		this.upi = name + "okaccount";
	}

	
	// getter and setter methods for all the variables
	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getUpi() {
		return upi;
	}

	public void setUpi(String upi) {
		this.upi = upi;
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", name=" + name + ", contact=" + contact + ", email=" + email + ", city="
				+ city + ", pincode=" + pincode + ", balance=" + balance + ", interestRate=" + interestRate + ", ifsc="
				+ ifsc + ", upi=" + upi + "]";
	}
	
	
	// all the abstract methods that will be defined in child classes
	abstract public double displayBalance();
	
	abstract public void depositeAmount(double depAmount);
	
	abstract public void withdrawalAmount(double withAmount);
	
	abstract public void transferAmount(Account account, double transAmount);
	
	abstract public void payBills(String toWhom, double payAmount);
	
	abstract public void upiTransfer(Account account, double amount);
	
}
