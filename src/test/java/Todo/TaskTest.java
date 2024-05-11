package Todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void simpleTaskMatchesTest() {
        SimpleTask task = new SimpleTask(1, "Позвонить домой");

        boolean actual = task.matches("Позвонить");

        Assertions.assertTrue(actual);
    }

    @Test
    public void simpleTaskNotMatchesTest() {
        SimpleTask task = new SimpleTask(1, "Позвонить домой");

        boolean actual = task.matches("Написать");

        Assertions.assertFalse(actual);
    }

    @Test
    public void epicMatchesTest() {
        Epic epic  = new Epic(1, new String[]{"Позвонить домой", "Написать домой"});

        boolean actual = epic.matches("Позвонить домой");

        Assertions.assertTrue(actual);
    }

    @Test
    public void epicNotMatchesTest() {
        Epic epic  = new Epic(1, new String[]{"Позвонить домой", "Написать домой"});

        boolean actual = epic.matches("Прийти домой");

        Assertions.assertFalse(actual);
    }

    @Test
    public void meetingTopicMatchesTest() {
        Meeting meeting  = new Meeting(1, "Встреча друзей", "Друзья", "Сегодня");

        boolean actual = meeting.matches("Встреча друзей");

        Assertions.assertTrue(actual);
    }

    @Test
    public void meetingProjectMatchesTest() {
        Meeting meeting  = new Meeting(1, "Встреча друзей", "Друзья", "Сегодня");

        boolean actual = meeting.matches("Друзья");

        Assertions.assertTrue(actual);
    }

    @Test
    public void meetingNotMatchesTest() {
        Meeting meeting  = new Meeting(1, "Встреча друзей", "Друзья", "Сегодня");

        boolean actual = meeting.matches("Выпускной");

        Assertions.assertFalse(actual);
    }
}