import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author
 * @version 1.0
 * @date 2021/1/31 19:40
 * @description N叉前序遍历
 **/
public class preorder {
    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> res = new ArrayList<>();
            if(root == null ) return  res;
//             digui
            //            helper(root,res);
//            非递归
            Deque<Node> stack = new LinkedList<>();
            stack.push(root);

            while( !stack.isEmpty()){
                root = stack.pop();
                res.add(root.val);
                for (int i = root.children.size(); i > 0 ; i--) {
                    stack.push(root.children.get(i));
                }

        }

//            非递归

            return res;
        }

        private void helper(Node root,List<Integer>res){
            if (root == null) return ;
            res.add(root.val);
            for( Node node : root.children){
                helper(node,res);
            }

        }



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
