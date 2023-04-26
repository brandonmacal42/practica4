package edd.estructuras.lineales;

import java.util.Iterator;

public class ArrayQueue<E> implements Queue {
    private final short MAXIMO = 1000;
    private Object[] queue;
    private int head;
    private int tail;
    private int size;

    public ArrayQueue() {
        queue = new Object[MAXIMO];
        head = 0;
        tail = MAXIMO - 1;
        size = 0;

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E first() {
        return isEmpty() ? null : (E) queue[head];
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E tmp = (E) queue[head];
        queue[head] = null;
        head = (head + 1) % MAXIMO;
        size--;
        return tmp;
    }

    @Override
    public void enqueue(Object e) {
        if (size == MAXIMO) {
            throw new RuntimeException("Cola llena");
        }
        tail = (tail + 1) % size;
        queue[tail] = e;
        size++;
    }

    @Override
    public Iterator iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<E> {
        private int i = 0;

        public boolean hasNext() {
            return i < size;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public E next() {
            if (!hasNext()) {
                throw new RuntimeException("Queue iterator out of bounds");
            }
            E item = (E) queue[(head + i) % queue.length];
            i++;
            return item;
        }
    }
}