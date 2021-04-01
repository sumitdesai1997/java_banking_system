package banking_system;

public class Current extends Saving {
	String panCardNo;

	public Current(int accNo, String name, int contact, String email, String city, int pincode, double balance, double interestRate, String ifsc, String upi, String accType, String accNo_accType, int maxTranNumberPerDay, double maxTransAmountPerDay, double minAmount, String panCardNo) {
		super(accNo, name, contact, email, city, pincode, balance, interestRate, ifsc, upi, accType, accNo_accType, maxTranNumberPerDay, maxTransAmountPerDay, minAmount);
		this.panCardNo = panCardNo;
	}

	public String getPanCardNo() {
		return panCardNo;
	}

	public void setPanCardNo(String panCardNo) {
		this.panCardNo = panCardNo;
	}

	@Override
	public String toString() {
		return "Current [panCardNo=" + panCardNo + ", accNo=" + accNo + ", name=" + name + ", contact=" + contact
				+ ", email=" + email + ", city=" + city + ", pincode=" + pincode + ", balance=" + balance
				+ ", interestRate=" + interestRate + ", ifsc=" + ifsc + ", upi=" + upi + "]";
	}

		// defining the method that will display the balance
		public double displayBalance() {
			System.out.println("\nBalance for this Current account: " +balance);
			return balance;
		}
		
		// defining the method that will deposit amount
		public void depositeAmount(double depAmount) {
			double serviceCharge = 20.0;
			balance += depAmount - serviceCharge;
			System.out.println("\nThe amount deposited for this Current account is: "+depAmount+"." +"\nNew balance after depoist is "+balance+" after deduction of "+serviceCharge+" as a service charge for Current account.");
		}
		
		// defining the method that will withdraw the amount
		public void withdrawalAmount(double withAmount) {
			double serviceCharge = 10.0;
			balance -= withAmount + serviceCharge;
			System.out.println("\nThe withdrawn amount for this Current account is: "+withAmount+"." +"\nNew balance after depoist is "+balance+" after deduction of "+serviceCharge+" as a service charge for Current account.");
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
				System.out.println("\nAmount "+transAmount+" is transffered to the account number "+account.accNo);
				System.out.println("\nAfter this transaction,\nThe account holder "+this.name+" having account number as "+this.accNo+" has "+this.balance+" balance.\nThe account holder "+account.name+" having account number as "+account.accNo+" has "+account.balance+" balance.");
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
