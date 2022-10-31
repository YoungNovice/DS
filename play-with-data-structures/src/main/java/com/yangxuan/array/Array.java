package com.yangxuan.array;

import java.util.Arrays;

public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.data.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addLast(E e) {
        this.add(size, e);
    }

    public void addFirst(E e) {
        this.add(0, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index out of range");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        /*
        原始循环方式
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }*/

        if (size > index) {
            System.arraycopy(data, index, data, index + 1, size - index);
        }
        data[index] = e;
        size++;
    }

    private void resize(int capacity) {
        System.out.printf("resize size = %d oldCapacity = %d newCapacity = %d\n", size, data.length, capacity);
        E[] newData = (E[]) new Object[capacity];
        System.arraycopy(data, 0, newData, 0, size);
        this.data = newData;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index out of range");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index out of range");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = this.find(e);
        if (index != -1) {
            this.remove(index);
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index out of range");
        }
        E val = data[index];
        if (size > index + 1) {
            System.arraycopy(data, index + 1, data, index, size - (index + 1));
        }
        size--;
        data[size] = null;

        if (size == data.length / 2 && size >= 10) {
            resize(size);
        }
        return val;
    }

    public String toString() {
        return String.format("Array: size = %d, capacity = %d\t%s",
                size, data.length, Arrays.toString(Arrays.copyOf(data, size)));
    }

}
