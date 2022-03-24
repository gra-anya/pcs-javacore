package ru.netology.javacore;

import com.google.gson.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {
    private int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            while (true) {
                String taskJson = in.readLine();
                JsonElement rootNode = JsonParser.parseString(taskJson);
                JsonObject details = rootNode.getAsJsonObject();

                String type = details.get("type").getAsString();
                String task = details.get("task").getAsString();

                switch (type) {
                    case "ADD":
                        todos.addTask(task);
                        break;
                    case ("REMOVE"):
                        todos.removeTask(task);
                        break;
                }
                out.println(todos.getAllTasks());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
