public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private int size;
    private Node<T> head;
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data){
            this.data= data;
            this.next= null;
        }
    }

    @Override 
    public int size(){
        return size;
    }

    @Override
    public boolean contains(Object o){

    }

    @Override
    public void add(T item){

    }

    @Override
    public void add(T item, int index) {

    }

    @Override
    public boolean remove(T item){

    }

    @Override
    public T remove(int index){

    }
    
    @Override
    public void clear(){
        size = 0;
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