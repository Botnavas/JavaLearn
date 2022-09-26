public class MonthData {
    int[] days = new int[30];
    int[] goal = new int[30];
    int number;

    void fillGoal() {
        for (int i = 0; i < 30; i++) {
            goal[i] = 10000;
        }
    }

    void setGoalForMonthFromCurrentDay(int day, int newGoal) {
        for (int i = day; i < 30; i++) {
            goal[i] = newGoal;
        }
    }

    MonthData(int month) {
        number = month;
        fillGoal();
    }
}
