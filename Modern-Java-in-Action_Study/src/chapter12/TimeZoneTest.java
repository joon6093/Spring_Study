package chapter12;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneTest {
    public static void main(String[] args) {
        // 현재 로컬 날짜와 시간
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("현재 로컬 날짜와 시간: " + localDateTime);

        // 특정 시간대로 변환
        ZoneId newYorkZoneId = ZoneId.of("America/New_York");
        ZonedDateTime newYorkDateTime = ZonedDateTime.of(localDateTime, newYorkZoneId);
        System.out.println("뉴욕 시간대 날짜와 시간: " + newYorkDateTime);

        ZoneId tokyoZoneId = ZoneId.of("Asia/Tokyo");
        ZonedDateTime tokyoDateTime = ZonedDateTime.of(localDateTime, tokyoZoneId);
        System.out.println("도쿄 시간대 날짜와 시간: " + tokyoDateTime);

        // 포맷터를 사용하여 ZonedDateTime을 문자열로 포맷팅
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        String formattedNewYorkDateTime = newYorkDateTime.format(formatter);
        String formattedTokyoDateTime = tokyoDateTime.format(formatter);
        System.out.println("포맷된 뉴욕 시간대 날짜와 시간: " + formattedNewYorkDateTime);
        System.out.println("포맷된 도쿄 시간대 날짜와 시간: " + formattedTokyoDateTime);

        // 문자열을 ZonedDateTime으로 파싱
        ZonedDateTime parsedNewYorkDateTime = ZonedDateTime.parse(formattedNewYorkDateTime, formatter);
        ZonedDateTime parsedTokyoDateTime = ZonedDateTime.parse(formattedTokyoDateTime, formatter);
        System.out.println("파싱된 뉴욕 시간대 날짜와 시간: " + parsedNewYorkDateTime);
        System.out.println("파싱된 도쿄 시간대 날짜와 시간: " + parsedTokyoDateTime);
    }
}
