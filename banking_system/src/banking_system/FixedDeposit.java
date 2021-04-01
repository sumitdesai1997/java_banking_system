package banking_system;

public class FixedDeposit extends Account{
	String accNo_accType;
	double amountToDeposit;
	int durationInMonth;
	
	public FixedDeposit(int accNo, String name, int contact, String email, String city, int pincode, double balance, double interestRate, String ifsc, String upi, String accNo_accType, double amountToDeposit, int durationInMonth) {
		super(accNo, name, contact, email, city, pincode, balance, interestRate, ifsc, upi);
		this.accNo_accType = accNo_accType;
		this.amountToDeposit = amountToDeposit;
		this.durationInMonth = durationInMonth;
	}

	public String getAccNo_accType() {
		return accNo_accType;
	}

	public void setAccNo_accType(String accNo_accType) {
		this.accNo_accType = accNo_accType;
	}

	public double getAmountToDeposit() {
		return amountToDeposit;
	}

	public void setAmountToDeposit(double amountToDeposit) {
		this.amountToDeposit = amountToDeposit;
	}

	public int getDurationInMonth() {
		return durationInMonth;
	}

	public void setDurationInMonth(int durationInMonth) {
		this.durationInMonth = durationInMonth;
	}

	@Override
	public String toString() {
		return "FixedDeposit [accNo_accType=" + accNo_accType + ", amountToDeposit=" + amountToDeposit
				+ ", durationInMonth=" + durationInMonth + ", accNo=" + accNo + ", name=" + name + ", contact="
				+ contact + ", email=" + email + ", city=" + city + ", pincode=" + pincode + ", balance=" + balance
				+ ", interestRate=" + interestRate + ", ifsc=" + ifsc + ", upi=" + upi + "]";
	}
	
	public double displayBalance() {
		System.out.println("\nBalance for this Fixed Deposit account: " +balance);
		return balance;
	}
	
	// defining the method that will deposit amount
	public void depositeAmount(double depAmount) {
		System.out.println("\nThis is Fixed Deposit account, and no more amount can be deposited!");
	}
	
	// defining the method that will withdraw the amount
	public void withdrawalAmount(double withAmount) {
		this.balance = 0.0;
		System.out.println("\nThe withdrawn amount for this Fixed Deposit account is: "+withAmount+".\nNew balance after withdrawn is "+this.balance);
	}
	
	// defining the method that will transfer amount
	public void transferAmount(Account account, double transAmount) {
		System.out.println("\nThis is Fixed Deposit account, and no transaction can be done from this account!");   
	}
	
	// defining the method that will pay the bill
	public void payBills(String toWhom, double payAmount) {
		System.out.println("\\nThis is Fixed Deposit account, and no bills can be paid from this account!");  		
	}
	// defining the method that will perform upi transfer
	public void upiTransfer(Account account, double amount) {
		System.out.println("\\nThis is Fixed Deposit account, and no transaction can be done from this account!");  
	}
		
}
