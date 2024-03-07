package com.skypro.Homework20Algorithms.stringList;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    private final StringList stringList = new StringListImpl();
    String testWord = "world";
    String testWordUpper = "World";


    @Test
    void add() {
        stringList.add(testWord);
        Assertions.assertThat(stringList.size()).isGreaterThan(0);
    }

    @Test
    void testAdd() {
        stringList.add(testWord);
        stringList.add(0,testWordUpper);
        Assertions.assertThat(stringList.size()).isGreaterThan(1);
        Assertions.assertThat(stringList.get(0)).isEqualTo(testWordUpper);
    }

    @Test
    void set() {
        stringList.add(testWord);
        stringList.set(0, testWordUpper);
        Assertions.assertThat(stringList.get(0)).isEqualTo(testWordUpper);
    }

    @Test
    void remove() {
        stringList.add(testWord);
        Assertions.assertThat(stringList).isNotNull();
        stringList.remove(testWord);
        Assertions.assertThat(stringList.get(0)).isNull();
    }

    @Test
    void testRemove() {
        stringList.add(testWord);
        Assertions.assertThat(stringList).isNotNull();
        stringList.remove(0);
        Assertions.assertThat(stringList.get(0)).isNull();
    }

    @Test
    void contains() {
        stringList.add(testWord);
        Boolean result = stringList.contains(testWord);
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void indexOf() {
        stringList.add(testWord);
        stringList.add(testWordUpper);
        Integer result = stringList.indexOf(testWord);
        Integer result2=stringList.indexOf(testWordUpper);
        Assertions.assertThat(result).isEqualTo(0);
        Assertions.assertThat(result2).isEqualTo(1);
    }

    @Test
    void lastIndexOf() {
        stringList.add(testWord);
        stringList.add(testWord);
        stringList.add(testWord);
        Integer result = stringList.lastIndexOf(testWord);
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    void get() {
        StringListImpl stringList = new StringListImpl();
        stringList.add("test");
        assertEquals("test", stringList.get(0)); // Ожидаем, что метод get вернет элемент "test" с индексом 0
    }

    @Test
    void testEquals() {
        StringListImpl stringList1 = new StringListImpl();
        stringList1.add("test1");
        StringListImpl stringList2 = new StringListImpl();
        stringList2.add("test1");
        assertTrue(stringList1.equals(stringList2)); // Ожидаем, что два одинаковых списка будут равными
    }

    @Test
    void size() {
        StringListImpl stringList = new StringListImpl();
        assertEquals(0, stringList.size()); // Ожидаем, что размер списка при создании будет равен 0
    }

    @Test
    void isEmpty() {
        StringListImpl stringList = new StringListImpl();
        assertTrue(stringList.isEmpty()); // Ожидаем, что список будет пустым после создания
    }

    @Test
    void clear() {
        StringListImpl stringList = new StringListImpl();
        stringList.add("test");
        stringList.clear();
        assertEquals(0, stringList.size()); // Ожидаем, что после вызова метода clear список будет пустым
    }

    @Test
    void toArray() {
        StringListImpl stringList = new StringListImpl();
        stringList.add("test1");
        stringList.add("test2");
        String[] array = stringList.toArray();
        assertEquals(2, array.length); // Ожидаем, что массив, полученный из списка, будет иметь размер 2
        assertEquals("test1", array[0]); // Ожидаем, что первый элемент массива будет "test1"
        assertEquals("test2", array[1]); // Ожидаем, что второй элемент массива будет "test2"
    }

    @Test
    void expandCapacity() {
        StringListImpl stringList = new StringListImpl();
        for (int i = 0; i < 15; i++) {
            stringList.add("test" + i);
        }
        assertEquals(15, stringList.size()); // Ожидаем, что размер списка станет равным 15 после добавления 15 элементов
    }
}