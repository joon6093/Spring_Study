package chapter6;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.averagingInt;

public class ReduceAndCollectExamples {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // 1. Collect를 사용한 개수 계산
        long countWithCollect = numbers.stream().collect(Collectors.counting());
        System.out.println("Collect를 사용한 개수: " + countWithCollect);

        // 2. Reduce를 사용한 개수 계산
        long countWithReduce = numbers.stream().reduce(0L, (count, n) -> count + 1, Long::sum);
        System.out.println("Reduce를 사용한 개수: " + countWithReduce);

        // 3. Collect를 사용한 최댓값 계산
        Optional<Integer> maxWithCollect = numbers.stream().collect(Collectors.maxBy(Integer::compareTo));
        maxWithCollect.ifPresent(max -> System.out.println("Collect를 사용한 최댓값: " + max));

        // 4. Reduce를 사용한 최댓값 계산
        Optional<Integer> maxWithReduce = numbers.stream().reduce(Integer::max);
        maxWithReduce.ifPresent(max -> System.out.println("Reduce를 사용한 최댓값: " + max));

        // 5. Collect를 사용한 최솟값 계산
        Optional<Integer> minWithCollect = numbers.stream().collect(Collectors.minBy(Integer::compareTo));
        minWithCollect.ifPresent(min -> System.out.println("Collect를 사용한 최솟값: " + min));

        // 6. Reduce를 사용한 최솟값 계산
        Optional<Integer> minWithReduce = numbers.stream().reduce(Integer::min);
        minWithReduce.ifPresent(min -> System.out.println("Reduce를 사용한 최솟값: " + min));

        // 7. Collect를 사용한 합계 계산
        double sumWithCollect = numbers.stream().collect(averagingInt(Integer::intValue));
        System.out.println("Collect를 사용한 합계: " + sumWithCollect);

        // 8. Reduce를 사용한 합계 계산
        Optional<Integer> sumWithReduce = numbers.stream().reduce(Integer::sum);
        sumWithReduce.ifPresent(sum -> System.out.println("Collect를 사용한 합계: " + sum));

        // 9. Collect를 사용한 요약 통계
        IntSummaryStatistics statsWithCollect = numbers.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("Collect를 사용한 요약 통계: " + statsWithCollect);

        // 10. Reduce를 사용한 요약 통계 (직접 구현)
        IntSummaryStatistics statsWithReduce = numbers.stream().reduce(
                new IntSummaryStatistics(),
                (stats, num) -> {
                    stats.accept(num);
                    return stats;
                },
                (stats1, stats2) -> {
                    stats1.combine(stats2);
                    return stats1;
                }
        );
        System.out.println("Reduce를 사용한 요약 통계: " + statsWithReduce);
    }
}
