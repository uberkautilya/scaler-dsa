package fundamentals.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoDate {
    public static void main(String[] args) throws ParseException {
        final String dateString = "2024-04-23T12:34:51";

        String formatString = "yyyy-MM-dd'T'HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String formattedDate = simpleDateFormat.format(new Date());
        System.out.println(formattedDate);

        SimpleDateFormat istDateFormat = new SimpleDateFormat(formatString);
        istDateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
        Date date = istDateFormat.parse(formattedDate);
        System.out.println("new Date(formattedDate) = " + date);


//        javaTimePackage();

//        dateParsingInMultithread(simpleDateFormat, dateString);
//        parsingDate();
    }

    /**
     * The objects created with LocalDate, LocalTime, LocalDateTime and ZonedDateTime are immutable.
     * plus and minus methods return new objects, not modify the original object
     */
    private static void javaTimePackage() {
        System.out.println("DemoDate.javaTimePackage");

        LocalDate localDate = LocalDate.of(2024, Month.JANUARY, 30);
        System.out.println("localDate = " + localDate);
        //Would take the date to 2024 February 28, as there are no 30 days in February
        localDate = localDate.plusMonths(1);
        System.out.println("localDate = " + localDate);

        LocalTime localTime = LocalTime.of(11, 13);
        System.out.println("localTime = " + localTime);

        //Creates a new object as the original object is immutable
        localTime = localTime.minusHours(5).minusMinutes(30);
        System.out.println("localTime = " + localTime);

        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println("localDateTime = " + localDateTime);

//        for (String availableZoneId : ZoneId.getAvailableZoneIds()) {
//            System.out.println(availableZoneId);
//        }

        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate, localTime, ZoneId.of("Asia/Kolkata"));
        System.out.println("zonedDateTime = " + zonedDateTime);
        zonedDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Kolkata"));
//        zonedDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("Greenwich"));
        System.out.println("zonedDateTime = " + zonedDateTime);
        Instant instant = Instant.from(zonedDateTime);
        System.out.println("instant = " + instant);

        System.out.println(
                DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss")
                        .format(zonedDateTime)
        );
    }

    /**
     * Weird behavior when parsing string into date in a multi threaded scenario
     * SimpleDateFormat is not thread safe
     * Solution would be to create a new object for SimpleDateFormat in each thread
     * Alternative: FastDateFormat from apache
     */
    private static void dateParsingInMultithread(SimpleDateFormat simpleDateFormat, String dateString) {
        System.out.println("DemoDate.dateParsingInMultithread");
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Date date = simpleDateFormat.parse(dateString);
                    System.out.println("currentDate = " + date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            executorService.submit(runnable);
        }
        executorService.shutdown();
    }

    private static void parsingDate() {
        System.out.println("\nDemoDate.parsingDate");
        String dateString = "2024-04-12T19:07:51Z";
//        LocalDateTime dateTime = LocalDateTime.parse(dateString);
//        System.out.println("dateTime = " + dateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        LocalDateTime dateTime1 = LocalDateTime.parse(dateString, formatter);
        System.out.println("dateTime1 = " + dateTime1);

        Instant parse = Instant.parse(dateString);
        ZonedDateTime ist = parse.atZone(ZoneId.of("IST", ZoneId.SHORT_IDS));
        System.out.println("ist = " + ist);
    }
}
