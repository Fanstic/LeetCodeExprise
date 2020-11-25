import com.tusk.TwoNumberReverse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author tusk
 * @desc
 * @date 2020/11/25 9:18
 */
public class TwoNumberReverseTest {


    @Test
    public void test(){
        int result = TwoNumberReverse.reverse(1234);
        Assert.assertEquals(4321,result);
    }
}
