package homework;

import java.util.*;

/**
 * @author
 * @version 1.0
 * @date 2021/1/24 19:19
 * @description
 **/
public class groupAnagrams {

    // 1.排序后的字符串作为key值,字符串作为map的val值     时间 O(nklog k) 空间  O(nk)
// 2.将字符串出现的次数和字符一起拼接,用一个26长度的数组存储,这样顺序也是一样. O(n(k+∣Σ∣))
//二者的不同是,作为key值的方式,最后都是通过map转换
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            // 1.
            Map<String,List<String>> map = new HashMap();
            for(String str: strs){
                // 字符串转为数组,并排序
                char[] charArr = str.toCharArray();
                Arrays.sort(charArr);
                //从map里取出key对应的组
                String key = new String(charArr);
                List<String> list = map.getOrDefault(key,new ArrayList<String>());
                //将字符串放入对应的组里
                list.add(str);
                map.put(key,list);

            } //for
            return new ArrayList<List<String >>(map.values());

        }//method
    }
}
