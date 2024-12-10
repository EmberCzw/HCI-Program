//Written by Qiwen Wang
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

//Run the test with specified runner
@RunWith(Parameterized.class)
public class setTransactionValueTest {
    private final BigDecimal input;
    private final BigDecimal expected;
    static BoCTransaction tran2 = new BoCTransaction();

    @Parameterized.Parameters
    public static Collection prepareData() {
        //Input and expected data used to test
        Object [][] object = {
                {new BigDecimal("-66.66"),null},
                {new BigDecimal("12345"),new BigDecimal("12345")},
                {new BigDecimal("6789"),new BigDecimal("12345")}
        };
        //Return a two-dimensional array to facilitate the control of test data
        return Arrays.asList(object);
    }

    public setTransactionValueTest(BigDecimal input,BigDecimal expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        //Method to be tested
        tran2.setTransactionValue(input);
        BigDecimal result = tran2.transactionValue();
        Assert.assertEquals(expected,result);
    }
}
