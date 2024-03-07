package com.skypro.Homework20Algorithms.integerList;

public interface IntegerList {
    void add(Integer item);

    void add(int index, Integer item);

    void set(int index, Integer item);

    Integer remove(Integer item);

    Integer remove(int index);

    boolean contains(Integer item);

    int indexOf(Integer item);

    int lastIndexOf(Integer item);

    Integer get(int index);

    boolean equals(IntegerList otherList);

    int size();

    boolean isEmpty();

    void clear();

    void sort(Integer[] arr, int low, int high);

    Integer[] toArray();
}
