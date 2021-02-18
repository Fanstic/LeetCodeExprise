import com.tusk.P7_NumberReverse;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author tusk
 * @desc
 * @date 2020/11/25 9:18
 */
public class P7NumberReverseTest {


    @Test
    public void test(){
        int result = P7_NumberReverse.reverse(1234);
        Assert.assertEquals(4321,result);
    }
}
