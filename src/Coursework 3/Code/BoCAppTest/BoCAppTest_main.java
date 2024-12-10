import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BoCAppTest_main {
	public static ArrayList<BoCTransaction> UserTransactions;
	public static ArrayList<BoCCategory> UserCategories;
	BoCApp app = new BoCApp();

	@BeforeEach
	void setup() {
		app.UserCategories = new ArrayList<BoCCategory>();
		app.UserTransactions = new ArrayList<BoCTransaction>();
		app.UserCategories.add(new BoCCategory("Unknown"));
		BoCCategory BillsCategory = new BoCCategory("Bills");
		BillsCategory.setCategoryBudget(new BigDecimal("120.00"));
		app.UserCategories.add(BillsCategory);
		BoCCategory Groceries = new BoCCategory("Groceries");
		Groceries.setCategoryBudget(new BigDecimal("75.00"));
		app.UserCategories.add(Groceries);
		BoCCategory SocialSpending = new BoCCategory("Social");
		SocialSpending.setCategoryBudget(new BigDecimal("100.00"));
		app.UserCategories.add(SocialSpending);

		app.UserTransactions.add(new BoCTransaction("Rent", new BigDecimal("850.00"), 0));
		app.UserTransactions.add(new BoCTransaction("Phone Bill", new BigDecimal("37.99"), 1));
		app.UserTransactions.add(new BoCTransaction("Electricity Bill", new BigDecimal("75.00"), 1));
		app.UserTransactions.add(new BoCTransaction("Sainsbury's Checkout", new BigDecimal("23.76"), 2));
		app.UserTransactions.add(new BoCTransaction("Tesco's Checkout", new BigDecimal("7.24"), 2));
		app.UserTransactions.add(new BoCTransaction("RockCity Drinks", new BigDecimal("8.50"), 3));
		app.UserTransactions.add(new BoCTransaction("The Mooch", new BigDecimal("13.99"), 3));
		
		for (int x = 0; x < app.UserTransactions.size(); x++) {
			BoCTransaction temp = app.UserTransactions.get(x);
			int utCat = temp.transactionCategory();
			BoCCategory temp2 = app.UserCategories.get(utCat);
			temp2.addExpense(temp.transactionValue());
			app.UserCategories.set(utCat, temp2);
		}
		
	}
	

	static Stream<Arguments> setvalidArgument(){
		return Stream.of(
				Arguments.arguments(new Scanner("\nC\nZ\n4\nX"))
				);
		}
	
    private static final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    
	@ParameterizedTest
	@MethodSource("setvalidArgument")
	void testMain(Scanner in) throws 
	NoSuchMethodException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException {
		outStream.reset();
		System.setOut(new PrintStream(outStream));
		BoCAppCopy test = new BoCAppCopy();
        Method change = test.getClass().getMethod("bugAppCopy", Scanner.class);
        change.setAccessible(true);
        change.invoke(test, in);
        assertEquals(
        		"0) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)" + System.lineSeparator() +
        "1) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)" + System.lineSeparator() +
        "2) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)" + System.lineSeparator() +
        "3) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)" + System.lineSeparator() + "\n" +
        "What do you want to do?" + "\n" + 
        " O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it" + System.lineSeparator() +
        "ChangeTransactionCategory(in);" + System.lineSeparator() + "\n" +
        "What do you want to do?"+ "\n" +
        " O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it" + System.lineSeparator() +
        "Command not recognised" + System.lineSeparator() + "\n" +
        "What do you want to do?" + "\n" +
        " O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it" + System.lineSeparator() +
        "The category number does not exist" + System.lineSeparator() + "\n" +
        "What do you want to do?" + "\n" +
        " O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it" + System.lineSeparator() +
        "Goodbye!" + System.lineSeparator(), outStream.toString());
        
        }
}