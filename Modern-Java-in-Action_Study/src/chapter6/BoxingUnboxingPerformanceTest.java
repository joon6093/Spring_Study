package chapter6;

public class BoxingUnboxingPerformanceTest {

    public static void main(String[] args) {
        // 1. 자동 박싱을 포함한 연산
        long t1 = System.currentTimeMillis();

        Long sum1 = 0L; // 래퍼 객체로 오토 박싱으로 정수 값을 저장

        for (long i = 0; i < 1000000; i++) {
            sum1 += i; // 오토 박싱과 언박싱이 반복적으로 발생
        }

        System.out.println("자동 박싱을 포함한 연산 처리 시간: " + (System.currentTimeMillis() - t1) + " ms");

        // 2. 기본형 타입 간 연산
        long t2 = System.currentTimeMillis();

        long sum2 = 0L; // 기본형 정수 타입인 long 자료형에 정수 저장

        for (long i = 0; i < 1000000; i++) {
            sum2 += i;
        }

        System.out.println("기본형 타입 간 연산 처리 시간: " + (System.currentTimeMillis() - t2) + " ms");

        // 3. 명시적 변환을 포함한 연산
        long t3 = System.currentTimeMillis();

        Long sum3 = 0L; // 래퍼 객체로 정수 값을 저장

        for (long i = 0; i < 1000000; i++) {
            sum3 = Long.valueOf(sum3.longValue() + i); // 명시적 언박싱과 박싱 발생
        }

        System.out.println("명시적 변환을 포함한 연산 처리 시간: " + (System.currentTimeMillis() - t3) + " ms");
    }
}
