import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayListImpl<T> {
    Object[] elementData;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private int size = 0;

    //это конструктор
    public ArrayListImpl(int initCapacity) {
        if (initCapacity > 0) {
            elementData = new Object[initCapacity];
        } else if (initCapacity == 0) {
            elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initCapacity);
        }
    }

    //пустой конструктор
    public ArrayListImpl() {
        elementData = new Object[DEFAULT_CAPACITY];
    }
    public void add(T element) {
        if (elementData.length == size) {
            elementData = grow();
        }
        elementData[size] = element;
        size++;
    }
    public void add(int index, T element) {
        rangeCheck(index);
        if (elementData.length == size) {
            elementData = grow();
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }
    private void rangeCheck(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Index out of bounds, provide correct one");
        }
    }
    public T get(int index) {
        rangeCheck(index);
        return (T) elementData[index];
    }
    public int size(){
        return size;
    }
    private Object[] grow() {
        int newElementDataLength = elementData.length * 2;
        Object[] newElementData = new Object[newElementDataLength];
        System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
        return newElementData;
    }
         public T getFirst() {
        if(isEmpty()==true){
            throw new NoSuchElementException();
        }
            return (T) elementData[0];
    }
    public T getLast() {
        if(isEmpty()==true){
            throw new NoSuchElementException();
        }
         return (T) elementData[size-1];
    }
    public void set(int index, T element) {
        rangeCheck(index);
        if (elementData.length == size) {
            elementData = grow();
        }
        System.arraycopy(elementData, index, elementData, index, size);
        elementData[index] = element;
    }
    public T remove(int index) {
        rangeCheck(index);
        Object oldElement = elementData[index];
        int newSize = size-1;
        if (newSize > index){
            System.arraycopy(elementData, index+1, elementData, index, newSize);
        }
        elementData[size=newSize] = null;
        return (T) oldElement;
    }
    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }
    public int indexOf(Object o) {
          int start =0;
          Object[] es = elementData;
            if (o == null) {
              for (int i = start; i < es.length; i++) {
                if (es[i] == null) {
                    return i;
                }
              }
            } else {
              for (int i = start; i < es.length; i++) {
                if (o.equals(es[i])) {
                    return i;
                }
              }
        }
        return -1;
      }
      public boolean isEmpty () {
            if (elementData.length == 0) {
                return true;
            }
            return false;
        }
    public void clear() {
        //не понимаю как работает этот цикл
//        Object[] clear = elementData;
//          for (int to = size, i = size = 0; i < to; i++)
//            clear[i] = null;
        elementData = EMPTY_ELEMENTDATA;
        size=0;
    }
}
