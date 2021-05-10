package com.tusk.primary.stack;

import java.util.Arrays;

/**
 * @author tusk
 * @desc 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/9 11:19
 */
public class P155_MinStack {
    private final static int MIN_SIZE = 1;
    private int[] data;
    private int capacity;
    private int size = 0;
    private Integer min;

    /**
     * initialize your data structure here.
     */
    public P155_MinStack() {
        data = new int[MIN_SIZE];
        capacity = MIN_SIZE;
        size = 0;
    }

    public static void main(String[] args) {
        P155_MinStack stack = new P155_MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());

        System.out.println(stack.getMin());
    }

    public void push(int val) {
        if (size >= capacity) {
            capacity += MIN_SIZE;
            data = Arrays.copyOf(data, capacity);
        }
        data[size] = val;


        if (min == null) {
            min = val;
        } else {
            min = min <= val ? min : val;
        }
        size++;
    }

    public void pop() {
        if (size < 1) {
            return;
        }

        if (size == 1) {
            data = new int[10];
            size = 0;
            capacity = MIN_SIZE;
        } else {
            int top = top();
            data = Arrays.copyOf(data, --size);

            if (top == min) {
                min = data[0];
                for (int i : data) {
                    if (i < min) {
                        min = i;
                    }
                }
            }
        }

    }

    public int top() {
        return data[size - 1];
    }

    public int getMin() {
        return min;
    }
}
