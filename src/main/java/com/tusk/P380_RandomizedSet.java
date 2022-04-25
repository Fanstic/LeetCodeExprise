package com.tusk;

import java.util.*;

/**
 * @author tusk
 * @desc leetcode-380:O(1) 时间插入、删除和获取随机元素
 * 实现RandomizedSet 类：
 * <p>
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * 输出
 * [null, true, false, true, 2, true, false, 2]
 * <p>
 * 解释
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
 * randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
 * randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
 * randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/12/20 15:32
 */
public class P380_RandomizedSet {
    Map<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> data = new ArrayList<>();

    public P380_RandomizedSet() {

    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return true;
        }

        data.add(val);
        map.put(val,data.size()-1);
        return false;
    }

    /**
     * 将要删除的元素交换到数组的尾部，然后弹出
     * @param val
     * @return
     */
    public boolean remove(int val) {
        if(map.containsKey(val)){

            int index = map.get(val);

            int temp = data.get(data.size() - 1);
            data.set(index,temp);
            //data.set(data.size() - 1,val);

            data = (ArrayList<Integer>) data.subList(0,data.size()-2);
            return true;
        }
        return false;
    }

    public int getRandom() {
        return data.get(new Random().nextInt(data.size()-1));
    }
}
