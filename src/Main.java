import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        StepTracker step = new StepTracker();
        boolean isRunning = true;

        System.out.println("Command list\n"
                + "Change goal;\n" + "Input moth;\n" + "Input steps;\n" + "Show stats;\n"
                + "For exit print exit");

        while (isRunning) {
            String command = scanner.nextLine();

            switch (command) {
                case ("Change goal"):
                    System.out.println("Current goal is: " + step.goal + ". Print new goal");
                    int newGoal = scanner.nextInt();
                    if ( newGoal >0)
                        step.goal = newGoal;
                    else System.out.println("Error: goal less than 0");
                    break;

                case ("Input months"):
                    System.out.println("Current month is: " + step.month+ ". Print number of month");
                    int newMonth = scanner.nextInt();
                    if ( newMonth > 0 && newMonth <= 12)
                        step.month = newMonth;
                    else System.out.println("Error: incorrect month");
                    break;

                case ("Input steps"):
                    System.out.println("Print day of month, 0 for first day, 29 for last day");
                    int day = scanner.nextInt();

                    if ( day >= 0 && day < 30) {
                        System.out.println("Print amount of steps");
                        int steps = scanner.nextInt();
                        if ( steps >= 0) {
                            System.out.println("Steps for " + day + "day is: " + steps);
                            step.days[day] = steps;
                        }
                        else System.out.println("Error: amount of steps should be positive");
                    } else System.out.println("Error: incorrect day");
                    break;

                case ("Show stats"):
                    for ( int i = 0 ; i < 30; i++)
                        System.out.println("Day" + i + ": " + step.days[i] + "steps, calories burnt: "
                                + step.calories(i) + "calories, distance was: " + step.km(i) + "km");
                    System.out.println("Best steps per day was: " + step.maximumStepsPerMonths() + " steps");
                    System.out.println("Best series was: " + step.bestSeries() + " days");
                    System.out.println("Average step per day: " + step.averageStep() + " steps");
                    System.out.println("Total distance was: " + step.totalKm() + " km");
                    System.out.println("Total calories burnt: " + step.totalBurnt() + " calories");
                    break;

                case ("exit"):
                    isRunning = false;
                    break;

                case (""):
                    break;

                default:
                    System.out.println("Error: incorrect command");
                    break;

            }
        }
    }
}