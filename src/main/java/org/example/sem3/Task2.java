package org.example.sem3;


import java.util.Arrays;
import java.util.NoSuchElementException;

public class Task2<E> {
    private Object[] items;
    int itemsSize;

    public Task2() {
        items = new Object[1];
        itemsSize = 0;
    }


    public void add(E item) {
        if (itemsSize == items.length) {
            Object[] newArray = new Object[items.length * 2];
            System.arraycopy(items, 0, newArray, 0, items.length);
            items = newArray;
        }
        items[itemsSize++] = item;
    }

    public E remove(int index) {
        if (index > itemsSize || index <= 0) {
            throw new NoSuchElementException();
        }
        E element = (E) items[index];
        items[index] = null;

        Object[] newArray1 = Arrays.copyOfRange(items, index + 1, items.length - 1);
        System.arraycopy(newArray1, 0, items, index, newArray1.length);
        itemsSize--;
        return element;
    }

    public int getItemsSize() {
        return itemsSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < itemsSize-1; i++) {
            sb.append(items[i] + " ,");
        }
        sb.append(items[itemsSize-1]);
        sb.append("]");
        return sb.toString();
    }


    public BogdanIterator getIterator() {
        return new BogdanIterator();
    }


    public class BogdanIterator {
        private int cursor = 0;

        public boolean hasNext() {
            if (cursor < itemsSize) {
                return true;
            } else {
                return false;
            }
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                return (E) items[cursor++];
            }
        }
    }
}
