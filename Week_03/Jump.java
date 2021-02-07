/**
 * @author
 * @version 1.0
 * @date 2021/2/7 19:37
 * @description// 每次选取，能够到达最远位置的下标， （为什么能保证一定到达终点？）
 * // 是在跳跃能够到达的范围内，找到能达到下一跳的最大范围的下标，然后再从这个范围中找，因为最后必然能到达最后一个位置
 **/
public class Jump {
    public int jump(int[] nums) {
        int maxPosition = -1;
        int end = 0 ; //下一跳能到达的最远位置
        int steps = 0;
        // 依次遍历，每个位置能到达的位置，并选定第二跳范围
        for(int i = 0; i < nums.length-1;i++){ //作为第一跳的下标

            maxPosition = Math.max(maxPosition,i + nums[i]); //当前位置能够到达的最远位置
            if(i == end){ //end用来限定第二跳的范围
                end = maxPosition;
                steps++;
            }

        }
        return steps;



    }
}
