import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class BoCAppCopy{
	public static ArrayList<BoCTransaction> UserTransactions = new ArrayList<BoCTransaction>();
	public static ArrayList<BoCCategory> UserCategories = new ArrayList<BoCCategory>();

	public static void bugAppCopy(Scanner in) {
		// SETUP EXAMPLE DATA //
		UserCategories.add(new BoCCategory("Unknown"));
		BoCCategory BillsCategory = new BoCCategory("Bills");
		BillsCategory.setCategoryBudget(new BigDecimal("120.00"));
		UserCategories.add(BillsCategory);
		BoCCategory Groceries = new BoCCategory("Groceries");
		Groceries.setCategoryBudget(new BigDecimal("75.00"));
		UserCategories.add(Groceries);
		BoCCategory SocialSpending = new BoCCategory("Social");
		SocialSpending.setCategoryBudget(new BigDecimal("100.00"));
		UserCategories.add(SocialSpending);

		UserTransactions.add(new BoCTransaction("Rent", new BigDecimal("850.00"), 0));
		UserTransactions.add(new BoCTransaction("Phone Bill", new BigDecimal("37.99"), 1));
		UserTransactions.add(new BoCTransaction("Electricity Bill", new BigDecimal("75.00"), 1));
		UserTransactions.add(new BoCTransaction("Sainsbury's Checkout", new BigDecimal("23.76"), 2));
		UserTransactions.add(new BoCTransaction("Tesco's Checkout", new BigDecimal("7.24"), 2));
		UserTransactions.add(new BoCTransaction("RockCity Drinks", new BigDecimal("8.50"), 3));
		UserTransactions.add(new BoCTransaction("The Mooch", new BigDecimal("13.99"), 3));

		for (int x = 0; x < UserTransactions.size(); x++) {
			BoCTransaction temp = UserTransactions.get(x);
			int utCat = temp.transactionCategory();
			BoCCategory temp2 = UserCategories.get(utCat);
			temp2.addExpense(temp.transactionValue());
			UserCategories.set(utCat, temp2);
		}

		// MAIN FUNCTION LOOP

		BoCApp copy = new BoCApp();
		copy.CategoryOverview();
		System.out.println(       // Show all the functions in the program
				"\nWhat do you want to do?\n O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it");
		while (in.hasNextLine()) {
			String s = in.next();
			try {
				if (s.equals("T")) {
					System.out.println("ListTransactions();");
				} else if (s.equals("O")) {
					System.out.println("CategoryOverview();");
				} else if (s.equals("C")) {
					System.out.println("ChangeTransactionCategory(in);");
				} else if (s.equals("N")) {
					System.out.println("AddCategory(in);");
				} else if (s.equals("A")) {
					System.out.println("AddTransaction(in);");
				} else if (s.equals("X")) {
					System.out.println("Goodbye!");
					break;
				} else if (Integer.parseInt(s) != -1 && Integer.parseInt(s) < UserCategories.size()) {
					copy.ListTransactionsForCategory((int) Integer.parseInt(s));
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
}
