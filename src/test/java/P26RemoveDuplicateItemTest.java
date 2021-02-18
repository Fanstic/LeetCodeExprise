import com.tusk.P26_RemoveDuplicateItem;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author tusk
 * @desc
 * @date 2020/11/26 12:20
 */
public class P26RemoveDuplicateItemTest {

    @Test
    public void test(){
        int[] arr = {1,1,3};
        int size = P26_RemoveDuplicateItem.removeDuplicateImprove(arr);

        Assert.assertEquals(size,2);
    }
}
