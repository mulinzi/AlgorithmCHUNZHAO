package homework;

/**
 * @author
 * @version 1.0
 * @date 2021/1/24 19:45
 * @description
 **/
public class mergeTwoLists {
    //  1.以一个链表为返回链表,将另一个链表(l2)的数据按顺序添加进来, 即遍历到l2数据小于l1位置, 注意返回节点的边界问题,有可能l2插入在l1头节点之前
//应该可以,以较小值的头节点为返回节点,通过定义新的node来分别指向两个节点,一个node指向较小,一个指向较大.
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            if(l1 == null || l2 == null){
                return l1 == null? l2:l1; //l1为null的话返回另一个链表.
            }

            ListNode curr = l1;
            ListNode pre = null;
            while(l2 != null){

                while(curr != null && l2.val >= curr.val){//向后移动指针,直到l1的节点大于l2的值,将l2插入此节点前面
                    pre = curr;
                    curr = curr.next;
                }
                //将l2节点连接到l1上
                ListNode tmp = l2;
                l2 = l2.next;
                if(pre != null){ //l2添加的位置不是l1头节点之前
                    pre.next = tmp;
                }else{ //此时l2的添加位置在l1头节点之前,更换头节点
                    l1 = tmp;
                }
                tmp.next = curr;

                pre = tmp; //紧跟curr
            }
            return l1;


        }
}
