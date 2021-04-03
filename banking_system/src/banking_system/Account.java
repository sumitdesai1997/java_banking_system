package banking_system;

// abstract Account class that will become super class for all other account type classes
public class Account {
	
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
	public Account() {
		this.accNo = 0;
        this.name = "";
        this.contact = 0;
        this.email = "";
        this.city = "";
        this.pincode = 0;
        this.balance = 0.0;
        this.interestRate = 0.0;
        this.ifsc = "";
        this.upi = "";
	}
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
	public double displayBalance() {
		System.out.println("This method will display the balance of the account");
		return 0;
	};
	
	public void depositeAmount(double depAmount) {
		System.out.println("This method will help to deposit the amount into the account");
	};
	
	public void withdrawalAmount(double withAmount) {
		System.out.println("This method will help to withdraw the amount from the account");
	};
	
	public void transferAmount(Account account, double transAmount) {
		System.out.println("This method will help to transfer the amount from one account to other the account");
	};
	
	public void payBills(String toWhom, double payAmount) {
		System.out.println("This method will help to pay the bills from the account");
	};
	
	public void upiTransfer(Account account, double amount) {
		System.out.println("This method will help to perform UPI transferbetween the bank accounts");
	};
	
}
