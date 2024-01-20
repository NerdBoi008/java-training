package taskone;

import java.util.List;
import java.util.ArrayList;

public final class TaskList {

    public static TaskList INSTANCE = new TaskList();

    private static final List<String> tasks = (List<String>)(new ArrayList<String>());

    private TaskList() {}

    public final void addTask(String name) {
        if (((CharSequence)name).length() > 0) {
            tasks.add(name);
            System.out.println("task " + name + " added.");
         }
    }

    public final void removeTask(int taskNumber) {
        if (this.isTaskNumberValid(taskNumber)) {
           String task = (String)tasks.get(taskNumber - 1);
           tasks.remove(taskNumber - 1);
           System.out.println("task: \"" + task + "\" removed");
        } else {
           System.out.println("Task number should be within range");
        }
    }

    public final void displayTasks() {
        String heading;
        if (this.isTaskListEmpty()) {
            heading = "---------------------------------------------------------\n[-] THERE ARE NO TASKS\n---------------------------------------------------------";
            System.out.println(heading);
        } else {
            heading = "---------------------------------------------------------\nTASKS:\n---------------------------------------------------------";
            System.out.println(heading);

            Object[] var2 = new Object[] {
                "Task No.", 
                "Task Name"
            };

            System.out.printf("| %-10s | %-40s |\n", var2);
            System.out.println("|------------|------------------------------------------|");
            int index = 0;

            for(int var3 = tasks.size(); index < var3; ++index) {
                Object[] var4 = new Object[] {
                    String.valueOf(index + 1), 
                    String.valueOf(tasks.get(index))
                };
                System.out.printf("| %-10s | %-40s |\n", var4);
            }

            System.out.println("---------------------------------------------------------");
        }
    }

    private final boolean isTaskNumberValid(int number) {
        return number >= 1 && number <= tasks.size();
    }

    private final boolean isTaskListEmpty() {
        return tasks.isEmpty();
    }
}
