import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Date;


public class BoCAppTest_ListTransactionforCategory{
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    @AfterAll
    public static void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void testListTransactionsForCategory1() {
        BoCApp.UserTransactions.add(new BoCTransaction("Rent", new BigDecimal("850.00"), 0));
        BoCApp.UserTransactions.add(new BoCTransaction("Phone Bill", new BigDecimal("37.99"), 1));
        BoCApp.UserTransactions.add(new BoCTransaction("Electricity Bill", new BigDecimal("75.00"), 1));
        BoCApp.UserTransactions.add(new BoCTransaction("Sainsbury's Checkout", new BigDecimal("23.76"), 2));
        BoCApp.UserTransactions.add(new BoCTransaction("Tesco's Checkout", new BigDecimal("7.24"), 2));
        BoCApp.UserTransactions.add(new BoCTransaction("RockCity Drinks", new BigDecimal("8.50"), 3));
        BoCApp.UserTransactions.add(new BoCTransaction("The Mooch", new BigDecimal("13.99"), 3));
        BoCApp.ListTransactionsForCategory(3);
        assertEquals("3) "+"("+new Date()+")" +" RockCity Drinks - ¥8.50"+System.lineSeparator() + "3) " + "("+new Date()+")" +" The Mooch - ¥13.99"+System.lineSeparator(), outContent.toString());
        outContent.reset();
    }

    @Test
    public void testListTransactionsForCategory2() {
        BoCApp.ListTransactionsForCategory(0);
        assertEquals("0) "+"("+new Date()+")" +" Rent - ¥850.00"+System.lineSeparator(), outContent.toString());
    }
}
