import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    public void testAddTask() {
        TaskList taskList = new TaskList();
        taskList.addTask("Task 1");
        assertFalse(taskList.isEmpty());
    }

    @Test
    public void testRemoveTask() {
        TaskList taskList = new TaskList();
        taskList.addTask("Task 1");
        taskList.removeTask(1);
        assertTrue(taskList.isEmpty());
    }

    @Test
    public void testListTasks() {
        TaskList taskList = new TaskList();
        taskList.addTask("Task 1");
        taskList.addTask("Task 2");
        taskList.addTask("Task 3");
        assertEquals(3, taskList.getArrayList().size());
    }

    @Test
    public void testIsValidTaskNumber() {
        TaskList taskList = new TaskList();
        taskList.addTask("Task 1");
        taskList.addTask("Task 2");
        taskList.addTask("Task 3");
        assertTrue(taskList.isValidTaskNumber(1));
        assertTrue(taskList.isValidTaskNumber(2));
        assertTrue(taskList.isValidTaskNumber(3));
        assertFalse(taskList.isValidTaskNumber(0));
        assertFalse(taskList.isValidTaskNumber(4));
    }
}
