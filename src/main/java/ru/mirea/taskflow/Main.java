package ru.mirea.taskflow;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.mirea.taskflow.model.Task;

public class Main {
    public static void main(String[] args) {
        Task task = new Task.Builder("Разработка тайм-трекера на Java")
                .priority("HIGH")
                .author("Карабаджак Д.Е.")
                .workedMinutes(90)
                .build();
        task.finish();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println("Отчёт по учёту рабочего времени (JSON):");
        System.out.println(gson.toJson(task));
    }
}
