package banking_system;

public class FixedDeposit extends Account{
	protected String accType;
	protected String accNo_accType;
	protected double amountToDeposit;
	protected int durationInMonth;
	
	public FixedDeposit(int accNo, String name, long contact, String email, String city, int pincode, double amountToDeposit, int durationInMonth) {
		super(accNo, name, contact, email, city, pincode);
		this.accType = "Fixed Deposit";
		this.accNo_accType = accNo+"_"+"Fixed Deposit";
		this.amountToDeposit = amountToDeposit;
		this.durationInMonth = durationInMonth;
		this.interestRate = 8.0;
		this.balance = amountToDeposit;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
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
		return "Fixed Deposit [accNo=" + accNo + ", name=" + name +", contact=" + contact + ", email=" + email +
				", city=" + city + ", pincode=" + pincode + ", balance=" + balance + ", interestRate=" + interestRate +
				", ifsc=" + ifsc + ", upi=" + upi +", accType=" + accType + ", accNo_accType=" + accNo_accType + ", amountToDeposit="
				+ amountToDeposit + ", durationInMonth=" + durationInMonth + "]";
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
