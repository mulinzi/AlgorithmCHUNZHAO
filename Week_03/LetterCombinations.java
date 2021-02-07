import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @version 1.0
 * @date 2021/2/4 13:48
 * @description
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 递归：类比括号问题，每层选择的不在是左右括号，而是在每层数字代表的字母中选择
 * 由于字符串的不可变性，不需revers
 **/
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> res  = new ArrayList<>();
//        边界
        if(digits.length() == 0) return res;
        //用map来标志每个数字代表了哪些字母
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        return res;
    }
//    s:拼接的字符串，不可变性，不需reverse
    private void  helper(String digits,String s,Map<Character,String> map, int level,List<String>res){
//        terminate
        if (level == digits.length()){
            res.add(s);
            return;
        }
//        process  and drill down
        String word = map.get(digits.charAt(level));
        for(char c : word.toCharArray()){
            helper(digits,s + c,map, level + 1,res);
        }

//        reverse





    }
}

