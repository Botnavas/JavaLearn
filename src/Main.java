import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        StepTracker step = new StepTracker();
        boolean isRunning = true;

        while (isRunning) {
            String command = scanner.nextLine();

            switch (command) {
                case "Change goal":
                    step.changeGoal();
                    break;

                case "Input months":
                    step.inputMonths();
                    break;

                case "Input steps":
                    step.inputSteps();
                    break;

                case "Show stats":
                   step.showStats();
                    break;

                case "exit":
                     isRunning = false;
                    break;

                case "":
                    break;

                default:
                    System.out.println("Error: incorrect command");
                    break;
            }
        }
    }
}