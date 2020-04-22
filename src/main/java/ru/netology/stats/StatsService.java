package ru.netology.stats;

public class StatsService {

    public long calcSum(long[] monthSales) {
        long resultSum = 0;
        for (long monthSum : monthSales) {
            resultSum += monthSum;
        }

        return resultSum;
    }

    public long calcAverage(long[] monthSales) {
        return calcSum(monthSales) / monthSales.length;

    }

    public int monthMax(long[] monthSales) {
        int resultMonth = 0;
        long maxSale = monthSales[0];

        for (int i = 0; i < monthSales.length; i++) {
            if (maxSale <= monthSales[i]) {
                maxSale = monthSales[i];
                resultMonth = i;
            }
        }

        return resultMonth + 1;
    }

    public int monthMin(long[] monthSales) {
        int resultMonth = 0;
        long minSale = monthSales[0];

        for (int i = 0; i < monthSales.length; i++) {
            if (minSale >= monthSales[i]) {
                minSale = monthSales[i];
                resultMonth = i;
            }
        }

        return resultMonth + 1;
    }

    public int monthLessAverage(long[] monthSales) {
        long averageSum = calcAverage(monthSales);
        int resultMonth = 0;
        for (long month : monthSales) {
            if (month < averageSum) {
                resultMonth++;
            }
        }

        return resultMonth;
    }

    public int monthMoreAverage(long[] monthSales) {
        long averageSum = calcAverage(monthSales);
        int resultMonth = 0;
        for (long month : monthSales) {
            if (month > averageSum) {
                resultMonth++;
            }
        }

        return resultMonth;
    }

}