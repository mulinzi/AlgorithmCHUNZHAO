package homework;

/**
 * @author
 * @version 1.0
 * @date 2021/1/24 19:49
 * @description
 **/
public class isAnagram {class Solution {
    public boolean isAnagram(String s, String t) {

// 法一 排序 + 比对
        // 统计个数 map :
        // 数组+ 码值
        if(s.length() != t.length()) return false;
        char c = ' ';
        char c1 = ' ';
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0;i < s.length();i++){
            c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);  // getOrDefault(ch,0)
            c1 = t.charAt(i);
            Integer tmp = map.get(c1);
            map.put(c1,map.getOrDefault(c1,0) - 1);
        }
        for(Integer val : map.values()){
            if(val != 0) return false;
        }
        return true;




    }//method
}
}
