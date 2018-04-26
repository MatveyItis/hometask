package ru.kpfu.itis.maletskov.hometask.aisd;

import java.util.AbstractList;

/**
 * Created by Maletskov on 26.02.2018.
 */
public class LinkedList<T> extends AbstractList<T> {
    private Entry<T> head;
    private Entry<T> el;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public boolean addLast(T t) {
        if (size == 0) {
            el = new Entry<>(t, null);
            head = el;
        } else {
            el = head;
            while(el.getNext() != null) {
                el = el.getNext();
            }
            el.setNext(new Entry<>(t, null));
        }
        size++;
        return true;
    }

    public boolean addFirst(T t) {
        if (size != 0) {
            head.setNext(new Entry<>(t, head.getNext()));
            size++;
        } else {
            el = new Entry<>(t, null);
            head = el;
        }
        return true;
    }

    public T getLastElem() {
        el = head;
        while (el.getNext() != null) {
            el = el.getNext();
        }
        return el.getElem();
    }

    @Override
    public boolean remove(Object o) {
        Entry<T> t1;
        t1 = head;
        for (int i = 0; i < size; i++) {
            if (o.equals(t1.getElem())) {

            }
            t1 = t1.getNext();
        }
        return false;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            el = head;
            for (int i = 0; i < index; i++) {
                el = el.getNext();
            }
            return el.getElem();
        }
    }

    @Override
    public int size() {
        return size;
    }

    private class Entry<T> {
        private T elem;
        private Entry<T> next;

        public Entry(T elem, Entry<T> next) {
            this.elem = elem;
            this.next = next;
        }

        public T getElem() {
            return this.elem;
        }

        public Entry<T> getNext() {
            return next;
        }

        public void setNext(Entry<T> next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Entry<?> entry = (Entry<?>) o;

            if (elem != null ? !elem.equals(entry.elem) : entry.elem != null) return false;
            return next != null ? next.equals(entry.next) : entry.next == null;
        }

        @Override
        public int hashCode() {
            int result = elem != null ? elem.hashCode() : 0;
            result = 31 * result + (next != null ? next.hashCode() : 0);
            return result;
        }
    }

    //equals переписать
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        LinkedList<?> that = (LinkedList<?>) o;

        if (size != that.size)  return false;
        if (size == that.size) {
            Entry<T> entry1 = this.head;
            Entry<T> entry2 = (Entry<T>) (that.head);
            for (int i = 0; i < size; i++) {
                if (!entry1.equals(entry2)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (head != null ? head.hashCode() : 0);
        result = 31 * result + (el != null ? el.hashCode() : 0);
        result = 31 * result + size;
        return result;
    }
}
