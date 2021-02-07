import sun.awt.windows.WPrinterJob;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author
 * @version 1.0
 * @date 2021/2/4 17:18
 * @description  最小基因变化
 *
 *  看作一个广度遍历 ，回溯？
 **/
public class MinMutation {
    int  minStep = Integer.MAX_VALUE;
    char[] arr = new char[]{'A', 'C', 'G', 'T'};

    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end =  "AACCGGTA";
        String[] bank = new String[]{"AACCGGTA"};
        MinMutation c = new MinMutation();
        c.minMutation(start,end,bank);
        System.out.println("minStep:" + c.minStep);
    }
    public int minMutation(String start, String end, String[] bank) {

        HashSet<String> bankSet  = new HashSet<>(Arrays.asList(bank));
        if(!bankSet.contains(end)) {
            return -1;
        }


        helper(new HashSet<>(),start,end,bankSet,0);
        return  (minStep == Integer.MAX_VALUE) ? -1 : minStep;
    }

//    超时，找到库中与当前基因相差一个碱基的就是下一步变化的基因，这时步数+1并进入下一层会比上面的方式省很多。
//    省去了替换四个字符串的时间
    private void helper(HashSet<String> step,String curr, String end, HashSet<String> bankSet, int level) {
//        当前层大于等于 最小步数，没有下一步的必要
        if (level >= minStep) return;

        if(curr.equals(end)) {
            minStep = Math.min(level, minStep);
            return;
        }
        for (String str: bankSet){
            int diff = 0;
            for (int i = 0; i < str.length();i++){
                if (curr.charAt(i) != str.charAt(i)){
                    if(++diff > 1)
                        break;
                }
            }
            if (diff == 1 && !step.contains(str)){ //保证只有一个字符不同，以及之前没有遍历过这个字符
                step.add(str);
                helper(step,str,end,bankSet,level+1);
                step.remove(str);
            }

        }



    }
}
