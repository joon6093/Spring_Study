package chapter12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class DateTimeComparisonExample {

    public static void main(String[] args) {
        // 현재 날짜 (LocalDate)
        LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate: " + localDate);

        // 현재 날짜와 시간 (LocalDateTime)
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime: " + localDateTime);

        // 현재 날짜와 시간, 특정 오프셋 (OffsetDateTime)
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println("OffsetDateTime: " + offsetDateTime);

        // 현재 날짜와 시간, 특정 타임존 (ZonedDateTime)
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("ZonedDateTime: " + zonedDateTime);

        // 비교 예제
        // LocalDate와 LocalDateTime 비교
        System.out.println("LocalDate가 LocalDateTime과 동일한 날짜인가? " + localDate.isEqual(localDateTime.toLocalDate()));

        // LocalDateTime과 ZonedDateTime 비교
        System.out.println("LocalDateTime이 ZonedDateTime과 동일한 날짜와 시간인가? " + localDateTime.isEqual(zonedDateTime.toLocalDateTime()));

        // ZonedDateTime과 OffsetDateTime 비교
        System.out.println("ZonedDateTime이 OffsetDateTime과 동일한 날짜와 시간인가? " + zonedDateTime.toOffsetDateTime().isEqual(offsetDateTime));

        // 특정 타임존의 ZonedDateTime 생성 및 비교
        ZonedDateTime zonedDateTimeInNY = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("New York의 ZonedDateTime: " + zonedDateTimeInNY);
        System.out.println("ZonedDateTime이 New York의 ZonedDateTime과 동일한 날짜와 시간인가? " + zonedDateTime.isEqual(zonedDateTimeInNY));
    }
}
