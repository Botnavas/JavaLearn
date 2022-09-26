import java.util.Scanner;

public class StepTracker {

    Scanner scanner = new Scanner(System.in);

    double stepLength = 0.0007;
    double caloriesPerStep = 0.075;

    MonthData[] monthData = new MonthData[12];

    StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthData[i] = new MonthData(i);
        }
    }


    int findMaximumStepsPerMonths(int monthNumber) {
        int maximum = 0;

        for (int i = 0; i < 30; i++) {
            if (monthData[monthNumber].days[i]> maximum) {
                maximum = monthData[monthNumber].days[i];
            }
        }
        return maximum;
    }

    int findAverageStep(int monthNumber) {
        int average = 0;

        for (int i = 0; i < 30; i++) {
            average += monthData[monthNumber].days[i];
        }
        return average / 30;
    }

    int findBestSeries(int monthNumber) {
        int series = 0;
        int bestSeries = 0;

        for (int i = 0; i < 30; i++) {
            if (monthData[monthNumber].days[i] >=  monthData[monthNumber].goal[i]) {
               series++;
            } else {
                if (series > bestSeries) {
                    bestSeries = series;
                }
                series = 0;
            }
        }
        return bestSeries;
    }

    double calculateCaloriesPerDay(int monthNumber, int day) {
        return monthData[monthNumber].days[day] * caloriesPerStep;
    }

    double calculateKmPerDay(int monthNumber, int day) {
        return monthData[monthNumber].days[day] * stepLength;
    }

    double calculateMonthBurnt(int monthNumber) {
        double burnt = 0;

        for (int i = 0; i < 30; i++) {
            burnt += calculateCaloriesPerDay(i, monthNumber);
        }
        return burnt;
    }

    double calculateMonthKm(int monthNumber) {
        double km = 0;

        for (int i = 0; i < 30; i++) {
            km += calculateKmPerDay(i, monthNumber);
        }
        return km;
    }

    void changeGoal() {

        int startingMonth;
        int startingDay;
        int newGoal;
        System.out.println("Enter date of starting new goal. Enter monthData now");
        startingMonth = scanner.nextInt();

        if (startingMonth >= 0 && startingMonth < 12) {
            System.out.println("Month when new goal starts: " + startingMonth
                    + ". Enter day when new goal will be actual");
        } else  {
            System.out.println("Error: incorrect monthData");
            return;
        }

        startingDay = scanner.nextInt();
        if (startingDay >= 0 && startingDay < 30) {
            System.out.println("Date when new goal starts: " + startingMonth + "." + startingDay
                + ". Goal for this day: " + monthData[startingMonth].goal[startingDay]
                + " steps. Enter new goal");
        } else  {
            System.out.println("Error: incorrect day.");
            return;
        }

        newGoal = scanner.nextInt();
        if (newGoal > 0) {
            monthData[startingMonth].setGoalForMonthFromCurrentDay(startingDay, newGoal);
            for (int i = startingMonth + 1; i < 12; i++) {
                monthData[i].setGoalForMonthFromCurrentDay(0, newGoal);
            }
        } else {
            System.out.println("Incorrect goal.");
        }
    }

    void enterSteps() {
        int currentMonth;
        int day;
        int steps;
        System.out.println("Enter date. Print monthData first");
        currentMonth = scanner.nextInt();

        if (currentMonth >= 0 && currentMonth < 30) {
            System.out.println("Enter day");
        } else {
            System.out.println("Incorrect monthData");
            return;
        }

        day = scanner.nextInt();
        if (day >= 0 && day < 30) {
            System.out.println("Date is :" + currentMonth + ". " + day + ". Enter steps");
        } else {
            System.out.println("Incorrect day");
            return;
        }

        steps = scanner.nextInt();
        if (steps >=0 ) {
            monthData[currentMonth].days[day] = steps;
        } else {
            System.out.println("Incorrect amount of steps");
        }
    }

    void showStats()
    {
        int currentMonth;
        System.out.println("Enter monthData");
        currentMonth = scanner.nextInt();

        if (currentMonth < 0 || currentMonth >= 12) {
            System.out.println("Incorrect monthData");
            return;
        }

        for (int i = 0 ; i < 30; i++) {
            System.out.println("Day" + i + ": " + monthData[currentMonth].days[i] + "steps, calories burnt: "
                    + calculateCaloriesPerDay(currentMonth, i) + " calories, distance was: "
                    + calculateKmPerDay(currentMonth, i) + "km");
        }
        System.out.println("Best steps per day was: " + findMaximumStepsPerMonths(currentMonth) + " steps");
        System.out.println("Best series was: " + findBestSeries(currentMonth) + " days");
        System.out.println("Average step per day: " + findAverageStep(currentMonth) + " steps");
        System.out.println("Total distance was: " + calculateMonthKm(currentMonth) + " km");
        System.out.println("Total calories burnt: " + calculateMonthBurnt(currentMonth) + " calories");
    }
}

