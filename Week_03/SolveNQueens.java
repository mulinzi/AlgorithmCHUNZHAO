import java.util.*;

/**
 * @author
 * @version 1.0
 * @date 2021/2/4 14:08
 * @descriptionn 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 左线： x +y相等   右线 x-y相等
 * 递归处理每一层，
 *     判断列是否符合条件，符合，修改变量，继续向下递归，直到达到条件
 *     变量： 存储之前皇后的 ‘竖’‘pie’‘na’ ，以及记录皇后所在位置的数组，等待条件到达，数组转成棋盘返回 需要清除其状态。
 **/
public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        Set<Integer> col = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        helper(res,col,pie,na,queens,0,n);

        return res;
    }

    private void helper(List<List<String>> res, Set<Integer> col, Set<Integer> pie, Set<Integer> na, int[] queens, int row,int n) {

//        terminate
        if (row == n){
            List<String> list = generate(queens);
            res.add(list);
            return;
        }
//        process and drill down
//        相当于处理当前行的每一列
        for (int i = 0;i  < n;i++){
//            当前位置不符合
            if (col.contains(i) || pie.contains(i+row) || na.contains(row - i)){
                continue;
            }
//            修改变量，drill down
            col.add(i);
            pie.add( i + row);
            na.add(row - i);
            queens[row] = i;
            helper(res,col,pie,na,queens,row,n);
//            在递归处理下一列之前，清空当前状态
//            reverse
            col.remove(i);
            pie.remove(i + row);
            na.remove(row - i);
            queens[row] = -1;
        }
    }

    private List<String> generate(int[] queens) {
        List<String> res = new ArrayList<>();
        int n = queens.length;
        for (int col:queens){
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[col] = 'Q';
            res.add(String.valueOf(row));
        }
        return res;
    }
}
