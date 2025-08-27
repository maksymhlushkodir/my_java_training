import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private int id;
    private String name;
    private String description;
    private int complexity;
    private String status;

    public Task(int id, String name, String description, int complexity, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.complexity = complexity;
        this.status = status;
    }

    // 🔹 Геттери (щоб "отримати" дані з об’єкта)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getComplexity() {
        return complexity;
    }

    public String getStatus() {
        return status;
    }

    // 🔹 Setter (for example, you can change the status of a task)
    public void setStatus(String status) {
        this.status = status;
    }

    // 🔹 Красивий вивід (toString)
    @Override
    public String toString() {
        return "Task #" + id + " [" + status + "] " +
                "\nName: " + name +
                "\nDescription: " + description +
                "\nComplexity: " + complexity + "\n";
    }

    public void read_task(Scanner scanner, ArrayList<Task> tasks) {

    }
}
class ManagerTask{
    private ArrayList<Task> tasks;
    private Scanner scanner;

    public  ManagerTask() {
        this.tasks = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void add_task(Scanner scanner, ArrayList<Task> tasks) {
        System.out.print("\nWrite down the task ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // "споживаємо" зайвий символ нового рядка після nextInt()

        System.out.print("Write the name of the task: ");
        String name = scanner.nextLine();

        System.out.print("Write description: ");
        String description = scanner.nextLine();

        System.out.print("Specify complexity (1-10): ");
        int complexity = scanner.nextInt();
        scanner.nextLine(); // знову "споживаємо" зайвий \n

        System.out.print("Specify status (1. to-do / 2. work / 3. completed): ");
        int status_try = scanner.nextInt();
        String status = "";

        switch (status_try) {
            case 1:
                status = "to-do";
                System.out.println("Status is to-do");
                break;
            case 2:
                status = "work";
                System.out.println("Status is work");
                break;
            case 3:
                status = "completed";
                System.out.println("Status is completed");
                break;
            default:
                System.out.println("Invalid choice! Try again.");
        }


        // створюємо Task
        Task newTask = new Task(id, name, description, complexity, status);

        // додаємо в список
        tasks.add(newTask);

        System.out.println("✅ Task added!");
    }

    // 🔹 Method for deleting a task
    public void removeTask(Scanner scanner, ArrayList<Task> tasks) {
        System.out.println("Enter the task ID to delete:");
        int id = scanner.nextInt();

        tasks.removeIf(task -> task.getId() == id);
        System.out.println("\uD83D\uDDD1\uFE0F Task deleted!");
    }

    // 🔹 Method for reviewing tasks
    public void readTasks(Scanner scanner, ArrayList<Task> tasks, ArrayList<Task> inProgressTasks, boolean run_read) {
        if (tasks.isEmpty()) {
            System.out.println("📭 No tasks yet!");
        } else {
            while (run_read) {
                System.out.println("Choose what to read (0. exit /1. to-do / 2. work / 3. completed / 4. all)");
                int read_choice = scanner.nextInt();

                switch (read_choice) {
                    case 0:
                        run_read = false;
                        break;
                    case 1:
                        for (Task task : tasks) {
                            if ("to-do".equals(task.getStatus())) {
                                inProgressTasks.add(task);
                                System.out.println(inProgressTasks);
                                inProgressTasks.remove(task);
                            }
                        }
                        break;
                    case 2:
                        for (Task task : tasks) {
                            if ("work".equals(task.getStatus())) {
                                inProgressTasks.add(task);
                                System.out.println(inProgressTasks);
                                inProgressTasks.remove(task);
                            }
                        }
                        break;
                    case 3:
                        for (Task task : tasks) {
                            if ("completed".equals(task.getStatus())) {
                                inProgressTasks.add(task);
                                System.out.println(inProgressTasks);
                                inProgressTasks.remove(task);
                            }
                        }
                        break;
                    case 4:
                        System.out.println("all");
                        for (Task task : tasks) {
                            System.out.println(task); // тут працює toString() з класу Task
                        }
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }
        }
    }
    // 🔹 Method for changing tasks
    public void editTask(Scanner scanner, ArrayList<Task> tasks) {
        System.out.println("Enter the task ID to change the status:");
        int id = scanner.nextInt();

        for (Task task : tasks) {
            if (task.getId() == id) {
                String status = "";
                System.out.print("New status (1. to-do / 2. work / 3. completed): ");
                int status_choice = scanner.nextInt();

                switch (status_choice) {
                    case 1: status = "to-do"; break;
                    case 2: status = "work"; break;
                    case 3: status = "completed"; break;
                    default:
                        System.out.println("Invalid choice!");
                        return;
                }
                task.setStatus(status);
                System.out.println("✅ Status changed!");
                return;
            }
        }
        System.out.println("❌ Task with this ID not found.");
    }

    // 🔹 Getter for task list
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}

public class TaskManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        ArrayList<Task> inProgressTasks = new ArrayList<>();
        ManagerTask manager = new ManagerTask();
        boolean running = true;
        boolean run_read = true;
        while (running) {
            System.out.println("|=== Task Manager Menu ===");
            System.out.println("|0. Exit");
            System.out.println("|1. Add task");
            System.out.println("|2. Remove task");
            System.out.println("|3. View tasks");
            System.out.println("|4. Edit tasks");
            System.out.print("|Your choice: ");
            int menu_choice = scanner.nextInt();
            switch (menu_choice) {
                case 0:
                    running = false;
                    System.out.println("Goodbye! 👋");
                    break;
                case 1:
                    manager.add_task(scanner, tasks);
                    break;
                case 2:
                    manager.removeTask(scanner, tasks);
                    break;
                case 3:
                    manager.readTasks(scanner, tasks, inProgressTasks, run_read);
                    break;
                case 4:
                    manager.editTask(scanner, tasks);
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
        scanner.close();
    }
}