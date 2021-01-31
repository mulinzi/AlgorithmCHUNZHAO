import java.util.LinkedList;
import java.util.List;

/**
 * @author
 * @version 1.0
 * @date 2021/1/31 18:50
 * @description //
 **/
//递归：
class Solution {
    List<String> res ;
    public List<String> generateParenthesis(int n) {
     res = new LinkedList<>();

        return null;
    }
//    一个字符串的拼接是由左右括号组成：每次加上左括号，右括号
//    限制括号的生成不能‘违法’，括号个数，左括号 <= n, 右括号< 左括号
    public void helper(int left,int right, int num,String s ){

        //terminate
        if(right == num  ){
            res.add(s);
        }
//        process
        if(left < num){
            helper(left + 1,right,num, s + "(");
        }
        if(right < left){
            helper(left, right + 1, num, s+")");
        }




    }

}