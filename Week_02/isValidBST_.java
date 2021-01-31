/**
 * @author
 * @version 1.0
 * @date 2021/1/31 15:42
 * @description 中序遍历，如果某个节点小于等于前一个节点，则不是升序排列，非二叉搜索树
 **/

    class solution{
        long pre =  Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
//        遍历左节点
        if(!isValidBST(root.left)){
            return false;

        }
//        访问当前节点：如果当前节点小于等于中序遍历的前一个节点，不满足BST
        if(root.val <= pre){
            return false;
        }
        pre = root.val;
//  遍历右节点
        return isValidBST(root.right);






    }






         class TreeNode {
             int val;
              TreeNode left;
              TreeNode right;
              TreeNode() {}
              TreeNode(int val) { this.val = val; }TreeNode(int val, TreeNode left, TreeNode right) {
                  this.val = val;
                  this.left = left;
                  this.right = right;
              }
          }
    }

