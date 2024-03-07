package com.skypro.Homework20Algorithms.integerList;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private static final int INITIAL_CAPACITY = 10;
    private Integer[] integerArray;
    private int size;

    public IntegerListImpl() {
        integerArray = new Integer[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public void add(Integer item) {
        if (size == integerArray.length) {
            expandCapacity();
        }
        if (item == null) {
            throw new IllegalArgumentException();
        }
        integerArray[size] = item;
        size++;
    }

    @Override
    public void add(int index, Integer item) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == integerArray.length) {
            expandCapacity();
        }
        if (item == null) {
            throw new IllegalArgumentException();
        }
        System.arraycopy(integerArray, index, integerArray, index + 1, size - index);
        integerArray[index] = item;
        size++;
    }

    @Override
    public void set(int index, Integer item) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Requested index is out of bounds");
        }
        if (item == null) {
            throw new IllegalArgumentException();
        }
        integerArray[index] = item;
    }

    @Override
    public Integer remove(Integer item) {
        for (int i = 0; i < size; i++) {
            if (integerArray[i].equals(item)) {
                return remove(i);
            }
        }
        throw new IllegalArgumentException("Requested element is not found");
    }

    @Override
    public Integer remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Requested index is out of bounds");
        }
        Integer removed = integerArray[index];
        System.arraycopy(integerArray, index + 1, integerArray, index, size - index - 1);
        integerArray[--size] = null;
        return removed;
    }

    @Override
    public boolean contains(Integer item) {
        for (int i = 0; i < size; i++) {
            if (integerArray[i].equals(item)) return true;
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (integerArray[i].equals(item)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Requested element is not found");
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (integerArray[i].equals(item)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Requested element is not found");
    }

    @Override
    public Integer get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Requested index is out of bounds");
        }
        return integerArray[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("Other list cannot be null");
        }
        if (this == otherList) {
            return true;
        }
        if (otherList.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!integerArray[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(integerArray, null);
        size = 0;
    }

    @Override
    public void sort(Integer[] arr, int low, int high) {
        if (low < high) {
            Integer pi = partition(integerArray, low, high);
            sort(integerArray, low, pi - 1);
            sort(integerArray, pi + 1, high);
        }
    }
    private static int partition(Integer[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    @Override
    public Integer[] toArray() {
        Integer[] newArray = new Integer[size];
        System.arraycopy(integerArray, 0, newArray, 0, size);
        return newArray;
    }

    public void expandCapacity() {
        int newCapacity = integerArray.length * 2;
        integerArray = Arrays.copyOf(integerArray, newCapacity);
    }
}
