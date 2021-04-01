package banking_system;


import java.util.*;
//import java.io.*;

public class Bank {

	public static void main(String[] args) {	
		ArrayList<Account> accountList = new ArrayList<>();
		
		fillData(accountList);
	}
	
	public static void fillData(ArrayList<Account> accountList) {
		Scanner sc = new Scanner(System.in);
		
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

}
