import java.util.Arrays;

/**
 * @author
 * @version 1.0
 * @date 2021/2/7 19:31
 * @description//  排序后，依次对比
 **/
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int c = 0; //标识s 饼干位置
        int length = s.length;
        int res = 0;
        for(int i = 0; i< g.length && c < length;i++){
            if(g[i] <= s[c]){
                res++;
                c++;
            }else{//向后遍历饼干
                while(++c < length){
                    if(g[i] <= s[c]){ //找到饼干
                        res++;
                        c++;
                        break;
                    }
                }
            }
        }//for
        return res;

    }
}
