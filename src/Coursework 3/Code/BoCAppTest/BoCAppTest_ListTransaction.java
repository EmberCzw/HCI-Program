import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.*;

class BoCAppTest_ListTransaction {
	private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	@BeforeAll
	public static void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}
	@Test
    void testListTransaction1() {
		BoCApp.ListTransactions();
		assertEquals("No transaction exists in the program"+System.lineSeparator(),outContent.toString());
	}
	@Test
	void testListTransaction2() {
		BoCApp.UserTransactions.add(new BoCTransaction("Rent", new BigDecimal("850.00"), 0));
		BoCApp.UserTransactions.add(new BoCTransaction("Phone Bill", new BigDecimal("37.99"), 1));
		BoCApp.ListTransactions();
		BoCTransaction temp1 = BoCApp.UserTransactions.get(0);
		BoCTransaction temp2 = BoCApp.UserTransactions.get(1);
		assertEquals("1) (" + temp1.transactionTime()+ ") Rent - ¥850.00" + System.lineSeparator() + "2) (" + temp1.transactionTime()+ ") Phone Bill - ¥37.99" + System.lineSeparator(),outContent.toString());
	}
	@AfterAll
	public static void cleanUpStreams() {
		System.setOut(null);
	}
}
