import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @version 1.0
 * @date 2021/2/4 13:10
 * @description
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 * 递归：每一层取或者不取（回溯）
 * 迭代：每一次对原有的集合的每一个集合在添加一个新的元素，作为一个新的集合
 **/
public class subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
//        迭代 循环枚举

        for(int num:nums){
            int size = res.size();
            for(int i = 0;i < size; i++){
                List<Integer> newList = new ArrayList<>(res.get(i));
                newList.add(num);
                res.add(newList);
            }
        }


        return res;
    }
    //list 作为当前层所要添加的集合
    public void helper(int level,int[] nums,List<List<Integer>> res, List<Integer> list){
        if(level == nums.length){
            res.add(list);
            return ;
        }
        //不添加当前层元素
        helper(level+1, nums, res, list);

        //添加当前层元素
        list.add(nums[level]);
        helper(level +1 ,nums,res,list);

//        reverse curr state
        list.remove(list.size() -1);


    }

}
