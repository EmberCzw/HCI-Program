import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BoCTransactionTest {
    private static BigDecimal bdOfInt;
	private static BigDecimal bdOfFloat;
	private static BigDecimal bdOfNeg;
	private static int catOfInt;
	private static int catOfNeg;
	private static int catToChange1;
	private static int catToChange2;
	
	@BeforeAll
	static void setValues() {
		bdOfInt = new BigDecimal(123456);
		bdOfFloat = new BigDecimal(12.3456);
		bdOfNeg = new BigDecimal(-12.3456);
		catOfInt = 20;
		catOfNeg = -20;
		catToChange1 = 25;
		catToChange2 = 30;
		}
	
	static Stream<Arguments> setTestArgument(){
		return Stream.of(
				Arguments.of("Bob" ,bdOfInt, catOfInt), 
				Arguments.of("Zhiyu Dong", bdOfInt, catOfInt),
				Arguments.of("invalidNameWithOver25Characters", bdOfInt, catOfInt),
				Arguments.of("Bob" ,bdOfFloat, catOfInt),
				Arguments.of("Bob", bdOfNeg, catOfInt),
				Arguments.of("Bob", bdOfInt, catOfNeg)
			);
	}
	
	/***********************************************************************************************
	 * TestMethod: BoCTransaction.java - BoCTransaction()										   *
	 * Time: 2021/4/22 22:41																	   *
	 * Author: Zhiyu Dong																		   *
	 * Viewer: Qiwen Wang																		   *
	 * Aim: Test if the output of BoCTransaction() without arguments is null or not, and when 	   *
	 * there is no arguments, if it will create an empty transaction called "[Pending Transaction]"*
	 ***********************************************************************************************/

	@Test
	void nonparameters() {
		BoCTransaction Boc = new BoCTransaction();
		assertNull(Boc.transactionName());
		assertNull(Boc.transactionValue());
		assertNotNull(Boc.transactionCategory());
		assertNull(Boc.transactionTime());
		assertEquals(0, Boc.transactionCategory());
		assertEquals("Pending Transaction", Boc.toString());
	}
	
	/**********************************************************************************************
	 * TestMethod: BoCTransaction.java - BoCTransaction(String tName, BigDecimal tValue, int tCat)*
	 * Time: 2021/4/22 22:45        														      *
	 * Author: Zhiyu Dong																		  *
	 * Viewer: Qiwen Wang																		  *
	 * Aim: Test when the passing arguments, can Method set the data correct         			  *
	 **********************************************************************************************/
	
	@ParameterizedTest
	@MethodSource("setTestArgument")
	void threeParameters(String name, BigDecimal bd, int cat) {
		BoCTransaction Boc = new BoCTransaction(name, bd, cat);
		if (name.length() > 25){
			assertNotEquals(name, Boc.transactionName());
		}
		else {assertEquals(name, Boc.transactionName());}
		if (bd.compareTo(new BigDecimal(0)) == -1){
			assertNotEquals(bd, Boc.transactionValue());
		}
		else {assertEquals(bd, Boc.transactionValue());}
		assertEquals(cat, Boc.transactionCategory());
		assertNotNull(Boc.transactionTime());
	}
	


	   
	   
	/**********************************************************************************************
	 * TestMethod: BoCTransaction.java - BoCTransaction(String tName, BigDecimal tValue, int tCat)
	 * 			   - setTransactionTime(Date tTime)
	 * Time: 2021/4/22 22:51
	 * Author: Zhiwen Chen
	 * Viewer: Qiwen Wang
	 * Aim: The TransactionTime shouldn't be change once created. Test if the date can be changed.
	 * 
	 **********************************************************************************************/
	public static Date changeDate(Date dateTime, int n){     
		return new Date(dateTime.getTime() + n * 24 * 60 * 60 * 1000L);
	} 
  
	@Test
	void testTime() {
		BoCTransaction Boc = new BoCTransaction("Bob", bdOfInt, catOfInt);
		Date storeDate = new Date();
		storeDate = Boc.transactionTime();
		assertNotNull(Boc.transactionTime());
		assertEquals(storeDate, Boc.transactionTime());
		Boc.setTransactionTime(changeDate(Boc.transactionTime(),2));
		assertEquals(storeDate, Boc.transactionTime());
	}
	
	/**********************************************************************************************
	 * TestMethod: BoCTransaction.java - BoCTransaction(String tName, BigDecimal tValue, int tCat)*
	 * Time: 2021/4/22 22:54																	  *
	 * Author: Zhiyu Dong																		  *
	 * Viewer: Qiwen Wang																		  *
	 * Aim: Test when passing invalid arguments, can this method distinguish invalid values and   *
	 * fix them into correct form																  *
	 **********************************************************************************************/

	@ParameterizedTest
	@MethodSource("setTestArgument")
	void testInput(String name, BigDecimal bd, int cat) {
		BoCTransaction Boc = new BoCTransaction(name, bd, cat);
		BigDecimal zero = new BigDecimal(0);
		assertTrue(Boc.transactionName().length() <= 25);
		if (Boc.transactionValue() == null) {
			assertNull(Boc.transactionValue());
		}
		else {assertTrue(Boc.transactionValue().compareTo(zero) > -1);}
	}
	
	/**********************************************************************************************
	 * TestMethod: BoCTransaction.java - BoCTransaction(String tName, BigDecimal tValue, int tCat)*
	 *								   - setTransactionCategory(int tCat)                         *
	 * Time: 2021/4/22 22:58																	  *
	 * Author: Zhiyu Dong																		  *
	 * Viewer: Qiwen Wang																		  *
	 * Aim: Test if Method setTransactionCategory can change the value of Category                *
	 **********************************************************************************************/
	
	@Test
	void testCateChangeable() {
		BoCTransaction Boc = new BoCTransaction("Bob", bdOfInt, catOfInt);
		assertEquals(catOfInt, Boc.transactionCategory());
		Boc.setTransactionCategory(catToChange1);
		assertNotEquals(catOfInt, Boc.transactionCategory());
		Boc.setTransactionCategory(catToChange2);
		assertNotEquals(catToChange1, Boc.transactionCategory());
	}
	
	/**********************************************************************************************
	 * TestMethod: BoCTransaction.java - transactionName()							     		  *					                       									      *
	 * Time: 2021/4/22 22:58																	  *
	 * Author: Zhiyu Dong																		  *
	 * Viewer: Qiwen Wang																		  *
	 * Aim: Test if the type of output of transactionName be String or not                        *
	 **********************************************************************************************/

	@Test
	void testTypeName() {
		BoCTransaction Boc = new BoCTransaction("Bob", bdOfInt, catOfInt);
		assertTrue(Boc.transactionName() instanceof String);
	}
	
	/**********************************************************************************************
	 * TestMethod: BoCTransaction.java - transactionValue()							     		  *					                       									      *
	 * Time: 2021/4/22 22:58																	  *
	 * Author: Zhiyu Dong																		  *
	 * Viewer: Qiwen Wang																		  *
	 * Aim: Test if the type of output of transactionValue be BigDecimal or not                   *
	 **********************************************************************************************/
	
	@Test
	void testTypeValue() {
		BoCTransaction Boc = new BoCTransaction("Bob", bdOfInt, catOfInt);
		assertTrue(Boc.transactionValue() instanceof BigDecimal);
	}
	
	/**********************************************************************************************
	 * TestMethod: BoCTransaction.java - transactionCategory()							     	  *					                       									      *
	 * Time: 2021/4/22 22:58																	  *
	 * Author: Zhiyu Dong																		  *
	 * Viewer: Qiwen Wang																		  *
	 * Aim: Test if the type of output of transactionValue be Integer or not                      *
	 **********************************************************************************************/
	
	@Test
	void testTypeCat() {
		BoCTransaction Boc = new BoCTransaction("Bob", bdOfInt, catOfInt);
		assertTrue(Boc.transactionCategory() == (int) Boc.transactionCategory());
	}

	/**********************************************************************************************
	 * TestMethod: BoCTransaction.java - transactionCategory()							     	  *					                       									      *
	 * Time: 2021/4/22 22:58																	  *
	 * Author: Zhiwen Chen																		  *
	 * Viewer: Zhiyu Dong																		  *
	 * Aim: Test if method toString can run or not                                  *
		**********************************************************************************************/
	
	//Test by Zhiwen Chen
	@Test
    void testToString() {
        BoCTransaction test = new BoCTransaction("test",new BigDecimal("100.00"),1);
        assertEquals( "(" + test.transactionTime() + ") "+ "test - ¥100.00",test.toString());
    }

	BoCTransaction tran = new BoCTransaction();

    //Test by Qiwen Wang
    @Test
    public void testTransactionTime() {
        Date date = new Date();
        tran.setTransactionTime(date);
        assertEquals(date,tran.transactionTime());
    }
}

