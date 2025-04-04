package org.ahmed;


public class TaskCLI {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Task Tracker CLI");
            System.out.println("Usage:");
            System.out.println("  task-cli add \"Task Description\"");
            System.out.println("  task-cli update <id> \"New description\"");
            System.out.println("  task-cli delete <id>");
            System.out.println("  task-cli mark-in-progress <id>");
            System.out.println("  task-cli mark-done <id>");
            System.out.println("  task-cli list");
            System.out.println("  task-cli list [todo|in-progress|done]");
            return;
        }

        String command = args[0];

        switch (command) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Please provide a description for the task");
                    return;
                }
                TaskManager.addTask(args[1]);
                break;
            case "update":
                if (args.length < 3) {
                    System.out.println("Please provide a task id and a new description");
                    return;
                }
                int id = Integer.parseInt(args[1]);
                String newDescription = args[2];
                TaskManager.updateTask(id, newDescription);
                break;
            case "delete":
                if (args.length < 2) {
                    System.out.println("Please provide a task id");
                    return;
                }
                int taskIdDelete = Integer.parseInt(args[1]);
                TaskManager.deleteTask(taskIdDelete);
                break;
            case "mark-in-progress":
                if (args.length < 2) {
                    System.out.println("Please provide a task id");
                    return;
                }
                int taskId = Integer.parseInt(args[1]);
                TaskManager.markTask(taskId, "in-progress");
                break;
            case "mark-done":
                if (args.length < 2) {
                    System.out.println("Please provide a task id");
                    return;
                }
                int taskIdDone = Integer.parseInt(args[1]);
                TaskManager.markTask(taskIdDone, "done");
                break;
            case "list":
                String status = args.length > 1 ? args[1] : null;
                TaskManager.listTasks(status);
                break;
            default:
                    System.out.println("Unknown command: " + command);
        }
    }
}
