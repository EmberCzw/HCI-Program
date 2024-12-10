import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class BoCApp {
	public static ArrayList<BoCTransaction> UserTransactions= new ArrayList<BoCTransaction>();
	public static ArrayList<BoCCategory> UserCategories = new ArrayList<BoCCategory>();

		public static void main(String[] args) {
		// SETUP EXAMPLE DATA //
		//UserCategories.add(new BoCCategory("Unknown"));
		//BoCCategory BillsCategory = new BoCCategory("Bills");
		//BillsCategory.setCategoryBudget(new BigDecimal("120.00"));
		//UserCategories.add(BillsCategory);
		//BoCCategory Groceries = new BoCCategory("Groceries");
		//Groceries.setCategoryBudget(new BigDecimal("75.00"));
		// UserCategories.add(Groceries);
		// BoCCategory SocialSpending = new BoCCategory("Social");
		// SocialSpending.setCategoryBudget(new BigDecimal("100.00"));
		// UserCategories.add(SocialSpending);

		// UserTransactions.add(new BoCTransaction("Rent", new BigDecimal("850.00"), 0));
		// UserTransactions.add(new BoCTransaction("Phone Bill", new BigDecimal("37.99"), 1));
		// UserTransactions.add(new BoCTransaction("Electricity Bill", new BigDecimal("75.00"), 1));
		// UserTransactions.add(new BoCTransaction("Sainsbury's Checkout", new BigDecimal("23.76"), 2));
		// UserTransactions.add(new BoCTransaction("Tesco's Checkout", new BigDecimal("7.24"), 2));
		// UserTransactions.add(new BoCTransaction("RockCity Drinks", new BigDecimal("8.50"), 3));
		// UserTransactions.add(new BoCTransaction("The Mooch", new BigDecimal("13.99"), 3));

		// for (int x = 0; x < UserTransactions.size(); x++) {
		// 	BoCTransaction temp = UserTransactions.get(x);
		// 	int utCat = temp.transactionCategory();
		// 	BoCCategory temp2 = UserCategories.get(utCat);
		// 	temp2.addExpense(temp.transactionValue());
		// 	UserCategories.set(utCat, temp2);
		// }

		// MAIN FUNCTION LOOP

		CategoryOverview();
		System.out.println(       // Show all the functions in the program
				"\nWhat do you want to do?\n O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it");
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String s = in.next();
			try {
				if (s.equals("T")) {
					ListTransactions();
				} else if (s.equals("O")) {
					CategoryOverview();
				} else if (s.equals("C")) {
					ChangeTransactionCategory(in);
				} else if (s.equals("N")) {
					AddCategory(in);
				} else if (s.equals("A")) {
					AddTransaction(in);
				} else if (s.equals("X")) {
					System.out.println("Goodbye!");
					break;
				} else if (Integer.parseInt(s) != -1 && Integer.parseInt(s) < UserCategories.size()) {
					ListTransactionsForCategory((int) Integer.parseInt(s));
				} else {
					System.out.println("The category number does not exist");   // Focus on the category number, if category number doesn't exist, print the relative error message
				}
			} catch (Exception e) {    // When user input an invaild choice string, the program should print the error message
				System.out.println("Command not recognised");
			}
			System.out.println(
					"\nWhat do you want to do?\n O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it");
		}
		in.close();
	}

	// public static void ListTransactions() {
	// 	for (int x = 0; x < UserTransactions.size(); x++) {
	// 		BoCTransaction temp = UserTransactions.get(x);
	// 		System.out.println((x + 1) + ") " + temp.toString());
	// 	}
	// }

	public static void ListTransactions() {
		try{
			for (int x = 0; x < UserTransactions.size(); x++) {
				BoCTransaction temp = UserTransactions.get(x);
				System.out.println((x + 1) + ") " + temp.toString());
			}
			if(UserTransactions.size() == 0){
				System.out.println("No transaction exists in the program");
			}
		}catch(Exception e){
			System.out.println("No transaction exists in the program");
		}
	}
	/*origin code:
	public static void CategoryOverview() {
		for (int x = 0; x < UserCategories.size(); x++) {
			BoCCategory temp = UserCategories.get(x);
			System.out.println((x + 1) + ") " + temp.toString());
		}

	}*/
	//new code:
	public static void CategoryOverview() {
		try{
			for (int x = 0; x < UserCategories.size(); x++) {
				BoCCategory temp = UserCategories.get(x);
				System.out.println(x + ") " + temp.toString());
			}
			if (UserCategories.size() == 0)
				System.out.println("No category exists in the program");
		}catch(Exception e){
			System.out.println("No category exists in the program");
		}
	}



/*
	origin code:
	public static void ListTransactionsForCategory(int chosenCategory) {
		for (int x = 0; x < UserTransactions.size(); x++) {
			BoCTransaction temp = UserTransactions.get(x);
			if (temp.transactionCategory() == chosenCategory) {
				System.out.println((x + 1) + ") " + temp.toString());
			}
		}
	}
*/
public static void ListTransactionsForCategory(int chosenCategory) {
		for (int x = 0; x < UserTransactions.size(); x++) {
			BoCTransaction temp = UserTransactions.get(x);
			if (temp.transactionCategory() == chosenCategory) {
				System.out.println(chosenCategory + ") " + temp.toString());
			}
		}
	}


/*
	origin code:
	private static void AddTransaction(Scanner in) {
		System.out.println("What is the title of the transaction?");
		in.nextLine(); // to remove read-in bug
		String title = in.nextLine();
		System.out.println("What is the value of the transaction?");
		BigDecimal tvalue = new BigDecimal(in.nextLine());
		UserTransactions.add(new BoCTransaction(title, tvalue, 0));
		System.out.println("[Transaction added]");
	}
*/

	private static void AddTransaction(Scanner in) {
			boolean reEnter = true;
			BigDecimal tvalue = new BigDecimal("0.00");
			System.out.println("What is the title of the transaction?");
			in.nextLine(); // to remove read-in bug
			String title = null;
			while(reEnter == true){
				// Check the limitation of the transaction name
				title = in.nextLine();
				if(title.length() < 25){
					reEnter = false;
				}else{
					System.out.println("Transaction name can't be more than 25 characters, please enter again:");
				}
			}
			System.out.println("What is the value of the transaction?");
			reEnter = true;
			while(reEnter == true){
				try{
					// Check every limitation of the category value
					tvalue = new BigDecimal(in.nextLine());
					reEnter = false;
					if(tvalue.doubleValue() < 0){
						System.out.println("The transaction value can't be less than 0, please enter again:");
						reEnter = true;
					}
				}
				catch(Exception e){
					// CHeck invaild input
					System.out.println("Invaild input, please enter agaain:");
					reEnter = true;
				}
			}
			catch(Exception e){
				// CHeck invaild input
				System.out.println("Invaild input, please enter again:");
				reEnter = true;
			}
		}
		reEnter = true;
		System.out.println("Which category will it be?");  // Allow user to enter the category type of the transaction
		int tCat = -1;
		while(reEnter == true){
			try{
				// Check whether the category exists
				tCat = Integer.parseInt(in.nextLine());
				reEnter = false;
				if(tCat > UserCategories.size() || tCat < 0){
					// If the category doesn't exist, print the error message
					System.out.println("The category number does not exist, please enter again:");
					reEnter = true;
				}
			}
			UserTransactions.add(new BoCTransaction(title, tvalue, tCat));
			UserCategories.get(tCat).addExpense(tvalue);
			System.out.println(title + "(¥" + tvalue + ") was added to " + UserCategories.get(tCat).CategoryName());   // Print the confirmation information
		}

/*
	private static void ChangeTransactionCategory(Scanner in) {
		System.out.println("Which transaction ID?");
		in.nextLine();
		int tID = Integer.parseInt(in.nextLine());
		System.out.println("\t- " + UserTransactions.get(tID - 1).toString());
		System.out.println("Which category will it move to?");
		CategoryOverview();
		int newCat = Integer.parseInt(in.nextLine());
		BoCTransaction temp = UserTransactions.get(tID);
		temp.setTransactionCategory(newCat);
		UserTransactions.set(tID, temp);
		BoCCategory temp2 = UserCategories.get(newCat);
		temp2.addExpense(temp.transactionValue());
		UserCategories.set(newCat, temp2);
	}
*/
	private static void ChangeTransactionCategory(Scanner in) {
		boolean reEnter = true;
		int newCat = -1;
		System.out.println("Which transaction ID?");
		in.nextLine();
		int tID = 0;
		while(reEnter == true){
			try{
				// The transaction must exist, if not, 
				tID = Integer.parseInt(in.nextLine());
				reEnter = false;
				if(tID > UserTransactions.size() || tID < 0){
					System.out.println("Can't find the transaction, please enter again:");
					reEnter = true;
				}
			}catch(Exception e){
				System.out.println("Invaild input, please enter again:");
			}
		}
		reEnter = true;
		System.out.println("- " + UserTransactions.get(tID - 1).toString());
		System.out.println("Which category will it move to?");
		CategoryOverview();
		while(reEnter == true){
			try{
				// Check whether the input is vaild and the category exists.
				newCat = Integer.parseInt(in.nextLine());
				reEnter = false;
				if(newCat > UserCategories.size() || newCat < 0){
					System.out.println("The category number does not exist, please enter again:");
					reEnter = true;
				}
			}catch(Exception e){
				System.out.println("Invaild input, please enter again:");
				reEnter = true;
			}
		}
		BoCTransaction temp = UserTransactions.get(tID - 1);
		BoCCategory temp1 = UserCategories.get(temp.transactionCategory());
		temp1.removeExpense(temp.transactionValue());
		temp.setTransactionCategory(newCat);
		UserTransactions.set(tID - 1, temp);
		// Add the value for target category, reduce the previous category
		BoCCategory temp2 = UserCategories.get(newCat);
		temp2.addExpense(temp.transactionValue());
		UserCategories.set(newCat, temp2);
		System.out.println(temp.transactionName() + "(¥" +temp.transactionValue() + ") was moved to " + temp2.CategoryName() + " from " + temp1.CategoryName());   // Give the confirmation
	}
	
/* origin code: private static void AddCategory(Scanner in) {
		System.out.println("What is the title of the category?");
		in.nextLine(); // to remove read-in bug
		String title = in.nextLine();
		System.out.println("What is the budget for this category?");
		BigDecimal cbudget = new BigDecimal(in.nextLine());
		BoCCategory temp = new BoCCategory(title);
		temp.setCategoryBudget(cbudget);
		UserCategories.add(temp);
		System.out.println("[Category added]");
		CategoryOverview();
	}*/


	private static void AddCategory(Scanner in) {
		boolean reEnter = true;
		System.out.println("What is the title of the category?");
		in.nextLine(); // to remove read-in bug
		String title = in.nextLine();
		while(reEnter == true){
			if(title.length() < 15){
				reEnter = false;
			}else{
				System.out.println("Category name can't be more than 15 characters, please enter again:");
			}
		}
		System.out.println("What is the budget for this category?");
		reEnter = true;
		BigDecimal cbudget = new BigDecimal("0.00");
		while(reEnter == true){
			try{
				cbudget = new BigDecimal(in.nextLine());
				reEnter = false;
				if(cbudget.doubleValue() < 0){
					System.out.println("The initial budget can't be less than 0, please enter again:");
					reEnter = true;
				}
			}catch(Exception e){
				System.out.println("Invaild input, please enter again:");
			}
		}
		BoCCategory temp = new BoCCategory(title);
		temp.setCategoryBudget(cbudget);
		UserCategories.add(temp);
		System.out.println(temp.CategoryName() + " was added, its budget is ¥" + temp.CategoryBudget());
		CategoryOverview();
	}
}
