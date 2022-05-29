package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {

    private List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        Collections.sort(tasks);
        StringBuilder builder = new StringBuilder();
        for (String task : tasks) {
            builder.append(task).append(" ");
        }
        return builder.toString();
    }

    public List<String> getTasks() {
        return tasks;
    }
}
