import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;

import java.util.*;

/**
 * @author
 * @version 1.0
 * @date 2021/1/31 19:10
 * @description N叉树 后序遍历  递归       非递归 栈 入栈出栈顺序，（相当于逆置后序遍历的顺序入栈）
 **/
public class postorder{
    class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> res = new ArrayList<>();
//            非递归
            if(root == null) return res;
            Deque<Node> stack  = new LinkedList<>();
            stack.push(root);
            while( !stack.isEmpty()){
                 root = stack.pop();
                 res.add(root.val);
                 for(Node n : root.children){
                     stack.push(n);
                 }

            }
            Collections.reverse(res);


//            非递归



           // 递归
//            helper(root,res);

            return res ;
    }
//
    public void helper(Node root,List<Integer>res){
            if(root == null) return;
        for(Node n : root.children){
            helper(n,res);
        }

        res.add(root.val);

    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
}