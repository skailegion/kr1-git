package ru.mirea.taskflow;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.mirea.taskflow.model.Task;

public class Main {
    public static void main(String[] args) {
        Task task = new Task.Builder("Сдать КР по архитектуре ПО")
                .priority("HIGH")
                .author("Карабаджак Д.Е.")
                .build();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println("Создана задача в формате JSON:");
        System.out.println(gson.toJson(task));
    }
}
