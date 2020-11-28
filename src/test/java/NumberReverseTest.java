import com.tusk.NumberReverse;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author tusk
 * @desc
 * @date 2020/11/25 9:18
 */
public class NumberReverseTest {


    @Test
    public void test(){
        int result = NumberReverse.reverse(1234);
        Assert.assertEquals(4321,result);
    }
}
