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
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BoCAppTest_AddTransaction {
    @Nested
    static
    class AddTransactionTest {
        private static final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

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

            BoCApp.UserTransactions.add(new BoCTransaction("test", new BigDecimal("850.00"), 1));
            for (int x = 0; x < BoCApp.UserTransactions.size(); x++) {
                BoCTransaction temp = BoCApp.UserTransactions.get(x);
                int utCat = temp.transactionCategory();
                BoCCategory temp2 = BoCApp.UserCategories.get(utCat);
                temp2.addExpense(temp.transactionValue());
                BoCApp.UserCategories.set(utCat, temp2);
            }
        }

        static Stream<Arguments> addTransactionStream() {
            return Stream.of(
                    Arguments.arguments(new Scanner("\nFirst_test\n100.00\n1\n"),
                            "First_test", new BigDecimal("100.00"), 1)
            );
        }

        static Stream<Arguments> addTransactionStream1() {
            return Stream.of(
                    Arguments.arguments(new Scanner("\n\n100.00\n1\n"),
                             null,new BigDecimal("100.00"), 1)
            );
        }

        @ParameterizedTest
        @MethodSource("addTransactionStream")
        void testAddTransaction1(Scanner in, String title, BigDecimal budegt)
                throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            System.setOut(new PrintStream(outStream));
            BoCApp test = new BoCApp();
            Method addTransaction = test.getClass().getDeclaredMethod("AddTransaction", Scanner.class);
            addTransaction.setAccessible(true);
            outContent.reset();
            addTransaction.invoke(test, in);
            BoCTransaction temp1 = test.UserTransactions.get(0);
            BoCTransaction temp2 = test.UserTransactions.get(1);
            assertEquals(temp1.transactionName() + " " + temp1.transactionValue() + System.lineSeparator()
                            + "First_test 100.00",
                    temp1.transactionName() + " " + temp1.transactionValue() + System.lineSeparator()
                            + temp2.transactionName() + " " + temp2.transactionValue());
            assertEquals("What is the title of the transaction?" + System.lineSeparator() +
                            "What is the value of the transaction?" + System.lineSeparator() +
                            "Which category will it be?" + System.lineSeparator() +
                            "First_test(¥100.00) was added to Bills" + System.lineSeparator(),
                    outStream.toString());
        }

        @ParameterizedTest
        @MethodSource("addTransactionStream1")
        void testAddTransaction2(Scanner in, String title, BigDecimal budegt)
                throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            System.setOut(new PrintStream(outStream));
            BoCApp test = new BoCApp();
            Method addTransaction = test.getClass().getDeclaredMethod("AddTransaction", Scanner.class);
            addTransaction.setAccessible(true);
            outContent.reset();
            try{
                addTransaction.invoke(test, in);
            }catch (Exception e){
                System.err.println("If enter empty input in Transcationvarible, test will crush.");
            }finally {
                fail("Empty input");
            }
            BoCTransaction temp1 = test.UserTransactions.get(0);
            BoCTransaction temp2 = test.UserTransactions.get(1);
            if(temp2.transactionName() == null){
            assertEquals(temp1.transactionName() + " " + temp1.transactionValue() + System.lineSeparator()
                            + " 100.00",
                    temp1.transactionName() + " " + temp1.transactionValue() + System .lineSeparator()
                            + temp2.transactionName() + " " + temp2.transactionValue());
            }else if(temp2.transactionValue() == null){
                assertEquals("Invaild input. Please Return again:",
                        temp1.transactionName() + " " + temp1.transactionValue() + System .lineSeparator()
                                + temp2.transactionName() + " " + temp2.transactionValue());
            }
            outContent.reset();
        }

    }
}
