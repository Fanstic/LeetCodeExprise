import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;

/**
 * @author tusk
 * @desc
 * @date 2021/12/20 9:49
 */
public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> minQue = new PriorityQueue<>((a, b) -> b - a);

        minQue.offer(2);
        minQue.offer(1);
        minQue.offer(0);
        minQue.offer(5);

        while (!minQue.isEmpty()){
            System.out.println(minQue.poll());
        }
    }
}
