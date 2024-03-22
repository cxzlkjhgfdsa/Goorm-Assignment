package work;
public class CustomStack<E> {

    MyLinkedList<E> list = new MyLinkedList<>();
    public E pop(){
        return list.removeLast();
    }

    public E push(E data){
        list.add(data);
        return data;
    }

    public E peek(){
       return  list.get(list.size()-1);
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
