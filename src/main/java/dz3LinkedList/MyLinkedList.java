package dz3LinkedList;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by dmitriy on 8/12/15.
 */
public class MyLinkedList<E> implements List<E> {
    private Element<E> first;
    private Element<E> last;
    private int size = 0;

    public MyLinkedList() {
    }

    @Override
    public boolean add(E e) {

        if (size == 0) {
            setFirst(new Element<E>(null, e, null));

        } else if (size == 1) {
            setLast(new Element<E>(getFirst(), e, null));
            getFirst().setNext(getLast());

        } else {
            Element<E> tmp = new Element<E>(getLast(), e, null);
            getLast().setNext(tmp);
            setLast(tmp);
        }
        this.size++;
        return true;
    }

    @Override
    public void add(int index, E e) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("there is no such index");
        }

        Element<E> tmp;
        Element<E> current;

        if (size == 1) {
            tmp = getFirst();
            setLast(tmp);
        } else {
            tmp = findElementByIndex(index);
        }

        current = new Element<E>(tmp.getPrev(), e, tmp);

        if (tmp.getPrev() != null) {
            tmp.getPrev().setNext(current);
        } else {
            first = current;
        }

        tmp.setPrev(current);
        size++;
    }

    @Override
    public void clear() {
        setFirst(null);
        setLast(null);
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        Element tmp = getFirst();
        for (int i = 0; i < size; i++) {
            if (tmp.getValue().equals(o)) {
                return true;
            }
            tmp = tmp.getNext();
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("there is no such index");
        }
        return findElementByIndex(index).getValue();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("there is no such index");
        }

        Element<E> tmp = findElementByIndex(index);

        if (tmp.getPrev() != null) {
            tmp.getPrev().setNext(tmp.getNext());
        } else {
            first = tmp.getNext();
        }

        if (tmp.getNext() != null) {
            tmp.getNext().setPrev(tmp.getPrev());
        } else {
            last = tmp.getPrev();
        }

        size--;
        return tmp.getValue();
    }

    @Override
    public boolean remove(Object o) {
        Element tmp = getFirst();

        for (int i = 0; i < size; i++) {

            if (tmp.getValue().equals(o)) {
                remove(i);
                return true;
            }
            tmp = tmp.getNext();
        }
        return false;
    }

    @Override
    public E set(int index, E element) {
        Element<E> tmp = findElementByIndex(index);
        E e = tmp.getValue();
        tmp.setValue(element);
        return e;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("MyLinkedList{ size= " + size);

        Element<E> tmp = first;
        for (int i = 0; i < size; i++) {
            builder.append(", ");
            builder.append(tmp.getValue());
            tmp = tmp.getNext();
        }
        builder.append(" }");
        return builder.toString();
    }


    private Element<E> findElementByIndex(int index) {
        Element<E> tmp = getFirst();

        for (int i = 0; i < index; i++) {
            tmp = tmp.getNext();
        }
        return tmp;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    protected class Element<E> {
        private E value;
        private Element prev;
        private Element next;

        Element(Element prev, E value, Element next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Element getPrev() {
            return prev;
        }

        public void setPrev(Element prev) {
            this.prev = prev;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }

    public Element<E> getFirst() {
        return first;
    }

    public void setFirst(Element<E> first) {
        this.first = first;
    }

    public Element<E> getLast() {
        return last == null ? first : last;
    }

    public void setLast(Element<E> last) {
        this.last = last;
    }
}


