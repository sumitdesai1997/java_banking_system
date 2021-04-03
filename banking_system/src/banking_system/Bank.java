package banking_system;


import java.util.*;
//import java.io.*;

public class Bank {

	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		ArrayList<Account> accountList = new ArrayList<>();
		
		fillData(accountList, sc);
		
		editAccountDetails(accountList, sc);
		
		performOperations(accountList, sc);
	}
	
	public static void fillData(ArrayList<Account> accountList, Scanner sc) {
		
		do {
			int flag = 0 ;
			
			System.out.println("\nEnter the name for account holder:");
	        String name = sc.next();
	        
	        System.out.println("\nEnter the contact number for account holder:");
	        int contact = sc.nextInt();
	        
	        System.out.println("\nEnter the email id for account holder:");
	        String email = sc.next();
	        
	        System.out.println("\nEnter the city for account holder:");
	        String city = sc.next();
	        
	        System.out.println("\nEnter the pincode for account holder:");
	        int pincode = sc.nextInt();
			
	        do {     
	            //if the same user create the different types of account then flag will have the value of 1
	            if(flag == 1){
	            	 System.out.println("\nFor "+name+", We've already stored the name, contact number, email id, city and pincode for the user! Please provide the remaining details as follow:");
	            }
	            
	            System.out.println("\nPlease choose account type from below: \n 1. Saving account \n 2. Current account \n 3. Fixed Deposit account");
	            
	         // switch case to select from the different type of accounts
	            switch (sc.nextInt()){
	                case 1:
	                    // Saving account
	                    flag = 0;
	                    for (Account account:accountList){
	                        if (name == account.name && account instanceof Saving){
	                            flag = 1;
	                        }
	                    }
	                    
	                    if(flag == 1){
	                    	 System.out.println("\n The client "+name+" already has Saving account. Please choose other option!");
	                    } else {
	                        String accType = "Saving";
	                        System.out.println("\nPlease enter the Saving account number:");
	                        int accNo = sc.nextInt();
	                        
	                        System.out.println("\nAs this is Saving account, you have to deposit minimum amount of 1000.0");
	                        accountList.add(new Saving(accNo, name, contact, email, city, pincode, accType));
	                        System.out.println("For "+name+", Saving account created succesfully!");                       
	                    }
	                    break;
	                case 2:
	                    // Current account
	                    flag = 0;
	                    for (Account account:accountList){
	                        if (name == account.name && account instanceof Current){
	                            flag = 1;
	                        }
	                    }
	                    
	                    if(flag == 1){
	                    	System.out.println("\n The client "+name+" already has Current account. Please choose other option!");
	                    } else {
	                        String accType = "Current";
	                        System.out.println("\nPlease enter the Current account number:");
	                        int accNo = sc.nextInt();
	                        
	                        System.out.println("\nPlease enter the PAN card number:");
	                        String panCardNo = sc.next();
	                        
	                        System.out.println("\nAs this is Current account, you have to deposit minimum amount of 3000.0");
	                        accountList.add(new Current(accNo, name, contact, email, city, pincode, accType, panCardNo));
	                        System.out.println("For "+name+", Current account created succesfully!");  
	                    }
	                    break;
	                case 3:
	                    // Fixed Deposit account
	                    flag = 0;
	                    for (Account account:accountList){
	                        if (name == account.name && account instanceof FixedDeposit){
	                            flag = 1;
	                        }
	                    }
	                    
	                    if(flag == 1){
	                    	System.out.println("\n The client "+name+" already has Fixed Deposit account. Please choose other option!");
	                    } else {
	                    	System.out.println("\nPlease enter the Fixed Deposit account number:");
	                        int accNo = sc.nextInt();
	                        
	                        System.out.println("\nPlease enter the amount that needs to be deposited:");
	                        double amountToDeposit = sc.nextDouble();
	                        
	                        System.out.println("\nPlease enter the duration in month for the deposit:");
	                        int durationInMonth = sc.nextInt();
	                        
	                        double maturityAmount = amountToDeposit + (amountToDeposit * durationInMonth * 8.0/12.0)/100.0;
	                        accountList.add(new FixedDeposit(accNo, name, contact, email, city, pincode, amountToDeposit, durationInMonth));    
	                        System.out.println("\nFor "+name+", Fixed deposit account created succesfully!");
	                        System.out.println("\nThe maturity amount is "+ maturityAmount+" after the end of "+durationInMonth+" months! However, if the amount is withdrawn before the maturity period it will be "+amountToDeposit+" as per the amount deposited!");
	                    }
	                    break;
	                default:
	                    // if user select the wrong value from the given options
	                	System.out.println("\nSorry! you have choose wrong number!");
	            }
	            flag = 1;
	            System.out.println("\nDo you want to create another account for the same client? yes/no");
	        }while(sc.next().equalsIgnoreCase("yes")); 
	        System.out.println("\nDo you want to create more account: yes/no");
		}while(sc.next().equalsIgnoreCase("yes"));
		
		
		// loop for printing the account details that are created
		for (Account account:accountList){
			System.out.println("\nName of account holder: "+account.name);
			System.out.println("Account number: "+account.accNo);
			System.out.println("Contact number: "+account.contact);
			System.out.println("Email id: "+account.email);
			System.out.println("City: "+account.city);
			System.out.println("Pincode: "+account.pincode);
			System.out.println("IFSC: "+account.ifsc);
		    
		    if (account instanceof Current){ // type checking
        		System.out.println("Account type: "+((Current) account).accType);
		        System.out.println("PAN Card numner: "+((Current) account).getPanCardNo());
		        System.out.println("Maximun number of transaction per day :"+((Current) account).maxTranNumberPerDay);
		        System.out.println("Maximum amount allowed to transact per day :"+((Current) account).maxTransAmountPerDay);
		    } else if (account instanceof Saving){ // type checking
        		System.out.println("Account type: "+((Saving) account).accType);
        		System.out.println("Maximun number of transaction per day :"+((Saving) account).maxTranNumberPerDay);
        		System.out.println("Maximum amount allowed to transact per day :"+((Saving) account).maxTransAmountPerDay);
		    } else if (account instanceof FixedDeposit){ // type checking
        		System.out.println("Account type: "+((FixedDeposit) account).getAccType());
        		System.out.println("Deposit amount: "+((FixedDeposit) account).getAmountToDeposit());
        		System.out.println("Deposit duration in months: "+((FixedDeposit) account).getDurationInMonth());
		    }
		}

	}
	
	public static void editAccountDetails(ArrayList<Account> accountList, Scanner sc) {
		// loop to continue until the user wants to modify the account details
		while(true){
			System.out.println("\nDo you want to edit your account details? yes/no");
		    String editDetails = sc.next();
		    
		    // if user input is no then it will terminate the current while loop
		    if(editDetails.toLowerCase().equalsIgnoreCase("no")){
		        break;
		    }
		    
		    while(true){
		    	System.out.println("\nPlease enter account number which needs changes:");
		        int editAccNo = sc.nextInt();
		        int flag = 0;
		        
		        for (Account account:accountList){
		            if(account.accNo == editAccNo){
		                flag = 1;
		                
		                System.out.println("\nPlease choose the options from below:\n1. Contact number\n2. Email id \n3. City \n4. Pincode");
		                switch (sc.nextInt()){
		                    case 1:
		                    	System.out.println("\nPlease enter new Contact number:");
		                        int newContact = sc.nextInt();
		                        account.contact = newContact; // update the contact value for the required account
		                        break;
		                    case 2:
		                    	System.out.println("\nPlease enter new Email id:");
		                        String newEmail = sc.next();
		                        account.email = newEmail; // update the email value for the required account
		                        break;
		                    case 3:
		                    	System.out.println("\nPlease enter new City:");
		                        String newCity = sc.next();
		                        account.city = newCity; // update the city value for the required account
		                        break;
		                    case 4:
		                    	System.out.println("\nPlease enter new Pincode:");
		                        int newPincode = sc.nextInt();
		                        account.pincode = newPincode; // update the pincode value for the required account
		                        break;
		                    default:
		                    	System.out.println("\nSorry! Wrong choice!");
		                }
		            }
		        }
		        
		        // if user enters the account number that do not exist
		        if(flag == 0){
		        	System.out.println("Sorry! The account number does not exist!");
		        	System.out.println("Would you like to enter the account number again? yes/no");
			        if(sc.next().equalsIgnoreCase("no")){
			            break; // terminate the loop if user input is no for entering the account number again
			        }
		        } else {
		        	break;
		        }
		    }
		    break;
		}
		
		sc.close();
		
		// loop for printing the account details that are created
		for (Account account:accountList){
			System.out.println("\nName of account holder: "+account.name);
			System.out.println("Account number: "+account.accNo);
			System.out.println("Contact number: "+account.contact);
			System.out.println("Email id: "+account.email);
			System.out.println("City: "+account.city);
			System.out.println("Pincode: "+account.pincode);
			System.out.println("IFSC: "+account.ifsc);
		    
		    if (account instanceof Current){ // type checking
        		System.out.println("Account type: "+((Current) account).accType);
		        System.out.println("PAN Card numner: "+((Current) account).getPanCardNo());
		        System.out.println("Maximun number of transaction per day :"+((Current) account).maxTranNumberPerDay);
		        System.out.println("Maximum amount allowed to transact per day :"+((Current) account).maxTransAmountPerDay);
		    } else if (account instanceof Saving){ // type checking
        		System.out.println("Account type: "+((Saving) account).accType);
        		System.out.println("Maximun number of transaction per day :"+((Saving) account).maxTranNumberPerDay);
        		System.out.println("Maximum amount allowed to transact per day :"+((Saving) account).maxTransAmountPerDay);
		    } else if (account instanceof FixedDeposit){ // type checking
        		System.out.println("Account type: "+((FixedDeposit) account).getAccType());
        		System.out.println("Deposit amount: "+((FixedDeposit) account).getAmountToDeposit());
        		System.out.println("Deposit duration in months: "+((FixedDeposit) account).getDurationInMonth());
		    }
		}
	}
	
	public static void performOperations(ArrayList<Account> accountList, Scanner sc) {
		// loop to continue until the user wants to select the different options from user menu
		while(true){
		    Account requiredAcc = new Account();
		    
		    while(true){
		    	System.out.println("\nPlease enter your account number to choose different options provided by the bank:");
		        int userAccNo = sc.nextInt();
		        int flag = 0;
		        
		        for (Account account:accountList){
		            if(account.accNo == userAccNo){
		                flag = 1; // flag will have value 1 if the account number entered by user is found in the system
		                requiredAcc = account;
		                break;
		            }    
		        }
		        
		        if(flag == 0){
		        	System.out.println("\nSorry! This account number does not exist in our bank!");
		        } else {
		            break;
		        }
		    }
		    
		    while(true){
		    	System.out.println("\nWhat would you like to do?\n1. Display current balance\n2. Deposit money\n3. Draw money\n4. Transfer money to other accounts within the bank\n5. Pay utility bills\n6. UPI Transaction \n7. Exit");
		        int exit = 0;
		        
		        switch (sc.nextInt()){
		            case 1:
		                // to display the balance
		                double balance = requiredAcc.displayBalance();
		            case 2:
		                // to deposite the amount
		            	System.out.println("\nPlease enter the amount you want to add:");
		                double depAmount = sc.nextDouble();
		                
		                requiredAcc.depositeAmount(depAmount);    
		            case 3:
		                // to withdraw the amount
		                if(requiredAcc instanceof FixedDeposit){ // type checking
		                    FixedDeposit fdAcc = ((FixedDeposit)requiredAcc); // type casting
		                    
		                    System.out.println("\nThis is Fixed Deposit account, and if maturity priod is over then you will get the maturity amount or else you will get the amount that was deposited at the time of account opening.\n\nWould you like to withdraw amount? yes/no");
		                    String isWithDraw = sc.next();
		                    if(isWithDraw == "yes"){
		                    	System.out.println("\nDoes maturity period is over for your account? yes/no");
		                        String isMaturity = sc.next();
		                        if(isMaturity == "yes"){
		                            // this will withdraw the amount with interest
		                            double withAmount = fdAcc.amountToDeposit + (fdAcc.amountToDeposit * fdAcc.durationInMonth * 8.0/12.0)/100.0;
		                            fdAcc.withdrawalAmount(withAmount);
		                        } else {
		                            // this will withdraw the amount without interest
		                            fdAcc.withdrawalAmount(fdAcc.amountToDeposit);
		                        }
		                    } else{
		                    	System.out.println("\nPlease come again if you want to with the amount from Fixed Deposit account!");
		                    }
		                } else {
		                	System.out.println("\nPlease enter the amount you want to withdraw:");
		                    double withAmount = sc.nextDouble();
		                    
		                    // if user wants to withdraw the amount more than the available amount
		                    if(withAmount > requiredAcc.balance){
		                    	System.out.println("\nSorry! You have only "+requiredAcc.balance+" amount in you account!");
		                    } else {
		                        requiredAcc.withdrawalAmount(withAmount);     
		                    }
		                }
		            case 4:
		                // to transfer amount from one account to another account
		                if(requiredAcc instanceof FixedDeposit){ // type checking
		                	System.out.println("\nThis account is Fixed Deposit account, and transfer from this account is not possible!");
		                } else {
		                	System.out.println("\nPlease enter account number in which you want to transfer the amount:");
		                    int accountNo = sc.nextInt();
		                    String accountFound = "no";
		                    
		                    for (Account account:accountList) {
		                        if(accountNo == account.accNo){
		                            while(true){
		                                String diffFlag = "no";
		                                accountFound = "yes";
		                                System.out.println("\nPlease enter amount that needs to be transfer:");
		                                double transAmount = sc.nextDouble();
		                                // if the account number is found and user have sufficient balance to transfer then perform the operation
		                                if(transAmount <= requiredAcc.balance){
		                                    requiredAcc.transferAmount(account,transAmount);    
		                                } else {
		                                // if the account number is found and user don't have sufficient balance to transfer then display the message
		                                	System.out.println("\nSorry! You have only "+requiredAcc.balance+" balance in your account!");
		                                	System.out.println("\nWould you like to enter the different amount? yes/no");
		                                    diffFlag = sc.next();
		                                }  
		                                
		                                if(diffFlag != "yes"){
		                                    break;
		                                }
		                            }
		                        }
		                    }
		                    if(accountFound == "no"){
		                    	System.out.println("\nSorry! The account number entered is not found in the Bank!");
		                    }
		                }
		            case 5:
		                // pay utility bills
		                if(requiredAcc instanceof FixedDeposit){ // type checking
		                	System.out.println("\nSorry! This is Fixed Deposit account, and no bills can be paid from this account");
		                } else {
		                	System.out.println("\nChoose the option from below:\n1. Credit card bill \n2. Electricity bill \n3. Mobile Recharge \n4. DTH Recharge");
		                    
		                	String toWhom = "";
		                	double payAmount = 0.0;
		                    // switch case for selection of options to pay bills or do recharge
		                    switch (sc.nextInt()){
		                        case 1:
		                            // credit card bill
		                            toWhom = "Credit card bill";
		                            System.out.println("\nPlease enter the Credit card number:");
		                            int cc = sc.nextInt();
		                            
		                            System.out.println("\nPlease enter the amount of bill you want to pay:");
		                            payAmount = sc.nextDouble();
		                            
		                            // if the account don't have sufficient balance then display the message
		                            if(payAmount > requiredAcc.balance){
		                            	System.out.println("\nSorry! You don't have sufficient amount in your account to pay the bill!");
		                            } else{
		                                requiredAcc.payBills(toWhom, payAmount);
		                            }
		                        case 2:
		                            // electricty bill
		                            toWhom = "Electricity bill";
		                            System.out.println("\nPlease enter the electricty connection number:");
		                            int ec = sc.nextInt();
		                            
		                            System.out.println("\nPlease enter the amount of bill you want to pay:");
		                            payAmount = sc.nextDouble();
		                            
		                            // if the account don't have sufficient balance then display the message
		                            if(payAmount > requiredAcc.balance){
		                            	System.out.println("\nSorry! You don't have sufficient amount in your account to pay the bill!");
		                            } else{
		                                requiredAcc.payBills(toWhom, payAmount);
		                            }
		                        case 3:
		                            // mobile serviceCharge
		                            toWhom = "Mobile recharge";
		                            System.out.println("\nPlease enter the mobile number to recharge:");
		                            int mr = sc.nextInt();
		                            
		                            System.out.println("\nPlease enter the amount of bill you want to pay:");
		                            payAmount = sc.nextDouble();
		                            
		                            // if the account don't have sufficient balance then display the message
		                            if(payAmount > requiredAcc.balance){
		                            	System.out.println("\nSorry! You don't have sufficient amount in your account to pay the bill!");
		                            } else{
		                                requiredAcc.payBills(toWhom, payAmount);
		                            }
		                        case 4:
		                            // dth recharge
		                            toWhom = "DTH recharge";
		                            System.out.println("\nPlease enter the DTH number:");
		                            int dth = sc.nextInt();
		                            
		                            System.out.println("\nPlease enter the amount of bill you want to pay:");
		                            payAmount = sc.nextDouble();
		                            
		                            // if the account don't have sufficient balance then display the message
		                            if(payAmount > requiredAcc.balance){
		                            	System.out.println("\nSorry! You don't have sufficient amount in your account to pay the bill!");
		                            } else{
		                                requiredAcc.payBills(toWhom, payAmount);
		                            }
		                        default:
		                        	System.out.println("\nSorry! Wrong choice!");
		                    }
		                }
		            case 6:
		                // UPI transfer
		                if(requiredAcc instanceof FixedDeposit){ // type checking and display the message if its FixedDeposit deposit account
		                	System.out.println("\nSorry! You can't transfer the amount from the Fixed Deposit!");
		                } else{
		                    String upiFound = "no";
		                    while(true){
		                    	System.out.println("\nPlease enter the UPI id linked with the account number:");
		                        String upi = sc.next();
		                        String againUPI = "no";
		                        
		                        for (Account account:accountList){
		                            if(account.upi == upi && requiredAcc.name != account.name){
		                                upiFound = "yes";
		                                
		                                System.out.println("\nPlease enter the amount that needs to be transfer:");
		                                double amount = sc.nextDouble();
		                                requiredAcc.upiTransfer(account, amount);
		                                break;
		                            }
		                        }
		                        
		                        if(upiFound == "no"){
		                        	System.out.println("\nSorry! This UPI id is not linked with any of the account!");
		                        	System.out.println("\nWould you like to enter the UPI id again? yes/no");
		                            againUPI = sc.next();
		                        }
		                        if(againUPI == "no"){
		                            break;
		                        }
		                    }
		                }
		            case 7:
		                // if user wants to not perform any operations
		                exit = 1;
		            default:
		            	System.out.println("\nSorry! Wrong choice!");
		        }
		        if(exit == 1){
		            break;
		        }
		    }
		    
		    System.out.println("\nWould you like to enter any other account number? yes/no");
		    if(!sc.next().equalsIgnoreCase("yes")){
		        break; // terminate the while loop if user don't want to add any other account number
		    }
		}


	}

}
