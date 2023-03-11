import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedListImpl<E> {

    Node<E> first;
    Node<E> last;
    int size;

    class Node<E> {
        Node<E> prev;
        E element;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    '}';
        }
    }

    public LinkedListImpl() {
    }

    public E getFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.element;
    }

    public E getLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.element;
    }

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        if (first == null)
            return true;
        return false;
    }


    public boolean add(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        return true;
    }

    public boolean remove(Object o) {
        for (Node<E> node = first; first.next != null; node = node.next) {
            if (o.equals(node.element)) {
                unlink(node);
                return true;
            }
        }
        return false;
    }

    private E unlink(Node<E> x) {
        E element = x.element;
        Node<E> prev = x.prev;
        Node<E> next = x.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.element = null;
        size--;
        return element;
    }

    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    public int indexOf(Object o) {
        int index = 0;
        for (Node<E> x = first; x != null; x = x.next) {
            if (o.equals(x.element))
                return index;
            index++;
        }
        return -1;
    }

    //пока не делать
    public Iterator iterator() {

        return null;
    }

    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.element = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).element;
    }

    Node<E> node(int index) {
        if (index < (size / 2)) {
            Node<E> f = first;
            for (int i = 0; i < index; i++)
                f = f.next;
            return f;
        } else {
            Node<E> f = last;
            for (int i = size - 1; i > index; i--)
                f = f.prev;
            return f;
        }
    }

    public E set(int index, E element) {
        checkElementIndex(index);

        Node<E> node = node(index);
        E prevElement = node.element;
        node.element = element;
        return prevElement;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index is out of bound " + index);
    }

    //не доделала
//    public void add(int index, Object element) {
//        checkElementIndex(index);
//        if (index==size)
//            add((E) element);
//    }
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }
}
