import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TestForBoCCategory {

	@Nested
	class TestConstructor {
		/*********************************************************************************
		 * Test ID: 1.1
		 * Test Time: 2021/4/21 18:25
		 * Author: AoLi
		 * Viewer: HongjiaXue
		 *********************************************************************************/
		@Test
		void DefaultConstructor() {
			BoCCategory test = new BoCCategory();
			assertEquals("New Category", test.CategoryName());
			assertEquals(new BigDecimal("0.00"), test.CategoryBudget());
			assertEquals(new BigDecimal("0.00"), test.CategorySpend());
		}

		/*********************************************************************************
		 * Test ID: 2.1
		 * Test Time: 2021/4/21 18:36
		 * Author: AoLi
		 * Viewer: HongjiaXue
		 *********************************************************************************/
		@Test
		void TestMainConstructors1() {
			String testname1 = "AoLi";
			BoCCategory test1 = new BoCCategory(testname1);
			assertEquals(testname1, test1.CategoryName());
			assertEquals(new BigDecimal("0.00"), test1.CategoryBudget());
			assertEquals(new BigDecimal("0.00"), test1.CategorySpend());
		}

		/*********************************************************************************
		 * Test ID: 2.2
		 * Test Time: 2021/4/21 18:47
		 * Author: AoLi
		 * Viewer: HongjiaXue
		 *********************************************************************************/
		@Test
		void TestMainConstructors2() {
			String testname2 = "ZhiwenChen";
			BoCCategory test2 = new BoCCategory(testname2);
			assertEquals(testname2, test2.CategoryName());
			assertEquals(new BigDecimal("0.00"), test2.CategoryBudget());
			assertEquals(new BigDecimal("0.00"), test2.CategorySpend());
		}

		/*********************************************************************************
		 * Test ID: 2.3
		 * Test Time: 2021/4/21 18:56
		 * Author: AoLi
		 * Viewer: HongjiaXue
		 *********************************************************************************/
		@Test
		void TestMainConstructors3() {
			String testname3 = "I-must-not-input-too-much-characters-like-this-one";
			BoCCategory test3 = new BoCCategory(testname3);
			assertNotEquals(testname3, test3.CategoryName());
		}
	}

	@Nested
	class TestCategoryName {
		/*********************************************************************************
		 * Test ID: 3.1
		 * Test Time: 2021/4/21 19:06
		 * Author: AoLi
		 * Viewer: HongjiaXue
		 *********************************************************************************/
		@Test
		void TestCategoryName1() {
			BoCCategory test1 = new BoCCategory("apple");
			assertEquals("apple", test1.CategoryName());
		}

		/*********************************************************************************
		 * Test ID: 3.2
		 * Test Time: 2021/4/21 19:19
		 * Author: AoLi
		 * Viewer: HongjiaXue
		 *********************************************************************************/
		@Test
		void TestCategoryName2() {
			BoCCategory test2 = new BoCCategory("I-must-not-input-too-much-characters-like-this-one");
			assertNotEquals("I-must-not-input-too-much-characters-like-this-one", test2.CategoryName());
		}
	}

	@Nested
	class TestCategoryBudget {
		/*********************************************************************************
		 * Test ID: 4.1
		 * Test Time: 2021/4/21 19:26
		 * Author: AoLi
		 * Viewer: HongjiaXue
		 *********************************************************************************/
		@Test
		void testCategoryBudget1() {
			BoCCategory test = new BoCCategory("test");
			test.setCategoryBudget(new BigDecimal("50.00"));
			assertEquals(new BigDecimal("50.00"), test.CategoryBudget());
		}

		/*********************************************************************************
		 * Test ID: 4.2
		 * Test Time: 2021/4/21 19:35
		 * Author: AoLi
		 * Viewer: HongjiaXue
		 *********************************************************************************/
		@Test
		void testCategoryBudget2() {
			BoCCategory test = new BoCCategory("test");
			test.setCategoryBudget(new BigDecimal("-50.00"));
			assertNotEquals(new BigDecimal("-50.00"), test.CategoryBudget());
		}

		@Test
		/*********************************************************************************
		 * Test ID: 4.3
		 * Test Time: 2021/4/21 19:48
		 * Author: AoLi
		 * Viewer: HongjiaXue
		 *********************************************************************************/
		void testCategoryBudget3() {
			BoCCategory test = new BoCCategory("test");
			test.setCategoryBudget(new BigDecimal("0.00"));
			assertNotEquals(new BigDecimal("0.00"), test.CategoryBudget());
		}
	}

	@Nested
	class TestCategorySpend {
		/*********************************************************************************
		 * Test ID: 5.1
		 * Test Time: 2021/4/21 20:15
		 * Author: AoLi
		 * Viewer: HongjiaXue
		 *********************************************************************************/
		@Test
		void testCategorySpend1() {
			BoCCategory test = new BoCCategory("test");
			test.addExpense(new BigDecimal("50.00"));
			assertEquals(new BigDecimal("50.00"), test.CategorySpend());
		}

		/*********************************************************************************
		 * Test ID: 5.2
		 * Test Time: 2021/4/21 20:29
		 * Author: AoLi
		 * Viewer: HongjiaXue
		 *********************************************************************************/
		@Test
		void testCategorySpend2() {
			BoCCategory test = new BoCCategory("test");
			test.addExpense(new BigDecimal("50.00"));
			test.addExpense(new BigDecimal("50.00"));
			assertEquals(new BigDecimal("100.00"), test.CategorySpend());
		}

		/*********************************************************************************
		 * Test ID: 5.3
		 * Test Time: 2021/4/21 20:41
		 * Author: AoLi
		 * Viewer: HongjiaXue
		 *********************************************************************************/
		@Test
		void testCategorySpend3() {
			BoCCategory test = new BoCCategory("test");
			test.addExpense(new BigDecimal("50.00"));
			test.removeExpense(new BigDecimal("50.00"));
			assertEquals(new BigDecimal("0.00"), test.CategorySpend());
		}

		/*********************************************************************************
		 * Test ID: 5.4
		 * Test Time: 2021/4/21 20:58
		 * Author: AoLi
		 * Viewer: HongjiaXue
		 *********************************************************************************/
		@Test
		void testCategorySpend4() {
			BoCCategory test = new BoCCategory("test");
			test.removeExpense(new BigDecimal("50.00"));
			test.removeExpense(new BigDecimal("50.00"));
			assertNotEquals(new BigDecimal("-100.00"), test.CategorySpend());
		}

		/*********************************************************************************
		 * Test ID: 5.5
		 * Test Time: 2021/4/21 21:09
		 * Author: AoLi
		 * Viewer: HongjiaXue
		 *********************************************************************************/
		@Test
		void testCategorySpend5() {
			BoCCategory test = new BoCCategory("test");
			test.addExpense(new BigDecimal("50.00"));
			test.addExpense(new BigDecimal("0.00"));
			assertEquals(new BigDecimal("50.00"), test.CategorySpend());
		}
	}

	@Nested
	class TestSetCategoryName {
		/*********************************************************************************
		 * Test ID: 6.1
		 * Test Time: 2021/4/21 21:35
		 * Author: AoLi
		 * Viewer: HongjiaXue
		 *********************************************************************************/
		@Test
		void testSetCategoryName1() {
			BoCCategory test = new BoCCategory("test");
			test.setCategoryName("Apple");
			assertEquals("Apple", test.CategoryName());
		}

		/*********************************************************************************
		 * Test ID: 6.2
		 * Test Time: 2021/4/21 21:42
		 * Author: AoLi
		 * Viewer: HongjiaXue
		 *********************************************************************************/
		@Test
		void testSetCategoryName2() {
			BoCCategory test = new BoCCategory("test");
			test.setCategoryName("I-must-not-input-too-much-characters-like-this-one");
			assertNotEquals("I-must-not-input-too-much-characters-like-this-one", test.CategoryName());
		}

		/*********************************************************************************
		 * Test ID: 6.3
		 * Test Time: 2021/4/21 21:58
		 * Author: AoLi
		 * Viewer: HongjiaXue
		 *********************************************************************************/
		@Test
		void testSetCategoryName3() {
			BoCCategory test = new BoCCategory("test");
			test.setCategoryName("test");
			assertEquals("test", test.CategoryName());
		}

		/*********************************************************************************
		 * Test ID: 6.4
		 * Test Time: 2021/4/21 22:08
		 * Author: AoLi
		 * Viewer: HongjiaXue
		 *********************************************************************************/
		@Test
		void testSetCategoryName4() {
			BoCCategory test = new BoCCategory("test");
			test.setCategoryName("");
			assertNotEquals("", test.CategoryName());
		}

		/*********************************************************************************
		 * Test ID: 6.5
		 * Test Time: 2021/4/21 22:20
		 * Author: AoLi
		 * Viewer: HongjiaXue
		 *********************************************************************************/
		@Test
		void testSetCategoryName5() {
			BoCCategory test = new BoCCategory("test");
			test.setCategoryName("\r");
			assertNotEquals("\r", test.CategoryName());
		}
	}

	@Nested
	class testSetCategoryBudget {
		/**********************************************************************************
		 * Test ID: 7.1
		 * Test Time: 2021.4/21 19.01
		 * Author:Hongjia Xue
		 * Viewer:Ao Li
		 *********************************************************************************/
		@Test
		void testSetCategoryBudget1() {
			BoCCategory test = new BoCCategory("test");
			test.setCategoryBudget(new BigDecimal("50.00"));
			assertEquals(new BigDecimal("50.00"), test.CategoryBudget());
		}

		@Test
		void testSetCategoryBudget2() {
			BoCCategory test = new BoCCategory("test");
			test.setCategoryBudget(new BigDecimal("-50.00"));
			//here the CategoryBudegt can not be negative
			assertNotEquals(new BigDecimal("-50.00"), test.CategoryBudget());
		}

		@Test
		void testSetCategoryBudget3() {
			BoCCategory test = new BoCCategory("test");
			test.setCategoryBudget(new BigDecimal("0.00"));
			assertNotEquals(new BigDecimal("0.00"), test.CategoryBudget());
		}
	}

	@Nested
	class TestAddExpense {
		/**************************************************
		 * Test ID: 8.1
		 * Test Time: 2021.4/21 19.01
		 * Author:Hongjia Xue
		 * Viewer:Ao Li
		 ****************************************************/
		@Test
		void testAddExpense1() {
			BoCCategory test = new BoCCategory("test");
			test.addExpense(new BigDecimal("50.00"));
			assertEquals(new BigDecimal("50.00"), test.CategorySpend());
		}

		@Test
		void testAddExpense2() {
			BoCCategory test = new BoCCategory("test");
			test.addExpense(new BigDecimal("50.00"));
			test.addExpense(new BigDecimal("50.00"));
			assertEquals(new BigDecimal("100.00"), test.CategorySpend());
		}

		@Test
		void testAddExpense3() {
			BoCCategory test = new BoCCategory("test");
			test.addExpense(new BigDecimal("-50.00"));
			//here the CategorySpend and addExpense can not be negative
			assertNotEquals(new BigDecimal("-50.00"), test.CategorySpend());
		}
	}

	@Nested
	class TestRemoveExpense {
		/***************************************
		 * Test ID: 9.1
		 * Test Time: 2021.4/21 19.01
		 * Author:Hongjia Xue
		 * Viewer:Ao Li
		 ***************************************/
		@Test
		void testRemoveExpense1() {
			BoCCategory test = new BoCCategory("test");
			test.addExpense(new BigDecimal("50.00"));
			test.removeExpense(new BigDecimal("50.00"));
			assertEquals(new BigDecimal("0.00"), test.CategorySpend());
		}

		@Test
		void testRemoveExpense2() {
			BoCCategory test = new BoCCategory("test");
			test.addExpense(new BigDecimal("50.00"));
			test.removeExpense(new BigDecimal("-50.00"));
			//here the removeExpense can not be negative
			assertNotEquals(new BigDecimal("100.00"), test.CategorySpend());
		}

		@Test
		void testRemoveExpense3() {
			BoCCategory test = new BoCCategory("test");
			test.addExpense(new BigDecimal("0.00"));
			test.removeExpense(new BigDecimal("50.00"));
			//here the CategorySpend can not be negative
			assertNotEquals(new BigDecimal("-50.00"), test.CategorySpend());
		}
	}

	@Nested
	class TestResetBudgetSpend {
		/*********************************************
		 * Test ID: 10.1
		 * Test Time: 2021.4/21 19.01
		 * Author:Hongjia Xue
		 * Viewer:Ao Li
		 ****************************************************/
		@Test
		void testResetBudgetSpend1() {
			BoCCategory test = new BoCCategory("test");
			test.addExpense(new BigDecimal("50.00"));
			test.resetBudgetSpend();
			assertEquals(new BigDecimal("0.00"), test.CategorySpend());
		}

		@Test
		void testResetBudgetSpend2() {
			BoCCategory test = new BoCCategory("test");
			test.removeExpense(new BigDecimal("50.00"));
			test.resetBudgetSpend();
			assertEquals(new BigDecimal("0.00"), test.CategorySpend());
		}

		@Test
		void testResetBudgetSpend3() {
			BoCCategory test = new BoCCategory("test");
			test.setCategoryBudget(new BigDecimal("50.00"));
			test.removeExpense(new BigDecimal("30.00"));
			test.resetBudgetSpend();
			assertEquals(new BigDecimal("0.00"), test.CategorySpend());
		}
	}

	@Nested
	class TestGetRemainingBudget {
		/*****************************************
		 * Test ID: 11.1
		 * Test Time: 2021.4/21 19.01
		 * Author:Hongjia Xue
		 * Viewer:Ao Li
		 ********************************************/
		@Test
		void testGetRemainingBudget1() {
			BoCCategory test = new BoCCategory("test");
			test.setCategoryBudget(new BigDecimal("50.00"));
			test.addExpense(new BigDecimal("30.00"));
			assertEquals(new BigDecimal("20.00"), test.getRemainingBudget());
		}

		@Test
		void testGetRemainingBudget2() {
			BoCCategory test = new BoCCategory("test");
			test.setCategoryBudget(new BigDecimal("50.00"));
			test.addExpense(new BigDecimal("50.00"));
			assertEquals(new BigDecimal("0.00"), test.getRemainingBudget());
		}

		@Test
		void testGetRemainingBudget3() {
			BoCCategory test = new BoCCategory("test");
			test.setCategoryBudget(new BigDecimal("30.00"));
			test.addExpense(new BigDecimal("50.00"));
			assertEquals(new BigDecimal("-20.00"), test.getRemainingBudget());
		}

		@Test
		void testGetRemainingBudget4() {
			BoCCategory test = new BoCCategory("test");
			test.setCategoryBudget(new BigDecimal("0.00"));
			test.addExpense(new BigDecimal("0.00"));
			assertNotEquals(new BigDecimal("0.00"), test.getRemainingBudget());
		}
	}

	@Nested
	class TestToString {
		/************************************************
		 * Test ID: 12.1
		 * Test Time: 2021.4/21 19.01
		 * Author:Hongjia Xue
		 * Viewer:Ao Li
		 * Editor:Zhiwen Chen
		 * Version:3.1
		 ********************************************************/
		@Test
		void testToString1() {
			BoCCategory test = new BoCCategory("test");
			test.setCategoryName("Siri");
			test.setCategoryBudget(new BigDecimal("100.00"));
			test.addExpense(new BigDecimal("50.00"));
			assertEquals("Siri(¥100.00) - Est. ¥50.00 (¥50.00 Remaining)", test.toString());
		}

		@Test
		void testToString2() {
			BoCCategory test = new BoCCategory("test");
			test.setCategoryName("Siri");
			test.setCategoryBudget(new BigDecimal("100.00"));
			test.addExpense(new BigDecimal("100.00"));
			assertEquals("Siri(¥100.00) - Est. ¥100.00 (¥0.00 Remaining)", test.toString());
		}

		@Test
		void testToString3() {
			BoCCategory test = new BoCCategory("test");
			test.setCategoryName("");
			test.setCategoryBudget(new BigDecimal("100.00"));
			test.addExpense(new BigDecimal("50.00"));
			//here if nothing was set into setCategoryName, the name will be set into New Category
			assertEquals("New Category(¥100.00) - Est. ¥50.00 (¥50.00 Remaining)", test.toString());
		}

		@Test
		void testToString4() {
			BoCCategory test = new BoCCategory("test");
			test.setCategoryName("Siri");
			test.setCategoryBudget(new BigDecimal("50.00"));
			test.addExpense(new BigDecimal("100.00"));
			assertEquals("Siri(¥50.00) - Est. ¥100.00 (¥50.00 Overspent)", test.toString());
		}
	}
}
