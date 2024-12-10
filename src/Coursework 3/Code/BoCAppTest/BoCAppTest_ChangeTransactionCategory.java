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

@Nested
class BoCAppTest_ChangeTransactionCategory {
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
	
	/***********************************************************************************************
	 * TestMethod: BoCTransaction.java - BoCApp.java										   *
	 * Time: 2021/4/21 22:50																	   *
	 * Author: Zhiyu Dong																		   *
	 * Viewer: Qiwen Wang																		   *
	 *
	 ***********************************************************************************************/
	
	
	static Stream<Arguments> setvalidArgument(){
		return Stream.of(
				Arguments.arguments(new Scanner("\n2\n2"), 2, " Phone Bill - ¥37.99", "Phone Bill(¥37.99) was moved to Groceries from Bills"));
		}
	
    private static final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    
	@ParameterizedTest
	@MethodSource("setvalidArgument")
	void testChangeTransactionCategory(Scanner in, int num, String title, String compare) throws 
	NoSuchMethodException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException {
		System.setOut(new PrintStream(outStream));
		BoCApp test = new BoCApp();
        Method change = test.getClass().getDeclaredMethod("ChangeTransactionCategory", Scanner.class);
        change.setAccessible(true);
        change.invoke(test, in);
		BoCTransaction temp1 = test.UserTransactions.get(0);
        assertEquals(title,  app.UserTransactions.get(num - 1).toString().substring(30,50));
        assertEquals("Which transaction ID?" + System.lineSeparator() + "- (" + temp1.transactionTime() + ")" +
        		title + System.lineSeparator() +
        		"Which category will it move to?" + System.lineSeparator() + 
        	"0) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)" + System.lineSeparator() +
        	"1) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)" + System.lineSeparator() +
        	"2) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)" + System.lineSeparator() +
        	"3) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)" + System.lineSeparator() +
        	compare + System.lineSeparator(), outStream.toString());
        	outStream.reset();
        	app.CategoryOverview();
        	assertEquals("0) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)" + System.lineSeparator() +
        			"1) Bills(¥120.00) - Est. ¥75.00 (¥45.00 Remaining)" + System.lineSeparator() +
        			"2) Groceries(¥75.00) - Est. ¥68.99 (¥6.01 Remaining)" + System.lineSeparator() +
        			"3) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)" + System.lineSeparator(), outStream.toString());
        	outStream.reset();
        }
	
	static Stream<Arguments> setvalidArgument2(){
		return Stream.of(
				Arguments.arguments(new Scanner("\n2)\n2\n2"), 2, "- Phone Bill - ¥37.99", "Phone Bill(¥37.99) was moved to Groceries from Bills"));
		}
	
	@ParameterizedTest
	@MethodSource("setvalidArgument2")
	void testChangeTransactionCategory2(Scanner in, int num, String title, String compare) throws 
	NoSuchMethodException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException {
		System.setOut(new PrintStream(outStream));
		BoCApp test = new BoCApp();
        Method change = test.getClass().getDeclaredMethod("ChangeTransactionCategory", Scanner.class);
        change.setAccessible(true);
        change.invoke(test, in);
		BoCTransaction temp1 = test.UserTransactions.get(0);
        assertEquals(title, "-" + app.UserTransactions.get(num - 1).toString().substring(30,50));
        assertEquals("Which transaction ID?" + System.lineSeparator() + "- (" + temp1.transactionTime() + ")" +
        		"Invaild input, please enter again:" +System.lineSeparator() + 
        		title + System.lineSeparator() +
        		"Which category will it move to?" + System.lineSeparator() + 
        	"0) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)" + System.lineSeparator() +
        	"1) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)" + System.lineSeparator() +
        	"2) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)" + System.lineSeparator() +
        	"3) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)" + System.lineSeparator() +
        	compare + System.lineSeparator(), outStream.toString());
        	outStream.reset();
        	app.CategoryOverview();
        	assertEquals("0) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)" + System.lineSeparator() +
        			"1) Bills(¥120.00) - Est. ¥75.00 (¥45.00 Remaining)" + System.lineSeparator() +
        			"2) Groceries(¥75.00) - Est. ¥68.99 (¥6.01 Remaining)" + System.lineSeparator() +
        			"3) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)" + System.lineSeparator(), outStream.toString());
        	outStream.reset();
        }
	
	static Stream<Arguments> setvalidArgument3(){
		return Stream.of(
				Arguments.arguments(new Scanner("\n\n2\n2"), 2, "- Phone Bill - ¥37.99", "Phone Bill(¥37.99) was moved to Groceries from Bills"));
		}
	
	@ParameterizedTest
	@MethodSource("setvalidArgument3")
	void testChangeTransactionCategory3(Scanner in, int num, String title, String compare) throws 
	NoSuchMethodException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException {
		System.setOut(new PrintStream(outStream));
		BoCApp test = new BoCApp();
        Method change = test.getClass().getDeclaredMethod("ChangeTransactionCategory", Scanner.class);
        change.setAccessible(true);
        change.invoke(test, in);
		BoCTransaction temp1 = test.UserTransactions.get(0);
        assertEquals(title, "-" + app.UserTransactions.get(num - 1).toString().substring(30,50));
        assertEquals("Which transaction ID?" + System.lineSeparator() + "- (" + temp1.transactionTime() + ")" +
        		"Invaild input, please enter again:" +System.lineSeparator() + 
        		title + System.lineSeparator() +
        		"Which category will it move to?" + System.lineSeparator() + 
        	"0) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)" + System.lineSeparator() +
        	"1) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)" + System.lineSeparator() +
        	"2) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)" + System.lineSeparator() +
        	"3) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)" + System.lineSeparator() +
        	compare + System.lineSeparator(), outStream.toString());
        	outStream.reset();
        	app.CategoryOverview();
        	assertEquals("0) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)" + System.lineSeparator() +
        			"1) Bills(¥120.00) - Est. ¥75.00 (¥45.00 Remaining)" + System.lineSeparator() +
        			"2) Groceries(¥75.00) - Est. ¥68.99 (¥6.01 Remaining)" + System.lineSeparator() +
        			"3) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)" + System.lineSeparator(), outStream.toString());
        	outStream.reset();
        }
	
	static Stream<Arguments> setvalidArgument4(){
		return Stream.of(
				Arguments.arguments(new Scanner("\n10\n2\n2"), 2, "- Phone Bill - ¥37.99", "Phone Bill(¥37.99) was moved to Groceries from Bills"));
		}
	
	@ParameterizedTest
	@MethodSource("setvalidArgument4")
	void testChangeTransactionCategory4(Scanner in, int num, String title, String compare) throws 
	NoSuchMethodException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException {
		System.setOut(new PrintStream(outStream));
		BoCApp test = new BoCApp();
        Method change = test.getClass().getDeclaredMethod("ChangeTransactionCategory", Scanner.class);
        change.setAccessible(true);
        change.invoke(test, in);
		BoCTransaction temp1 = test.UserTransactions.get(0);
        assertEquals(title, "-" + app.UserTransactions.get(num - 1).toString().substring(30,50));
        assertEquals("Which transaction ID?" + System.lineSeparator() + "- (" + temp1.transactionTime() + ")" +
        		"Can't find the category, please enter again:" +System.lineSeparator() + 
        		title + System.lineSeparator() +
        		"Which category will it move to?" + System.lineSeparator() + 
        	"0) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)" + System.lineSeparator() +
        	"1) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)" + System.lineSeparator() +
        	"2) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)" + System.lineSeparator() +
        	"3) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)" + System.lineSeparator() +
        	compare + System.lineSeparator(), outStream.toString());
        	outStream.reset();
        	app.CategoryOverview();
        	assertEquals("0) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)" + System.lineSeparator() +
        			"1) Bills(¥120.00) - Est. ¥75.00 (¥45.00 Remaining)" + System.lineSeparator() +
        			"2) Groceries(¥75.00) - Est. ¥68.99 (¥6.01 Remaining)" + System.lineSeparator() +
        			"3) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)" + System.lineSeparator(), outStream.toString());
        	outStream.reset();
        }
	
	static Stream<Arguments> setvalidArgument5(){
		return Stream.of(
				Arguments.arguments(new Scanner("\n2\n5\n2"), 2, "- Phone Bill - ¥37.99", "Phone Bill(¥37.99) was moved to Groceries from Bills"));
		}
	
	@ParameterizedTest
	@MethodSource("setvalidArgument5")
	void testChangeTransactionCategory5(Scanner in, int num, String title, String compare) throws 
	NoSuchMethodException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException {
		System.setOut(new PrintStream(outStream));
		BoCApp test = new BoCApp();
        Method change = test.getClass().getDeclaredMethod("ChangeTransactionCategory", Scanner.class);
        change.setAccessible(true);
        change.invoke(test, in);
		BoCTransaction temp1 = test.UserTransactions.get(0);
        assertEquals(title, "-" + app.UserTransactions.get(num - 1).toString().substring(30,50));
        assertEquals("Which transaction ID?" + System.lineSeparator() +  "- (" + temp1.transactionTime() + ")" +
        		title + System.lineSeparator() +
        		"Which category will it move to?" + System.lineSeparator() + 
        	"0) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)" + System.lineSeparator() +
        	"1) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)" + System.lineSeparator() +
        	"2) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)" + System.lineSeparator() +
        	"3) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)" + System.lineSeparator() +
        	"The category number does not exist, please enter again:" + System.lineSeparator() +
        	compare + System.lineSeparator(), outStream.toString());
        	outStream.reset();
        	app.CategoryOverview();
        	assertEquals("0) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)" + System.lineSeparator() +
        			"1) Bills(¥120.00) - Est. ¥75.00 (¥45.00 Remaining)" + System.lineSeparator() +
        			"2) Groceries(¥75.00) - Est. ¥68.99 (¥6.01 Remaining)" + System.lineSeparator() +
        			"3) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)" + System.lineSeparator(), outStream.toString());
        	outStream.reset();
        }
	
	static Stream<Arguments> setvalidArgument6(){
		return Stream.of(
				Arguments.arguments(new Scanner("\nabs\n2\n2"), 2, "- Phone Bill - ¥37.99", "Phone Bill(¥37.99) was moved to Groceries from Bills"));
		}
	
	@ParameterizedTest
	@MethodSource("setvalidArgument6")
	void testChangeTransactionCategory6(Scanner in, int num, String title, String compare) throws 
	NoSuchMethodException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException {
		System.setOut(new PrintStream(outStream));
		BoCApp test = new BoCApp();
        Method change = test.getClass().getDeclaredMethod("ChangeTransactionCategory", Scanner.class);
        change.setAccessible(true);
        change.invoke(test, in);
		BoCTransaction temp1 = test.UserTransactions.get(0);
        assertEquals(title, "-" + app.UserTransactions.get(num - 1).toString().substring(30,50));
        assertEquals("Which transaction ID?" + System.lineSeparator() + "- (" + temp1.transactionTime() + ")" +
        		"Invaild input, please enter again:" +System.lineSeparator() + 
        		title + System.lineSeparator() +
        		"Which category will it move to?" + System.lineSeparator() + 
        	"0) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)" + System.lineSeparator() +
        	"1) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)" + System.lineSeparator() +
        	"2) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)" + System.lineSeparator() +
        	"3) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)" + System.lineSeparator() +
        	compare + System.lineSeparator(), outStream.toString());
        	outStream.reset();
        	app.CategoryOverview();
        	assertEquals("0) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)" + System.lineSeparator() +
        			"1) Bills(¥120.00) - Est. ¥75.00 (¥45.00 Remaining)" + System.lineSeparator() +
        			"2) Groceries(¥75.00) - Est. ¥68.99 (¥6.01 Remaining)" + System.lineSeparator() +
        			"3) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)" + System.lineSeparator(), outStream.toString());
        	outStream.reset();
        }
	
	
}
