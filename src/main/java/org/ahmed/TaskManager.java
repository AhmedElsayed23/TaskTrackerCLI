package org.ahmed;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.google.gson.*;

public class TaskManager {
    private static final String FILE_NAME = "tasks.json";
    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .setDateFormat("MMM dd, yyyy, h:mm:ss a")
            .create();
    private static List<Task> tasks = new ArrayList<>();

    // Load tasks from file
    static {
        loadTasks();
    }

    // Load tasks from the JSON file (if it exists)
    private static void loadTasks() {
        File file = new File(FILE_NAME); // Check if the file exists before reading from it to avoid FileNotFoundException

        if (!file.exists()) {
            // create the file if it doesn't exist
            try {
                if (!file.createNewFile()) {
                    System.err.println("File already exists or could not be created.");
                }
            } catch (IOException e) {
                System.err.println("Error creating file: " + e.getMessage());
            }
        }

        try (Reader reader = new FileReader(FILE_NAME)) {
            Task[] loadedTasks = gson.fromJson(reader, Task[].class);
            if (loadedTasks != null) {
                tasks = new ArrayList<>(Arrays.asList(loadedTasks));
            }
        } catch (IOException e) {
            System.err.println("Error loading tasks from file: " + e.getMessage());
        }
    }

    // Save tasks to the JSON file
    private static void setTasks() {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(tasks, writer);
        } catch (IOException e) {
            System.err.println("Error saving tasks to file: " + e.getMessage());
        }
    }

    // Add a new task
    public static void addTask(String description) {
        int newId = tasks.isEmpty() ? 1 : tasks.getLast().getId() + 1;
        Task newTask = new Task(newId, description);
        tasks.add(newTask);
        setTasks();
        System.out.println("Task added: " + newTask);
    }

    // List all tasks or by filter
    public static void listTasks(String status) {
        if (status == null) {
            tasks.forEach(System.out::println);
            return;
        }

        tasks.stream()
                .filter(task -> task.getStatus().equals(status))
                .forEach(System.out::println);
    }

    // Update a task by id and new description
    public static void updateTask(int id, String newDescription) {
        Task task = tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);

        if (task == null) {
            System.out.println("Task not found with id: " + id);
            return;
        }

        task.setDescription(newDescription);
        setTasks();
        System.out.println("Task updated: " + task);
    }

    // Mark a task as in-progress or done by id
    public static void markTask(int id, String status) {
        Task task = tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);

        if (task == null) {
            System.out.println("Task not found with id: " + id);
            return;
        }

        task.setStatus(status);
        setTasks();
        System.out.println("Task marked as " + status + ": " + task);
    }
}
