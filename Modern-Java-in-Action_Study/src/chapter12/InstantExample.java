package chapter12;

import java.time.Instant;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class InstantExample {
    public static void main(String[] args) {
        // 현재 시각의 Instant 객체 생성
        Instant now = Instant.now();
        System.out.println("현재 시각: " + now);

        // 특정 시각의 Instant 객체 생성
        Instant epoch = Instant.ofEpochSecond(0);
        System.out.println("Epoch 시각: " + epoch);

        // Instant 객체에서 10초 더하기
        Instant tenSecondsLater = now.plusSeconds(10);
        System.out.println("현재 시각에서 10초 후: " + tenSecondsLater);

        // 두 Instant 객체의 차이 계산
        Duration duration = Duration.between(epoch, now);
        System.out.println("Epoch 시각부터 현재 시각까지의 시간: " + duration.getSeconds() + " 초");

        // Instant 객체에서 1일 빼기
        Instant oneDayBefore = now.minus(1, ChronoUnit.DAYS);
        System.out.println("현재 시각에서 1일 전: " + oneDayBefore);

        // 특정 시각과 비교
        boolean isAfterEpoch = now.isAfter(epoch);
        System.out.println("현재 시각이 Epoch 시각 이후인가? " + isAfterEpoch);
    }
}
