import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author
 * @version 1.0
 * @date 2021/1/31 20:37
 * @description
 **/
public class topKFrequent {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            int [] res = new int[k];
//            统计频率
             Map<Integer,Integer> map = new HashMap();
             for(int num: nums){
                 map.put(num,map.getOrDefault(num,0) + 1);
             }
//             构建小顶堆
            PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
//             放入小顶堆k个元素
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
//                堆里的元素小于k，继续添加
                if (minHeap.size() < k){
                    minHeap.add(entry);
                }else{
//                与堆顶元素进行比较,如果大就入堆
                    if(entry.getValue() >  minHeap.peek().getValue()){
                        minHeap.poll();
                        minHeap.add(entry);
                    }
                }
            }
             int i = 0;
             while(i < k){
                 Map.Entry<Integer,Integer> entry = minHeap.poll();
                 res[i++] = entry.getKey();
             }

            return res;
        }
    }//solution
}
