import com.tusk.PalindromicNumCheck;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author tusk
 * @desc
 * @date 2020/11/28 10:52
 */
public class PalinDromicNumCheckTest {

    int a = 1;
    int b = 12;
    int c = 121;
    int d = 1221;
    int e = 120;

    @Test
    public void test(){
        Assert.assertFalse(PalindromicNumCheck.check(a));
        Assert.assertFalse(PalindromicNumCheck.check(b));
        Assert.assertTrue(PalindromicNumCheck.check(c));
        Assert.assertTrue(PalindromicNumCheck.check(d));
        Assert.assertFalse(PalindromicNumCheck.check(e));


    }
}
