import com.tusk.P9_PalindromicNumCheck;
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
        Assert.assertFalse(P9_PalindromicNumCheck.check(a));
        Assert.assertFalse(P9_PalindromicNumCheck.check(b));
        Assert.assertTrue(P9_PalindromicNumCheck.check(c));
        Assert.assertTrue(P9_PalindromicNumCheck.check(d));
        Assert.assertFalse(P9_PalindromicNumCheck.check(e));


    }
}
