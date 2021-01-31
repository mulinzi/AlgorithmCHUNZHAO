import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author
 * @version 1.0
 * @date 2021/1/31 20:09
 * @description
 **/
public class preorderTraversal {


    class Solution {
        List<Integer> list;

        public List<Integer> preorderTraversal(TreeNode root) {
            list = new ArrayList<>();
            if (root == null) return list;

            Deque<TreeNode> stack  = new LinkedList<>();
            while(root != null || !stack.isEmpty()){
                while(root != null){
                    list.add(root.val);
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                root = root.right;


            }

            return list;
        }

        private void helper (TreeNode root){
            if(root == null) return;

            list.add(root.val);
            helper(root.left);
            helper(root.right);

        }
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

}