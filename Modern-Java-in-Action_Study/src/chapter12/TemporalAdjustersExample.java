package chapter12;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;

public class TemporalAdjustersExample {
    public static void main(String[] args) {
        // 현재 날짜
        LocalDate today = LocalDate.now();
        System.out.println("오늘 날짜: " + today);

        // 다음 월요일로 조정
        LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("다음 월요일: " + nextMonday);

        // 이번 달의 첫 번째 날로 조정
        LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("이번 달의 첫 번째 날: " + firstDayOfMonth);

        // 이번 달의 마지막 날로 조정
        LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("이번 달의 마지막 날: " + lastDayOfMonth);

        // 다음 달의 첫 번째 일요일로 조정
        LocalDate firstSundayOfNextMonth = today.with(TemporalAdjusters.firstDayOfNextMonth())
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        System.out.println("다음 달의 첫 번째 일요일: " + firstSundayOfNextMonth);

        // 현재 날짜가 포함된 주의 일요일로 조정
        LocalDate previousOrSameSunday = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        System.out.println("이번 주의 일요일(이전 또는 동일): " + previousOrSameSunday);

        // 현재 날짜가 포함된 주의 토요일로 조정
        LocalDate nextOrSameSaturday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
        System.out.println("이번 주의 토요일(다음 또는 동일): " + nextOrSameSaturday);

        // 이번 주의 월요일로 조정
        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        System.out.println("이번 주의 시작 (월요일): " + startOfWeek);

        // 이번 주의 일요일로 조정
        LocalDate endOfWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        System.out.println("이번 주의 끝 (일요일): " + endOfWeek);
    }
}
