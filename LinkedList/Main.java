package work;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(0);
        list.add(1);
        list.addLast(2);
        list.addFirst(3);
        list.add(1, 100);

        System.out.print("List data => ");
        for(Integer next : list){
            System.out.print(next+" ");
        }
        System.out.println();
        System.out.println(" ------------------------------------ ");

        CustomStack<Integer> stack = new CustomStack<>();

        stack.push(0);
        stack.push(1);
        stack.push(2);

        System.out.println("stack top => " + stack.peek());
        System.out.println("stack pop => " +stack.pop());
        System.out.println("stack pop => " +stack.pop());
        System.out.println(" ------------------------------------ ");

        CustomQueue<Integer> queue = new CustomQueue<>();

        queue.offer(0);
        queue.offer(1);
        queue.offer(2);

        System.out.println("queue top => " + queue.peek());
        System.out.println("queue poll => " +queue.poll());
        System.out.println("queue poll => " +queue.poll());




    }
}
