package leetcode.algo.design.leet_zh_225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    /*
    *
    * 225. 用队列实现栈
    *
    使用队列实现栈的下列操作：
    push(x) -- 元素 x 入栈
    pop() -- 移除栈顶元素
    top() -- 获取栈顶元素
    empty() -- 返回栈是否为空
    注意:

    你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
    你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
    你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。

    *
    *
    * 执行用时 : 96 ms, 在Implement Stack using Queues的Java提交中击败了26.66% 的用户
    * 内存消耗 : 35.8 MB, 在Implement Stack using Queues的Java提交中击败了50.16% 的用户

    * */

    private Queue<Integer> queue;
    private Queue<Integer> queue_top;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();
        queue_top = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.offer(x);
        while (!queue_top.isEmpty()) {
            queue.offer(queue_top.poll());
        }
        while (!queue.isEmpty()) {
            queue_top.offer(queue.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        Integer ret = queue_top.poll();
        if (ret != null)
            return ret;
        return -1;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue_top.element();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue_top.size() == 0;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */