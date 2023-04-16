public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail; // O(1) for adding...
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data){
            this.data= data;
            this.next= null;
        }
    }

    private Node<T> getNode(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    public MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override 
    public int size(){
        return size;
    }

    @Override
    public boolean contains(Object o){
        return indexOf(o) != -1;
    }

    @Override
    public void add(T item){
        add(item, size);
    }

    @Override
    public void add(T item, int index) {
         if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> newNode = new Node<>(item);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = getNode(index - 1);
            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }

    @Override
    public boolean remove(T item){
        if (head == null) {
            return false;
        }

        if (item.equals(head.data)) {
            head = head.next;
            size--;
            return true;
        }

        Node<T> current = head;
        while (current.next != null && !item.equals(current.next.data)) {
            current = current.next;
        }

        if (current.next == null) {
            return false;
        }

        current.next = current.next.next;
        size--;
        return true;
    }

    @Override
    public T remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = head;
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> previous = getNode(index - 1);
            current = previous.next;
            previous.next = current.next;
        }

        size--;
        return current.data;
    }
    
    @Override
    public void clear(){
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public T get(int index){

    }

    @Override
    public int indexOf(Object o){

    }

    @Override
    public int lastIndexOf(Object o){

    }

    @Override
    public void sort(){ 
    if (size <= 1) {
        return; // The list is already sorted
    }
    
    boolean swapped = true;
    Node<T> current;
    Node<T> previous = null;
    
    while (swapped) {
        swapped = false;
        current = head;
        
        while (current.next != previous) {
            if (((Comparable<T>) current.data).compareTo(current.next.data) > 0) {
                // Swap the elements
                T temp = current.data;
                current.data = current.next.data;
                current.next.data = temp;
                swapped = true;
            }
            
            current = current.next;
        }
        
        previous = current;
    }
}
}