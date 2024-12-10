import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;



import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class BoCAppTest_CategoryOverview {
	/*********************************************************************************
	 * Test ID: 2.1
	 * Test Time: 2021/4/21 18:25
	 * Author: AoLi
	 * Viewer: HongjiaXue
	 *********************************************************************************/
	private static final ByteArrayOutputStream OutStream2 =new ByteArrayOutputStream();
	@BeforeEach
    void setup(TestInfo infomation) {
        BoCApp.UserCategories = new ArrayList<BoCCategory>();
        BoCApp.UserTransactions = new ArrayList<BoCTransaction>();

        // SETUP EXAMPLE DATA
        BoCApp.UserCategories.add(new BoCCategory("Unknown"));
        BoCCategory BillsCategory = new BoCCategory("Bills");
        BillsCategory.setCategoryBudget(new BigDecimal("120.00"));
        BoCApp.UserCategories.add(BillsCategory);
        BoCCategory Groceries = new BoCCategory("Groceries");
        Groceries.setCategoryBudget(new BigDecimal("75.00"));
        BoCApp.UserCategories.add(Groceries);
        BoCCategory SocialSpending = new BoCCategory("Social");
        SocialSpending.setCategoryBudget(new BigDecimal("100.00"));
        BoCApp.UserCategories.add(SocialSpending);
        
        BoCApp.UserTransactions.add(new BoCTransaction("Rent", new BigDecimal("850.00"), 0));
        BoCApp.UserTransactions.add(new BoCTransaction("Phone Bill", new BigDecimal("37.99"), 1));
        BoCApp.UserTransactions.add(new BoCTransaction("Electricity Bill", new BigDecimal("75.00"), 1));
        BoCApp.UserTransactions.add(new BoCTransaction("Sainsbury's Checkout", new BigDecimal("23.76"), 2));
        BoCApp.UserTransactions.add(new BoCTransaction("Tesco's Checkout", new BigDecimal("7.24"), 2));
        BoCApp.UserTransactions.add(new BoCTransaction("RockCity Drinks", new BigDecimal("8.50"), 3));
        BoCApp.UserTransactions.add(new BoCTransaction("The Mooch", new BigDecimal("13.99"), 3));

        BoCApp.UserTransactions.add(new BoCTransaction("test", new BigDecimal("850.00"), 1));
        for (int x = 0; x < BoCApp.UserTransactions.size(); x++) {
            BoCTransaction temp = BoCApp.UserTransactions.get(x);
            int utCat = temp.transactionCategory();
            BoCCategory temp2 = BoCApp.UserCategories.get(utCat);
            temp2.addExpense(temp.transactionValue());
            BoCApp.UserCategories.set(utCat, temp2);
        }
    }
	
    @Test
	void CategoryOverviewTest1() {
    	System.setOut(new PrintStream(OutStream2));
		OutStream2.reset();
    	
		
		BoCApp.CategoryOverview();
		
		
		assertEquals("0) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)\r\n"
				+ "1) Bills(¥120.00) - Est. ¥962.99 (¥842.99 Overspent)\r\n"
				+ "2) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)\r\n"
				+ "3) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n",OutStream2.toString());
	}
	/*********************************************************************************
	 * Test ID: 2.2
	 * Test Time: 2021/4/21 18:25
	 * Author: AoLi
	 * Viewer: HongjiaXue
	 *********************************************************************************/
    private static final ByteArrayOutputStream OutStream3 =new ByteArrayOutputStream();
	@Test
	void CategoryOverviewTest2() {
		System.setOut(new PrintStream(OutStream3));
		OutStream3.reset();
		BoCApp.CategoryOverview();
		assertNotEquals("",OutStream3.toString());
	}
}
