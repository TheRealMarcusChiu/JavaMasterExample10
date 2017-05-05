package native_java.java_8.newdatetime.local.and.zoned.datetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Zoned {
    public static void main(String args[]){
        Zoned java8tester = new Zoned();
        java8tester.testZonedDateTime();
    }

    public void testZonedDateTime(){

        ZoneId currentZoneID = ZoneId.systemDefault();
        ZoneId zoneId1       = ZoneId.of("Europe/Paris");

        System.out.println("ZONE IDS");
        System.out.println("--------");
        System.out.println("CurrentZoneID: " + currentZoneID);
        System.out.println("ZoneId 1:      " + zoneId1);


        System.out.println("\n\nZONED DATE TIME");
        System.out.println("---------------");

        // Get the zoned date and time
        ZonedDateTime currentDate = ZonedDateTime.now();
        ZonedDateTime date1       = ZonedDateTime.now(zoneId1);
        ZonedDateTime date2       = ZonedDateTime.parse("2007-12-03T10:15:30.901+05:30[Asia/Karachi]");

        System.out.println("CurrentDateTime: " + currentDate);
        System.out.println("Date 1:          " + date1);
        System.out.println("Date 2:          " + date2);
    }
}
