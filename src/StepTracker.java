import java.util.Scanner;

public class StepTracker {
    StepTracker() {
        System.out.println("Command list:\n"
                + "Change goal;\n" + "Input moth;\n" + "Input steps;\n" + "Show stats;\n"
                + "For exit print exit");
        fillDays();
    }
    Scanner scanner = new Scanner(System.in);
    int goal = 10000;
    int month = 0;
    int[] days = new int[30];
    double stepLength = 0.0007;
    double caloriesPerStep = 0.15;

    void fillDays()
    {
        for (int i = 0; i < 30; i++) {
            days[i] = 0;
        }
    }

    int findMaximumStepsPerMonths() {
        int maximum = 0;

        for (int i = 0; i < 30; i++) {
            if (days[i] > maximum) {
                maximum = days[i];
            }
        }
        return maximum;
    }

    int findAverageStep() {
        int average = 0;

        for (int i = 0; i < 30; i++) {
            average += days[i];
        }
        return average / 30;
    }

    int findBestSeries() {
        int series = 0;
        int bestSeries = 0;

        for (int i = 0; i < 30; i++) {
            if (days[i] >= goal) {
                for (int j = i; j < 30; j++) {
                    if (days[j] >= goal) {
                        series++;
                    }
                    else {
                        if (series > bestSeries) {
                            bestSeries = series;
                        }
                        i = j;
                        series = 0;
                        break;
                    }
                }
            }
        }
        return bestSeries;
    }

    double calculateCaloriesPerDay(int day) {
        return days[day] * caloriesPerStep;
    }

    double calculateKmPerDay(int day) {
        return days[day] * stepLength;
    }

    double calculateTotalBurnt() {
        double burnt = 0;

        for (int i = 0; i < 30; i++) {
            burnt += calculateCaloriesPerDay(i);
        }
        return burnt;
    }

    double calculateTotalKm() {
        double km = 0;

        for (int i = 0; i < 30; i++) {
            km += calculateKmPerDay(i);
        }
        return km;
    }

    void changeGoal() {
        System.out.println("Current goal is: " + goal + ". Print new goal");
        int newGoal = scanner.nextInt();

        if (newGoal > 0) {
            goal = newGoal;
            System.out.println("New goal is: " + goal + " steps");
        }
        else  {
            System.out.println("Error: goal less than 0");
        }
    }

    void inputMonths() {
        System.out.println("Current month is: " + month+ ". Print number of month");
        int newMonth = scanner.nextInt();

        if (newMonth > 0 && newMonth <= 12) {
            month = newMonth;
        }
        else {
            System.out.println("Error: incorrect month");
        }
    }

    void inputSteps() {
        System.out.println("Print day of month, 0 for first day, 29 for last day");
        int day = scanner.nextInt();

        if (day >= 0 && day < 30) {
            System.out.println("Print amount of steps");
            int steps = scanner.nextInt();
            if ( steps >= 0) {
                System.out.println("Steps for " + day + "day is: " + steps);
                days[day] = steps;
            }
            else {
                System.out.println("Error: amount of steps should be positive");
            }
        } else {
            System.out.println("Error: incorrect day");
        }
    }

    void showStats()
    {
        for (int i = 0 ; i < 30; i++) {
            System.out.println("Day" + i + ": " + days[i] + "steps, calories burnt: "
                    + calculateCaloriesPerDay(i) + " calories, distance was: " + calculateKmPerDay(i) + "km");
        }
        System.out.println("Best steps per day was: " + findMaximumStepsPerMonths() + " steps");
        System.out.println("Best series was: " + findBestSeries() + " days");
        System.out.println("Average step per day: " + findAverageStep() + " steps");
        System.out.println("Total distance was: " + calculateTotalKm() + " km");
        System.out.println("Total calories burnt: " + calculateTotalBurnt() + " calories");
    }
}

