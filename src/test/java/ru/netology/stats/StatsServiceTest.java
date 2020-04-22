package ru.netology.stats;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class StatsServiceTest {

    private long[] fillMonthSales(long jan, long feb, long mar, long apr, long may, long jun, long jul, long aug, long sep, long oct, long nov, long dec) {
        long[] resultMonth = new long[12];
        resultMonth[0] = jan;
        resultMonth[1] = feb;
        resultMonth[2] = mar;
        resultMonth[3] = apr;
        resultMonth[4] = may;
        resultMonth[5] = jun;
        resultMonth[6] = jul;
        resultMonth[7] = aug;
        resultMonth[8] = sep;
        resultMonth[9] = oct;
        resultMonth[10] = nov;
        resultMonth[11] = dec;
        return resultMonth;
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'Right data from task'; 8; 15; 13; 15; 17; 20; 19; 20; 7; 14; 14; 18; 180",
                    "'Wrong data from task'; 8; 15; 13; 15; 17; 20; 19; 20; 7; 14; 14; 18; 181",
                    "'Equal data'; 10; 10; 10; 10; 10; 10; 10; 10; 10; 10; 10; 10; 120",
                    "'Zero data'; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0"
            }
            , delimiter = ';'
    )
    void calcSum(String test, long jan, long feb, long mar, long apr, long may, long jun, long jul, long aug, long sep, long oct, long nov, long dec, long expected) {
        StatsService service = new StatsService();
        long[] monthSales = fillMonthSales(jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec);
        long monthSum = service.calcSum(monthSales);
        assertEquals(expected, monthSum);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'Right data from task'; 8; 15; 13; 15; 17; 20; 19; 20; 7; 14; 14; 18; 15",
                    "'Wrong data from task'; 8; 15; 13; 15; 17; 20; 19; 20; 7; 14; 14; 18; 18",
                    "'Equal data'; 10; 10; 10; 10; 10; 10; 10; 10; 10; 10; 10; 10; 10",
                    "'Zero data'; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0"
            }
            , delimiter = ';')
    void calcAverage(String test, long jan, long feb, long mar, long apr, long may, long jun, long jul, long aug, long sep, long oct, long nov, long dec, long expected) {
        StatsService service = new StatsService();
        long[] monthSales = fillMonthSales(jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec);
        long monthAvg = service.calcAverage(monthSales);
        assertEquals(expected, monthAvg);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'Right data from task'; 8; 15; 13; 15; 17; 20; 19; 20; 7; 14; 14; 18; 8",
                    "'Wrong data from task'; 8; 15; 13; 15; 17; 20; 19; 20; 7; 14; 14; 18; 1",
                    "'Equal data'; 10; 10; 10; 10; 10; 10; 10; 10; 10; 10; 10; 10; 12",
                    "'Zero data'; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 12"
            }
            , delimiter = ';')
    void monthMax(String test, long jan, long feb, long mar, long apr, long may, long jun, long jul, long aug, long sep, long oct, long nov, long dec, long expected) {
        StatsService service = new StatsService();
        long[] monthSales = fillMonthSales(jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec);
        int monthNum = service.monthMax(monthSales);
        assertEquals(expected, monthNum);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'Right data from task'; 8; 15; 13; 15; 17; 20; 19; 20; 7; 14; 14; 18; 9",
                    "'Wrong data from task'; 8; 15; 13; 15; 17; 20; 19; 20; 7; 14; 14; 18; 1",
                    "'Equal data'; 10; 10; 10; 10; 10; 10; 10; 10; 10; 10; 10; 10; 12",
                    "'Zero data'; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 12"
            }
            , delimiter = ';')
    void monthMin(String test, long jan, long feb, long mar, long apr, long may, long jun, long jul, long aug, long sep, long oct, long nov, long dec, long expected) {
        StatsService service = new StatsService();
        long[] monthSales = fillMonthSales(jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec);
        int monthNum = service.monthMin(monthSales);
        assertEquals(expected, monthNum);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'Right data from task'; 8; 15; 13; 15; 17; 20; 19; 20; 7; 14; 14; 18; 5",
                    "'Wrong data from task'; 8; 15; 13; 15; 17; 20; 19; 20; 7; 14; 14; 18; 6",
                    "'Equal data'; 10; 10; 10; 10; 10; 10; 10; 10; 10; 10; 10; 10; 0",
                    "'Zero data'; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0"
            }
            , delimiter = ';')
    void monthLessAverage(String test, long jan, long feb, long mar, long apr, long may, long jun, long jul, long aug, long sep, long oct, long nov, long dec, long expected) {
        StatsService service = new StatsService();
        long[] monthSales = fillMonthSales(jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec);
        int monthNum = service.monthLessAverage(monthSales);
        assertEquals(expected, monthNum);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'Right data from task'; 8; 15; 13; 15; 17; 20; 19; 20; 7; 14; 14; 18; 5",
                    "'Wrong data from task'; 8; 15; 13; 15; 17; 20; 19; 20; 7; 14; 14; 18; 6",
                    "'Equal data'; 10; 10; 10; 10; 10; 10; 10; 10; 10; 10; 10; 10; 0",
                    "'Zero data'; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0"
            }
            , delimiter = ';')
    void monthMoreAverage(String test, long jan, long feb, long mar, long apr, long may, long jun, long jul, long aug, long sep, long oct, long nov, long dec, long expected) {
        StatsService service = new StatsService();
        long[] monthSales = fillMonthSales(jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec);
        int monthNum = service.monthMoreAverage(monthSales);
        assertEquals(expected, monthNum);
    }


}