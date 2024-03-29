import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {
    private int size;
    private Object[] elements;
    
    public MyArrayList(){
        elements= new Object[10];
        size=0;
    }
    
    @Override 
    public int size(){
        return size;
    }

    @Override
    public boolean contains(Object o){
        for (int i=0; i<size; i++){
            if (elements[i].equals(o)){
                return true;
            }
        }   return false;
    }

    @Override
    public void add(T item) {
    if (size == elements.length) {
        Object[] newElements = new Object[elements.length * 2];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
    elements[size++] = item;
}

    @Override
  public void add(T item, int index) {
    if (index < 0 || index > size) {
        throw new IndexOutOfBoundsException();
    }
    if (size == elements.length) {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, index);
        newElements[index] = item;
        System.arraycopy(elements, index, newElements, index + 1, size - index);
        elements = newElements;
    } else {
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
    }
    size++;
}

    @Override
    public boolean remove(T item) {
    for (int i = 0; i < size; i++) {
        if (elements[i].equals(item)) {
            for (int j = i + 1; j < size; j++) {
                elements[j - 1] = elements[j];
            }
            elements[size - 1] = null;
            size--;
            return true;
        }
    }
    return false;
}

    @Override
    public T remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removedItem = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        elements[size] = null;
        return removedItem;
    }
    
    @Override
    public void clear(){
        elements = new Object[10];
        size = 0;
    }

    @Override
    public T get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    @Override
    public int indexOf(Object o){
         for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o){
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort(){
        Arrays.sort((T[]) elements, 0, size);
    }
}
