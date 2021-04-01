package banking_system;

// Saving class inherits Account class
public class Saving extends Account {
	
	// declaring variable using private access modifier
	private String accType;
	private String accNo_accType;
	private int maxTranNumberPerDay;
	private double maxTransAmountPerDay;
	private double minAmount;
	
	// constructor
	public Saving(int accNo, String name, int contact, String email, String city, int pincode, double balance, double interestRate, String ifsc, String upi, String accType, String accNo_accType, int maxTranNumberPerDay, double maxTransAmountPerDay, double minAmount) {
		super(accNo, name, contact, email, city, pincode, balance, interestRate, ifsc, upi);
		this.accType = accType;
		this.accNo_accType = accNo_accType;
		this.maxTranNumberPerDay = maxTranNumberPerDay;
		this.maxTransAmountPerDay = maxTransAmountPerDay;
		this.minAmount = minAmount;
	}

	// getter and setter methods for all the variables
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

	public int getMaxTranNumberPerDay() {
		return maxTranNumberPerDay;
	}

	public void setMaxTranNumberPerDay(int maxTranNumberPerDay) {
		this.maxTranNumberPerDay = maxTranNumberPerDay;
	}

	public double getMaxTransAmountPerDay() {
		return maxTransAmountPerDay;
	}

	public void setMaxTransAmountPerDay(double maxTransAmountPerDay) {
		this.maxTransAmountPerDay = maxTransAmountPerDay;
	}

	public double getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(double minAmount) {
		this.minAmount = minAmount;
	}

	@Override
	public String toString() {
		return "Saving [accType=" + accType + ", accNo_accType=" + accNo_accType + ", maxTranNumberPerDay="
				+ maxTranNumberPerDay + ", maxTransAmountPerDay=" + maxTransAmountPerDay + ", minAmount=" + minAmount
				+ "]";
	}
	
	// defining the method that will display the balance
	public double displayBalance() {
		System.out.println("\nBalance for this Saving account: " +balance);
		return balance;
	}
	
	// defining the method that will deposit amount
	public void depositeAmount(double depAmount) {
		double serviceCharge = 10.0;
		balance += depAmount - serviceCharge;
		System.out.println("\nThe amount deposited for this Saving account is: "+depAmount+"." +"\nNew balance after depoist is "+balance+" after deduction of "+serviceCharge+" as a service charge for Saving account.");
	}
	
	// defining the method that will withdraw the amount
	public void withdrawalAmount(double withAmount) {
		double serviceCharge = 10.0;
		balance -= withAmount + serviceCharge;
		System.out.println("\nThe withdrawn amount for this Saving account is: "+withAmount+"." +"\nNew balance after depoist is "+balance+" after deduction of "+serviceCharge+" as a service charge for Saving account.");
	}
	
	// defining the method that will transfer amount
	public void transferAmount(Account account, double transAmount) {
		boolean flag = false;
		if(flag){
			System.out.println("\nSorry! The account entered is Fixed Deposit, and in Fixed Deposit no money can be transferred!");
			System.out.println("\nAs there's no transfer possible,\nThe account holder "+this.name+" having account number as "+this.accNo+" has "+this.balance+" balance.\nThe account holder "+account.name+" having account number as "+account.accNo+" has "+account.balance+" balance.");   
        }  else {
			account.balance += transAmount;
			this.balance -= transAmount;
		}
	}
	
	// defining the method that will pay the bill
	public void payBills(String toWhom, double payAmount) {
		this.balance -= payAmount;
		if(toWhom == "Credit card bill"){
			System.out.println("\nThe bill for credit card has been paid succesfully!\nAfter the bill payment, the balance of your account is "+(this.balance));
		}else if(toWhom == "Electricity bill"){
			System.out.println("\nThe bill for electricty has been paid succesfully!\nAfter the bill payment, the balance of your account is "+(this.balance));
		}else if(toWhom == "Mobile recharge"){
			System.out.println("\nThe recharge for Mobile has been done succesfully!\nAfter the mobile recharge, the balance of your account is "+(this.balance));
		}else if(toWhom == "DTH recharge"){
			System.out.println("\nThe recharge for DTH has been done succesfully!\nAfter the DTH recharge, the  balance of your account is "+(this.balance));
		}
	}

	// defining the method that will perform upi transfer
	public void upiTransfer(Account account, double amount) {
		boolean flag = false;
		if(flag){
			System.out.println("\nSorry! The account entered is Fixed Deposit, and no amount can be transferred in the Fixed Deposit account!");
			System.out.println("\nAs there's no transfer possible,\nThe account holder "+this.name+" having account number as "+this.accNo+" has "+this.balance+" balance.\nThe account holder "+account.name+" having account number as "+account.accNo+" has "+account.balance+" balance.");   
        } else {
            account.balance += amount;
            this.balance -= amount;
            System.out.println("\nAmount "+amount+" is transffered to the account number "+account.accNo);
            System.out.println("\nAfter this transaction,\nThe account holder "+this.name+" having account number as "+this.accNo+" has "+this.balance+" balance.\nThe account holder "+account.name+" having account number as "+account.accNo+" has "+account.balance+" balance.");  
        }
	}
}
