/**
 * @author
 * @version 1.0
 * @date 2021/2/7 19:24
 * @description
 **/
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[3]; //0，1，2分别代表 5，10，20的个数

        for(int num : bills){
            //判断是否够找零，如果不够则返回false，如果够则money+5,bill就三种情况

            if(num == 5){
                money[0]++;
            }else if(num == 10){//找零5元
                if(money[0] == 0) return false; //
                money[0]--;
                money[1]++;
            }else if(num == 20){//找零分两种情况，倾向于一个10，一个5
                if(money[0]>0 && money[1] > 0){
                    money[0] -- ;
                    money[1] --;
                }else if(money[0] > 2){ //三张15元的
                    money[0] -= 3;
                }else{ //两种情况都不符合
                    return false;
                }

            }


        }
        return true;

    }
}
