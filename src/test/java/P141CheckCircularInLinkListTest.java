import com.tusk.primary.linkedlist.P141_CheckCircularInLinkList;
import com.tusk.model.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author tusk
 * @desc
 * @date 2020/11/26 16:51
 */
public class P141CheckCircularInLinkListTest {

    @Test
    public void test(){
        ListNode root1 = new ListNode(1);

        ListNode node1 = new ListNode(2);

        root1.setNext(node1);
        node1.setNext(root1);

        boolean result1 = P141_CheckCircularInLinkList.check(root1);

        Assert.assertTrue(result1);

        ListNode root2 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        root2.setNext(node2);
        node2.setNext(node3);
        node3.setNext(root2);

        Assert.assertTrue(P141_CheckCircularInLinkList.check(root2));
    }
}
