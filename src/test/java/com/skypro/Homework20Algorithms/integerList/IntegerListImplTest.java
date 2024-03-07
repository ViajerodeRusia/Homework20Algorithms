package com.skypro.Homework20Algorithms.integerList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {
    private final IntegerListImpl list = new IntegerListImpl();

    @Test
    void add() {
        list.add(5);
        assertEquals(1, list.size()); // Ожидаем, что размер списка станет равным 1 после добавления элемента
    }

    @Test
    void testAdd() {
        list.add(0, 5);
        assertEquals(1, list.size()); // Ожидаем, что размер списка станет равным 1 после добавления элемента по индексу
        assertEquals(5, list.get(0)); // Ожидаем, что добавленный элемент будет находиться по указанному индексу
    }
    
    @Test
    void set() {
        list.add(5);
        list.set(0, 10);
        assertEquals(10, list.get(0)); // Ожидаем, что элемент в списке будет изменен на новое значение
    }

    @Test
    void remove() {
        list.add(5);
        assertEquals(5, (int) list.remove(0)); // Ожидаем, что удаленный элемент будет возвращен методом remove
        assertTrue(list.isEmpty()); // Ожидаем, что список станет пустым после удаления элемента
    }

    @Test
    void testRemove() {
        list.add(5);
        assertEquals(Integer.valueOf(5), list.remove(Integer.valueOf(5))); // Проверяем, что удаленный элемент равен ожидаемому значению
        assertTrue(list.isEmpty()); // Ожидаем, что список станет пустым после удаления элемента
    }


    @Test
    void contains() {
        list.add(5);
        assertTrue(list.contains(5)); // Ожидаем, что список содержит добавленный элемент
    }

    @Test
    void indexOf() {
        list.add(5);
        assertEquals(0, list.indexOf(5)); // Ожидаем, что индекс элемента равен 0
    }

    @Test
    void lastIndexOf() {
        list.add(5);
        list.add(5);
        assertEquals(1, list.lastIndexOf(5)); // Ожидаем, что индекс последнего вхождения элемента равен 1
    }

    @Test
    void get() {
        list.add(5);
        assertEquals(5, list.get(0)); // Ожидаем, что полученное значение по индексу будет равно добавленному элементу

    }

    @Test
    void sort() {
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(1);
        list.add(4);

        list.sort(list.toArray(), 0, list.size() - 1);

        Integer[] sortedArray = list.toArray();
        Integer[] expectedArray = {1, 3, 4, 5, 8};

        assertArrayEquals(expectedArray, sortedArray);
    }
}