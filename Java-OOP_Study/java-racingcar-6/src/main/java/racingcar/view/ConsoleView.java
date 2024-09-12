package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import racingcar.dto.RaceDto;

public class ConsoleView implements InputView, OutputView {
    @Override
    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        try {
            return Arrays.asList(input.split(","));
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 구분해야 합니다.");
        }
    }

    @Override
    public int inputNumberOfAttempts() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    @Override
    public void printRaceStatus(RaceDto raceDto) {
        System.out.println("실행 결과");
        raceDto.getCarDtos()
                .forEach(carDto -> {
                    System.out.println(carDto.getName() + " : " + "-".repeat(carDto.getPosition()));
                    System.out.println();
                });
    }

    @Override
    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
