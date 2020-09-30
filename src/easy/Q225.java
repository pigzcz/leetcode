package easy;

import java.util.LinkedList;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/8 17:03
 * @Description:
 * 225. 用队列实现栈
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 */
public class Q225 {
    LinkedList<Integer> q1 = new LinkedList<>();
    LinkedList<Integer> q2 = new LinkedList<>();
    boolean now1 =true;

    /** Initialize your data structure here. */
    public Q225() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (now1){
            q1.addLast(x);
        } else {
            q2.addLast(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int k =0;
        if (now1){
            while (q1.size()>0){
                Integer integer = q1.pollFirst();
                k=integer;
                if (q1.size()!=0){
                    q2.addLast(integer);
                }
            }
            now1=!now1;
        } else {
            while (q2.size()>0){
                Integer integer = q2.pollFirst();
                k=integer;
                if (q2.size()!=0){
                    q1.addLast(integer);
                }
            }
            now1=!now1;
        }
        return k;
    }

    /** Get the top element. */
    public int top() {
        int k =0;
        if (now1){
            while (q1.size()>0){
                Integer integer = q1.pollFirst();
                k=integer;

                q2.addLast(integer);

            }
            now1=!now1;
        } else {
            while (q2.size()>0){
                Integer integer = q2.pollFirst();
                k=integer;

                q1.addLast(integer);

            }
            now1=!now1;
        }
        return k;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (now1){
            return q1.size()==0;
        } else {
            return q2.size()==0;
        }
    }
}


