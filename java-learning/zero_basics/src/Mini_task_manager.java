import java.util.Scanner;
import java.util.ArrayList;

public class Mini_task_manager {

    public static void add_task(Scanner scanner, boolean run_task, ArrayList task_complexity){
        while (run_task) {
            System.out.println("Please indicate the complexity of the task on a scale of 1 to 100.");
            int complexity = scanner.nextInt();
            task_complexity.add(complexity);

            System.out.println("you have added to the complexity of the task");
            System.out.println("| 0. Exit  | 1. Again |");
            int choice_add_task = scanner.nextInt();

            switch (choice_add_task) {
                case 0:
                    run_task = false;
                    break;
                case 1:
                    break;
            }
        }
    }

    public static void  read_task(ArrayList task_complexity) {
        System.out.println("\n===================");
        System.out.println(task_complexity);
        System.out.println("===================\n");
    }

    public static void sum_task(ArrayList<Integer> task_complexity) {
        int sum = 0;
        for (int i = 0; i < task_complexity.size(); i++ ) {
            sum += task_complexity.get(i);
        }

        System.out.println("\n===============");
        System.out.println("Sum: " + sum);
        System.out.println("===============\n");
    }

    public static void mean_value(ArrayList<Integer> task_complexity) {
        int sum = 0;
        for (int i = 0; i < task_complexity.size(); i++ ) {
            sum += task_complexity.get(i);
        }
        double mean_value = (double) sum / task_complexity.size();

        System.out.println("\n===============");
        System.out.println("mean value: " + mean_value);
        System.out.println("===============\n");
    }

    public static void min_max(ArrayList<Integer> task_complexity) {
        int min = task_complexity.get(0);
        int max = task_complexity.get(0);
        for (int val : task_complexity) {
            if (val < min) min = val;
            if (val > max) max = val;
        }

        System.out.println("\n===============");
        System.out.println("The min value is " + min);
        System.out.println("The max value is " + max);
        System.out.println("===============\n");

    }

    public static void main(String[] args) {
       boolean running = true;
       Scanner scanner = new Scanner(System.in);
       ArrayList<Integer> task_complexity = new ArrayList<>();
       while (running) {
           System.out.println("| 0. Exit | 1. Add task | 2. Read task | 3. Sum | 4. mean value | 5. min and max");
           int choice_menu = scanner.nextInt();

           switch (choice_menu) {
               case 0:
                   running = false;
                   break;
               case 1:
                   boolean run_task = true;
                   add_task(scanner, run_task, task_complexity);
                   break;
               case 2:
                   read_task(task_complexity);
                   break;
               case 3:
                   sum_task(task_complexity);
                   break;
               case 4:
                   mean_value(task_complexity);
                   break;
               case 5:
                   min_max(task_complexity);
                   break;
           }
       }
    }
}