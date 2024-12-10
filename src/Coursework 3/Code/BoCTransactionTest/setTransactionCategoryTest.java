//Written by Qiwen Wang
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

//Run the test with specified runner
@RunWith(Parameterized.class)

public class setTransactionCategoryTest {
    private final int input;
    private final int expected;
    static BoCTransaction tran2 = new BoCTransaction();

    @Parameterized.Parameters
    public static Collection prepareData() {
        //Input and expected data used to test
        Object [][] object = {
                {1,1},{0,0},{20,20},{-5,20}
        };
        //Return a two-dimensional array to facilitate the control of test data
        return Arrays.asList(object);
    }

    public setTransactionCategoryTest(int input,int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
         //Method to be tested
        tran2.setTransactionCategory(input);
        int result = tran2.transactionCategory();
        Assert.assertEquals(expected,result);
    }
}
