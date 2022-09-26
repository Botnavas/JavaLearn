public class MonthData {
    int[] days = new int[30];
    int[] goal = new int[30];
    int number;

    void fillGoal(int startGoal) {
        for (int i = 0; i < 30; i++) {
            goal[i] = startGoal;
        }
    }

    void setGoalForMonthFromCurrentDay(int day, int newGoal) {
        for (int i = day; i < 30; i++) {
            goal[i] = newGoal;
        }
    }

    MonthData(int month, int startGoal) {
        number = month;
        fillGoal(startGoal);
    }
}
