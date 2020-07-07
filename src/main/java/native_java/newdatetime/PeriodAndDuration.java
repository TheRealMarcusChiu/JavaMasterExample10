package native_java.newdatetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Period   − It deals with DATE based amount of time.
 * Duration − It deals with TIME based amount of time.
 */
public class PeriodAndDuration {
    public static void main(String args[]){
        PeriodAndDuration java8tester = new PeriodAndDuration();

        java8tester.testPeriod();
        System.out.println("");
        java8tester.testDuration();
    }

    public void testPeriod(){

        // get the current date
        LocalDate date1 = LocalDate.now();
        System.out.println("Current date: " + date1);

        // add 1 month to current date
        LocalDate date2 = date1.plus(1, ChronoUnit.MONTHS);
        System.out.println("Next month:   " + date2);

        Period period = Period.between(date2, date1);
        System.out.println("Period: " + period);
    }

    public void testDuration(){

        // get current time
        LocalTime time1 = LocalTime.now();
        System.out.println("Current time:    " + time1);

        // add 2 hours to current time
        LocalTime time2 = time1.plus(Duration.ofHours(2));
        System.out.println("Time in 2 hours: " + time2);

        Duration duration = Duration.between(time1, time2);
        System.out.println("Duration: " + duration);
    }
}
