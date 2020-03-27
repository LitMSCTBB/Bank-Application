import java.util.Scanner;

public class BankAccount {

	int balance;
	int previousTrans;
	String name;
	String id;
	 
	public BankAccount(String cname, String cid) {
		this.name = cname;
		this.id = cid;
	}
	
	public void deposit(int amount) {
		if (amount > 0) {
			balance+=amount;
			previousTrans=amount;
			System.out.println(amount+" deposited!");
		} else {
			System.out.println("You can't deposit that!");
		}
	}
	
	public void withdraw(int amount) {
		if (amount > 0 && amount < balance) {
			balance-=amount;
			previousTrans=-amount;
			System.out.println(amount+" withdrawn!");
		} else {
			System.out.println("You can't withdraw that!");
		}
	}
	
	public void getPreviousTrans() {
		if (previousTrans>0) {
			System.out.println("Deposited "+previousTrans);
		} else if (previousTrans<0) {
			System.out.println("Withdrew "+previousTrans);
		} else {
			System.out.println("No previous transactions");
		}
	}
	
	public void showMenu() {
		char option;
		Scanner decision = new Scanner(System.in);
		
		System.out.println("Welcome "+name);
		System.out.println("Your id is "+id);
		System.out.println("\n");
		System.out.println("A: Deposit");
		System.out.println("B: Withdraw");
		System.out.println("C: Check Balance");
		System.out.println("D: View Previous Transaction");
		System.out.println("E: Leave");
		
		do {
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Enter an option");
			System.out.println("---------------------------------------------------------------------------------------------");
			option = decision.next().charAt(0);
			
			switch(option) {
			
				case 'A':
					System.out.println("*******************************************************************************************");
					System.out.println("Enter an amount to deposit (enter a positive integer!): ");
					System.out.println("*******************************************************************************************");
					int depositAmount = decision.nextInt();
					deposit(depositAmount);
					System.out.println("\n");
					break;
				
				case 'B':
					System.out.println("*******************************************************************************************");
					System.out.println("Enter an amount to withdraw (enter a positive integer!): ");
					System.out.println("*******************************************************************************************");
					int withdrawAmount = decision.nextInt();
					withdraw(withdrawAmount);
					System.out.println("\n");
					break;
				
				case 'C':
					System.out.println("*******************************************************************************************");
					System.out.println("Balance: "+balance);
					System.out.println("*******************************************************************************************");
					System.out.println("\n");
					break;
			
				case 'D':
					System.out.println("*******************************************************************************************");
					System.out.println("Last transaction:");
					getPreviousTrans();
					System.out.println("*******************************************************************************************");
					System.out.println("\n");
					break;
			
				case 'E':
					System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
					break;
				
				default:
					System.out.println("Bad input. Try again.");
					break;
				
			}
			
		} while (option != 'E');
		
		System.out.println("Thank you for using our services, "+name+". Please come again!");
		decision.close();
		
	}
	
}
