//Written by Qiwen Wang
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

//Run the test with specified runner
@RunWith(Parameterized.class)
public class setTransactionNameTest {

    private final String input;
    private final String expected;
    static BoCTransaction tran2 = new BoCTransaction();

    @Parameterized.Parameters
    public static Collection prepareData() {
        //Input and expected data used to test
        Object [][] object = {
                {"abcdefghijklmnopqrstuvwxyz","abcdefghijklmnopqrstuvwxy"},{"Paul George","abcdefghijklmnopqrstuvwxy"}
        };
        //Return a two-dimensional array to facilitate the control of test data
        return Arrays.asList(object);
    }

    public setTransactionNameTest(String input,String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        //Method to be tested
        tran2.setTransactionName(input);
        String result = tran2.transactionName();
        Assert.assertEquals(expected,result);
    }
}
