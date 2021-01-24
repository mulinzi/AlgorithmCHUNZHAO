package homework;

/**
 * @author
 * @version 1.0
 * @date 2021/1/24 19:47
 * @description
 **/
public class twoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {

            // // for(int i = 0; i<nums.length;i++){
            //     for(int j = i+1; j<nums.length;j++){
            //         if(nums[i] + nums[j] == target)
            //         return new int[]{i,j};
            //     }

            // }
            // return new int[2];
            // }
            //上述方法遍历了两次，n的平方复杂度。 遍历了两次数组，包含了重复信息。



// Map一次遍历法

            Map<Integer,Integer> map = new HashMap();
            for(int i = 0; i < nums.length; i++){
                int s = target - nums[i];
                if(map.containsKey(s)){
                    return new int[]{i,map.get(s)};
                }else{
                    map.put(nums[i],i);   //遍历的同时放入元素,随着数组的访问,会找到匹配值
                }
            }
            return new int[2];
        }

    }
}
