import java.util.*;

/**
 * @author
 * @version 1.0
 * @date 2021/1/31 20:16
 * @description N叉树的层次遍历
 **/
public class levelOrder {
    class Solution {

        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res  = new ArrayList();
            if (root == null) return res;
//            维护两个队列，分别记录当前层和下一层节点
            Deque<Node> curr = new LinkedList<>();
            curr.add(root);
            while(!curr.isEmpty()){
                Deque<Node> next = new LinkedList<>();
                List<Integer> valList = new ArrayList<>(); //存储当前节点所有值
                for (Node node :curr){
                    valList.add(node.val);
//                    同时存入下一层节点
                    next.addAll(node.children);
                }
                curr = next;
                res.add(valList);
            }



            return res;


        }

//        递归
// level 代表当前在哪个层级
    private void helper(Node node, int level ,  List<List<Integer>> res){
        //如果node为null的话，不会走到这一层，level从0开始，因此res中的数量应该是level+1
        if(res.size() <= level){
            res.add(new ArrayList());
        }
        // 将当前元素添加进对应层的list
        res.get(level).add(node.val);
        //继续向下遍历孩子节点
        for(Node n : node.children){   // n为空的话不会执行，因此到达下一层的一定不为空
            helper(n,level + 1,res);
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
