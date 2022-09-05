public class StepTracker {
    int goal = 10000;
    int month = 0;
    int[] days = new int[30];
    double stepLength = 0.0007;
    double caloriesPerStep = 1.5;

    void fillDays()
    {
        for (int i = 0; i < 30; i++)
        {
            days[i] = 0;
        }
    }

    int maximumStepsPerMonths() {
        int maximum = 0;
        for (int i = 0; i < 30; i++) {
            if (days[i] > maximum)
                maximum = days[i];
        }
        return maximum;
    }

    int averageStep() {
        int average = 0;
        for (int i = 0; i < 30; i++) {
            average += days[i];
        }
        return average / 30;
    }

    int bestSeries() {
        int series = 0;
        int bestSeries = 0;
        for(int i = 0; i < 30; i++) {
            if (days[i] >= goal) {
                for ( int j = i; j < 30; j++) {
                    if (days[j] >= goal)
                        series++;
                    else {
                        if (series > bestSeries)
                            bestSeries = series;

                        i = j;
                        series = 0;
                        break;
                    }
                }
            }
        }

        return bestSeries;
    }

    double calories( int day) {
        return (double)days[day] * caloriesPerStep;
    }

    double km( int day) {
        return (double)days[day] * stepLength;
    }

    double totalBurnt() {
        double Burnt = 0;
        for ( int i = 0; i < 30; i++)
            Burnt += calories(i);
        return Burnt;
    }

    double totalKm() {
        double km = 0;
        for ( int i = 0; i < 30; i++)
            km += km(i);
        return km;
    }
}

