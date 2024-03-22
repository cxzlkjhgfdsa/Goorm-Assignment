package work;

import java.util.ArrayDeque;
import java.util.Queue;

public class CustomQueue<E> {
    MyLinkedList<E> list = new MyLinkedList<E>();

    Queue<Integer> que = new ArrayDeque<>();
    public E poll(){
        return list.removeFirst();
    }

    public E offer(E data){
        list.add(data);
        return data;
    }

    public E peek(){
        return  list.get(0);
    }

    public void clear(){
        list.clear();
    }

    public boolean isEmpty(){
        if(list.size() == 0)
            return  true;
        else
            return false;
    }

}
