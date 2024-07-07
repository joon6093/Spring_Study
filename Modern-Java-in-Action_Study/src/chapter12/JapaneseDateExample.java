package chapter12;

import java.time.LocalDate;
import java.time.chrono.JapaneseChronology;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class JapaneseDateExample {
    public static void main(String[] args) {
        // 현재 날짜를 JapaneseDate로 변환
        JapaneseDate japaneseDate = JapaneseDate.from(LocalDate.now());
        System.out.println("현재 일본식 날짜: " + japaneseDate);

        // 특정 날짜를 JapaneseDate로 변환
        LocalDate date = LocalDate.of(2023, 7, 7);
        JapaneseDate specificJapaneseDate = JapaneseDate.from(date);
        System.out.println("특정 일본식 날짜: " + specificJapaneseDate);

        // JapaneseChronology를 사용하여 날짜를 생성
        JapaneseChronology japaneseChronology = JapaneseChronology.INSTANCE;
        JapaneseDate chronoJapaneseDate = japaneseChronology.date(date);
        System.out.println("JapaneseChronology를 사용한 일본식 날짜: " + chronoJapaneseDate);

        // 포맷터를 사용하여 JapaneseDate를 문자열로 포맷팅
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("G yyyy-MM-dd")
                .withChronology(JapaneseChronology.INSTANCE)
                .withResolverStyle(ResolverStyle.STRICT);
        String formattedJapaneseDate = formatter.format(chronoJapaneseDate);
        System.out.println("포맷된 일본식 날짜: " + formattedJapaneseDate);

        // 문자열을 JapaneseDate로 파싱
        JapaneseDate parsedJapaneseDate = JapaneseDate.from(formatter.parse(formattedJapaneseDate));
        System.out.println("파싱된 일본식 날짜: " + parsedJapaneseDate);
    }
}
