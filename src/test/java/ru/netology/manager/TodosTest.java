package ru.netology.manager;

import domain.Epic;
import domain.Meeting;
import domain.SimpleTask;
import domain.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSeveralTask() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(5, "Позвонить родителям"));
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        todos.add(new Epic(55, subtasks));
        todos.add(new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        ));

        Task[] expected = {new SimpleTask(5, "Позвонить родителям"), new Epic(55, subtasks),
                new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда")};
        Task[] actual = todos.search("");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneTask() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(5, "Позвонить родителям"));
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        todos.add(new Epic(55, subtasks));
        todos.add(new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        ));

        Task[] expected = {new Epic(55, subtasks)};
        Task[] actual = todos.search("Хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchTask() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(5, "Позвонить родителям"));
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        todos.add(new Epic(55, subtasks));
        todos.add(new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        ));

        Task[] expected = {};
        Task[] actual = todos.search("Вчера");

        Assertions.assertArrayEquals(expected, actual);
    }
}
