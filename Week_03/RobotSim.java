import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * @author
 * @version 1.0
 * @date 2021/2/7 19:32
 * @description
 * // 根据命令确定 下次移动的方向
 * // 每次移动是判断，路线上是否有障碍，有障碍的话，就要看移动到哪个地方
 * // 移动情况:  x+（向东） x-（向西） , y+（向北）, y-（向南）,
 * // directx：{0,1,0,-1}
 * // directy: {1,0,-1,0}
 * //   上下对应，为北东南西的xy操作， 下标代表方向，0 1，2，3 为 北东南西
 * //currDirec  代表当前方向， 0 -3， 右转， （ +1）% 4 左转：(+3)%4
 * // 每次移动完毕，计算欧式距离的平方
 **/
public class RobotSim {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0,y = 0;
        int res = 0;
        int[] directx={0,1,0,-1};
        int[] directy={1,0,-1,0};
        int currDire  = 0;

        Set<Pair<Integer,Integer>> obstacleSet=new HashSet<>();
        for (int i = 0; i <obstacles.length ; i++) {
            obstacleSet.add(new Pair<>(obstacles[i][0],obstacles[i][1]));
        }
        for(int command : commands){
            if(command == -2 ){ //处理左转向

                currDire = (currDire + 3) % 4;

            }else if(command == -1){

                currDire = (currDire + 1) % 4;

            }else{//移动，根据方向决定移动

                for(int i = 1 ; i <= command;i++){
                    int nx = x + directx[currDire];
                    int ny = y + directy[currDire];
                    if(!obstacleSet.contains(new Pair<>(nx,ny))){
                        x=nx;
                        y=ny;
                        res=Math.max(res,x*x+y*y);
                    }
                    else {
                        break;
                    }
                }

            }
        }//for
        return res;

    }
}
