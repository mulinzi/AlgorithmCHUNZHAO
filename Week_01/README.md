学习笔记

Deque<String> deque = new LinkedList<String>();

deuqe.addFirst("a");

deque.addFirsr("b");

deque.addFirst("c");

System.Out.println(deque);

String str = deque.peekFirst();

System.Out.println(str);

System.Out.println(deque);

while(deque.size() > 0){

System.Out.println(deque.removeFirst);

}

分析 Queue 和 Priority Queue 的源码。
HashMap源码分析（主要get() put()）：