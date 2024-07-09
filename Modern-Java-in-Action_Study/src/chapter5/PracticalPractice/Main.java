package chapter5.PracticalPractice;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = TransactionData.getTransactions();

        // 예제 1: 2011년에 일어난 모든 트랜잭션을 찾아 값을 기준으로 오름차순 정렬
        List<Transaction> transactions2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println("2011년의 트랜잭션: " + transactions2011);

        // 예제 2: 거래자가 근무하는 모든 고유한 도시를 나열
        List<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("거래자가 근무하는 도시: " + cities);

        // 예제 3: Cambridge에 근무하는 모든 거래자를 찾아 이름순으로 정렬
        List<Trader> cambridgeTraders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println("Cambridge의 거래자: " + cambridgeTraders);

        // 예제 4: 모든 거래자의 이름을 알파벳순으로 정렬하여 문자열로 연결
        String traderNames = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println("모든 거래자의 이름: " + traderNames);

        // 예제 5: Milan에 거주하는 거래자가 있는가?
        boolean hasMilanTrader = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(trader -> "Milan".equals(trader.getCity()));
        System.out.println("Milan에 거주하는 거래자가 있는가?: " + hasMilanTrader);

        // 예제 6: Cambridge에 거주하는 거래자의 모든 트랜잭션 값을 출력
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // 예제 7: 모든 트랜잭션 중 최대값
        Optional<Integer> highestValue = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compare);
        highestValue.ifPresent(value -> System.out.println("최대 트랜잭션 값: " + value));

        // 예제 8: 모든 트랜잭션 중 최소값
        Optional<Integer> lowestValue = transactions.stream()
                .map(Transaction::getValue)
                .min(Integer::compare);
        lowestValue.ifPresent(value -> System.out.println("최소 트랜잭션 값: " + value));
    }
}
