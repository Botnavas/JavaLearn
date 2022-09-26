import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        StepTracker step = new StepTracker();
        boolean isRunning = true;

        System.out.println("Command list:\n"
                + "Change goal;\n" + "Enter steps;\n" + "Show stats;\n"
                + "help;\n" +"For exit print exit\n\n" + "Date format: monthData.day ");
        while (isRunning) {
            String command = scanner.nextLine();
            switch (command) {
                case "Change goal":
                    step.changeGoal();
                    break;

                case "Enter steps":
                    step.enterSteps();
                    break;

                case "Show stats":
                    step.showStats();
                    break;

                case "exit":
                    isRunning = false;
                    break;

                case "help":
                    System.out.println("Command list:\n"
                            + "Change goal;\n" + "Input moth;\n" + "Enter steps;\n" + "Show stats;\n"
                            + "help;\n" +"For exit print exit\n\n" + "Date format: monthData.day ");
                    break;

                case "":

                default:
                    System.out.println("Error: incorrect command");
            }
        }
    }
}