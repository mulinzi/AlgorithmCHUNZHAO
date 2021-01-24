package homework;

/**
 * @author
 * @version 1.0
 * @date 2021/1/24 19:50
 * @description
 **/
public class MyCircularDeque {
    // 1使用静态数组实现
// 2.定义队头front,队尾rear,
// 3.rear指向最后一个元素的下一元素,为空值,front指向第一个元素
// 4. 判空 front == rear   判满: (rear + 1) % capacity = front
// 5.移动指针的取余:向前时减一先加数组长度在取余
// 队头
//    插入:先减,在赋值 ,  删除:先删,在移动
// 队尾: 插入先赋值,在移动,  删除:先移动,在删
    private int capacity;
    private int [] array;
    private int front;
    private int rear;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity = k + 1; //注意容量,rear多占了一个空位置
        this.array = new int[capacity];
        this.front = 0;
        this.rear = 0;

    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) {
            return false;
        }
        //减一 再加容量,在取余
        front = (front - 1 + capacity) % capacity;
        array[front] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        //(队尾+1 )%capa
        if(isFull())  return false;
        //先赋值,在移动, 因为队尾指向的是空位置
        array[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        //(fron +1 ) % capa
        // 先删后加,相当于 直接移动
        if(isEmpty()) return false;
        front = (front + 1) % capacity;
        return true;

    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        // (rear -1 + capacity) % capacity
        // 先移动后删除
        if(isEmpty()) return false;

        rear = (rear - 1 + capacity) % capacity;
        return true;

    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()) return -1;
        return array[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty())
            return -1;

        return array[(rear-1 + capacity) % capacity];

    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(rear == front ){
            return true;
        }else{
            return false;
        }
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {

        return  (rear + 1) % capacity == front;


    }
}
