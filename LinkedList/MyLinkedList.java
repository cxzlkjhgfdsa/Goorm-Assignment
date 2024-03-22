package work;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Singly LinkedList
 */
public class MyLinkedList<E> implements Iterable<E>{

    private Node<E> head;  // 노드의 첫 부분을 가리키는 포인트
    private Node<E> tail;  // 노드의 마지막 부분을 가리키는 포인트
    private int size; // 리스트 내에 들어있는 요소의 개수

    public MyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void clear(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    public int size(){
        return size;
    }


    @Override
    public String toString() {
        // 1. 만일 head 가 null 일 경우 빈 배열
        if(head == null) {
            return "[]";
        }

        // 2. 현재 size만큼 배열 생성
        Object[] array = new Object[size];

        // 3. 노드 next를 순회하면서 배열에 노드값을 저장
        int index = 0;
        Node<E> n = head;
        while (n != null) {
            array[index] = (E) n.data;
            index++;
            n = n.next;
        }

        // 3. 배열을 스트링화하여 반환
        return Arrays.toString(array);
    }

    // 요소를 바꾸는 메소드
    public void set(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        // 1. search 메소드를 이용해 교체할 노드를 얻는다.
        Node<E> replace_node = search(index);

        // 2. 교체할 노드의 요소를 변경한다.
        replace_node.data = null;
        replace_node.data = value;
    }

    // 요소를 얻는 메소드
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return search(index).data;
    }

    // 마지막 요소 삭제
    public E removeLast() {
        return remove(size - 1);
    }

    // 값으로 삭제하는 메소드
    public boolean remove(Object value) {

        // 1. 만약 삭제할 요소가 아무것도 없으면 에러
        if (head == null) {
            throw new RuntimeException();
        }

        // 2. 이전 노드, 삭제 노드, 다음 노드를 저장할 변수 선언
        Node<E> prev_node = null;
        Node<E> del_node = null;
        Node<E> next_node = null;

        // 3. 루프 변수 선언
        Node<E> i = head;

        // 4. 노드의 next를 순회하면서 해당 값을 찾는다.
        while (i != null) {
            if (Objects.equals(i.data, value)) {
                // 노드의 값과 매개변수 값이 같으면 삭제 노드에 요소를 대입하고 break
                del_node = i;
                break;
            }

            // Singly Linked List에는 prev 정보가 없기 때문에 이전 노드에도 요소를 일일히 대입하여야 함
            prev_node = i;

            i = i.next;
        }

        // 5. 만일 찾은 요소가 없다면 리턴
        if (del_node == null) {
            return false;
        }

        // 6. 만약 삭제하려는 노드가 head라면, 첫번째 요소를 삭제하는 것이니 removeFirst()를 사용
        if (del_node == head) {
            removeFirst();
            return true;
        }

        // 7. 다음 노드에 삭제 노드 next의 요소를 대입
        next_node = del_node.next;

        // 8. 삭제 요소 데이터 모두 제거
        del_node.next = null;
        del_node.data = null;

        // 9. 요소가 삭제 되었으니 크기 감소
        size--;

        // 10. 이전 노드가 다음 노드를 참조하도록 업데이트
        prev_node.next = next_node;

        return true;
    }

    // 특정 요소를 삭제하는 메소드
    public E remove(int index) {

        // 1. 인덱스가 0보다 작거나 size 보다 크거나 같은 경우 에러 (size와 같을 경우 빈 공간을 가리키는 거니까)
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        // 2. 인덱스가 0이면 removeFirst 메서드 실행하고 리턴
        if (index == 0) {
            return removeFirst();
        }

        // 3. 삭제할 위치의 이전 노드 저장
        Node<E> prev_node = search(index - 1);

        // 4. 삭제할 위치의 노드 저장
        Node<E> del_node = prev_node.next;

        // 5. 삭제할 위치의 다음 노드 저장
        Node<E> next_node = del_node.next;

        // 6. 삭제될 첫번째 요소의 데이터를 백업
        E returnValue = del_node.data;

        // 7. 삭제 노드의 내부 요소를 모두 삭제
        del_node.next = null;
        del_node.data = null;

        // 8. 요소가 삭제 되었으니 크기 감소
        size--;

        // 9. 이전 노드가 다음 노드를 가리키도록 업데이트
        prev_node.next = next_node;

        // 10. 마지막으로 삭제된 요소를 반환
        return returnValue;
    }

    // 첫 요소 삭제
    public E removeFirst() {

        // 1. 만약 삭제할 요소가 아무것도 없으면 에러
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }

        // 2. 삭제될 첫번째 요소의 데이터를 백업
        E returnValue = head.data;

        // 3. 두번째 노드를 임시 저장
        Node<E> first = head.next;

        // 4. 첫번째 노드의 내부 요소를 모두 삭제
        head.next = null;
        head.data = null;

        // 5. head가 다음 노드를 가리키도록 업데이트
        head = first;

        // 6. 요소가 삭제 되었으니 크기 감소
        size--;

        // 7. 만일 리스트의 유일한 값을 삭제해서 빈 리스트가 될 경우, tail도 null 처리
        if (head == null) {
            tail = null;
        }

        // 8. 마지막으로 삭제된 요소를 반환
        return returnValue;
    }

    public E remove() {
        return removeFirst();
    }




    // 중간 삽입
    public void add(int index, E value) {

        // 1. 인덱스가 0보다 작거나 size 보다 같거나 클 경우 에러
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        // 2. 추가하려는 index가 0이면 addFirst 호출
        if (index == 0) {
            addFirst(value);
            return;
        }

        // 3. 추가하려는 index가 size - 1와 같으면 addLast 호출
        if (index == size - 1) {
            addLast(value);
            return;
        }

        // 4. 추가하려는 위치의 이전 노드 얻기
        Node<E> prev_node = search(index - 1);

        // 5. 추가하려는 위치의 다음 노드 얻기
        Node<E> next_node = prev_node.next;

        // 6. 새 노드 생성 (바로 다음 노드와 연결)
        Node<E> newNode = new Node<>(value, next_node);

        // 7. size 증가
        size++;

        // 8. 이전 노드를 새 노드와 연결
        prev_node.next = newNode;
    }

    public boolean add(E data) {
        addLast(data);
        return true;
    }

    // 요소를 마지막에 추가
    public void addLast(E data) {

        // 1. 먼저 가장 뒤의 요소를 가져옴
        Node<E> last = tail;

        // 2. 새 노드 생성 (맨 마지막 요소 추가니까 next 는 null이다)
        Node<E> newNode = new Node<>(data, null);

        // 3. 요소가 추가되었으니 size를 늘린다
        size++;

        // 4. 맨뒤에 요소가 추가되었으니 tail를 업데이트한다
        tail = newNode;

        if (last == null) {
            // 5. 만일 최초로 요소가 add 된 것이면 head와 tail이 가리키는 요소는 같게 된다.
            head = newNode;
        } else {
            // 6. 최초 추가가 아니라면 last 변수(추가 되기 전 마지막이었던 요소)에서 추가된 새 노드를 가리키도록 업데이트
            last.next = newNode;
        }
    }

    // 요소를 처음에 추가
    void addFirst(E data){

        // 1. 가장 앞의 요소를 가져옴
        Node<E> first = head;

        // 2. 새 노드 생성 ( 이전의 가장 앞 요소를 next 로 지정 )
        Node<E> newNode = new Node<>(data, first);

        // 3. 요소가 추가되었기 때문에 size 를 늘린다
        size++;

        // 4. 맨 앞에 요소가 추가되었으니 head 를 업데이트
        head = newNode;

        // 5. 만일 최초로 요소가 add 된 것이라면 head 와 tail 이 카리키는 요소를 같게 설정
        if(first == null){
            tail = newNode;
        }

    }

    // Node 찾는 메소드
    private Node<E> search(int index){

        Node<E> n = head;
        for(int i = 0; i < index; i++){
            n = n.next;
        }

        return n;
    }

    @Override
    public Iterator<E> iterator() {
        return new CustomIterator(head);
    }

    // CustomIterator 클래스는 Iterator 인터페이스를 구현합니다.
    private class CustomIterator implements Iterator<E> {
        Node current;

        public CustomIterator(Node head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = (E)current.data;
            current = current.next;
            return data;
        }
    }

    private static class Node<E>{
        private E data;
        private Node<E> next;

        Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }

    }
}
