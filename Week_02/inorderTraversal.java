import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author
 * @version 1.0
 * @date 2021/1/31 20:01
 * @description 二叉中序遍历
 **/
public class inorderTraversal {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) return res;
            Deque<TreeNode> stack = new LinkedList<>();
            while(root != null || !stack.isEmpty()){

                while(root!= null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                res.add(root.val);
                root = root.right;

            }


            return  res;
        }

//        递归
        private void helper(TreeNode root,List<Integer>res){
            if(root == null) return;
            helper(root.left,res);
            res.add(root.val);
            helper(root.right, res);


        }
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
         this.left = left;
          this.right = right;
      }
  }

}
