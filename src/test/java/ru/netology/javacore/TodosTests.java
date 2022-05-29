package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class TodosTests {
    @Test
    public void addTaskTest() {
        String task1 = "Купить молоко.";
        String task2 = "Помыть полы";

        Todos todos = new Todos();
        todos.addTask(task1);
        todos.addTask(task2);
        List<String> result = todos.getTasks();
        List<String> expected = Arrays.asList(task1, task2);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void removeTaskTest(){
        String task1 = "Купить молоко.";
        String task2 = "Помыть полы";

        Todos todos = new Todos();
        todos.addTask(task1);
        todos.addTask(task2);
        todos.removeTask(task2);
        List<String> result = todos.getTasks();
        List<String> expected = Arrays.asList(task1);
        Assertions.assertEquals(expected, result);
    }


    // ваши тесты для класса Todos
}
