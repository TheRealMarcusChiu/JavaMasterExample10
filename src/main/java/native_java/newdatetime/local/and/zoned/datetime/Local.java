package native_java.newdatetime.local.and.zoned.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;

public class Local {
    public static void main(String args[]){
        Local java8tester = new Local();
        java8tester.testLocalDateTime();
    }

    public void testLocalDateTime(){

        // Get the current date and time
        LocalDateTime currentTime   = LocalDateTime.now();
        System.out.println("Current DateTime:   " + currentTime);

        System.out.println("");

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();
        System.out.println("Month:   " + month);
        System.out.println("Day:     " + day);
        System.out.println("seconds: " + seconds);

        System.out.println("");

        LocalDate date1     = currentTime.toLocalDate();
        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        LocalDate date3     = LocalDate.of(2014, Month.DECEMBER, 12); //12 december 2014
        LocalTime date4     = LocalTime.of(22, 15); //22 hour 15 minutes
        LocalTime date5     = LocalTime.parse("20:15:30"); //parse a string

        System.out.println("Date 1: " + date1);
        System.out.println("Date 2: " + date2);
        System.out.println("Date 3: " + date3);
        System.out.println("Date 4: " + date4);
        System.out.println("Date 5: " + date5);
    }
}
