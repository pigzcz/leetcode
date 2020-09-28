package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/28 15:49
 * @Description:
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *
 */
public class Q117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        List<Node> tmp = new ArrayList<>();
        tmp.add(root);
        while(tmp.size()!=0){
            List<Node> tt = new ArrayList<>();
            for (int i=0;i<tmp.size();i++){
                int next = i+1;
                Node current = tmp.get(i);
                if (next<tmp.size()){
                    Node n = tmp.get(next);
                    current.next = n;
                }
                if (current.left != null){
                    tt.add(current.left);
                }
                if(current.right != null){
                    tt.add(current.right);
                }
            }
            tmp = tt;
        }
        return root;
    }
}
