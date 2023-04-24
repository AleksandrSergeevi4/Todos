package ru.netology.manager;

import domain.SimpleTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EqualsMethodTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    @Test
    public void shouldEqualsObjectTrue() {

        Assertions.assertEquals(simpleTask, simpleTask);
    }

    @Test
    public void shouldEqualsObjectFalse() {
        SimpleTask simpleTask2 = new SimpleTask(7, "Позвонить брату");

        Assertions.assertNotEquals(simpleTask, simpleTask2);
    }

    @Test
    public void shouldEqualsObjectNullFalse() {

        Assertions.assertFalse(simpleTask.equals(null));
    }

    @Test
    public void shouldEqualsObjectGetClassFalse() {

        Assertions.assertFalse(simpleTask.equals(getClass()));
    }

    @Test
    public void shouldEqualsObjectClassTrue() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");

        Assertions.assertTrue(simpleTask.equals(simpleTask1));
    }
}
