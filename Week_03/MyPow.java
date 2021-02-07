/**
 * @author
 * @version 1.0
 * @date 2021/2/4 13:34
 * @description
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）
 *
 *  循环 O(n)
 *  分治：拆解成子问题，在合并
 *  分析： x^10 = x^5 * x^5 (少了计算 在乘5个x的过程，相比穷举)  x^5 = x^2*x^2 * x (奇偶)
 *
 **/
public class MyPow {
    public double myPow(double x, int n) {
        double res = 0;
//        处理边界
        if(n == 0) return 1.0;
        if (n == 1) return x;
        if (n < 0){
            x = 1/x;
            n = -n;
        }
        helper(x,n);


        return res;
    }

    private double helper(double x, int n ){
//        terminate
        if(n == 0){
            return  1.0;
        }
        if (n == 1){
            return x;
        }
//        drill down, process;  在本层中就看做我从，一个/2的幂函数那里获取值，虽然后面是递归的多层，直到返回函数
        double res = helper(x,n/2);
//        merge (分奇偶)
        if(n % 2 == 0){
            return  res * res;
        }else{
            return res * res * x;
        }



    }

}
