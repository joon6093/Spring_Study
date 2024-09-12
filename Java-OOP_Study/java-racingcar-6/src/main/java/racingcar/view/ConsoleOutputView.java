package racingcar.view;

import java.util.List;
import racingcar.dto.RaceDto;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printRaceStatus(RaceDto raceDto) {
        raceDto.getCarDtos()
                .forEach(carDto -> System.out.println(carDto.getName() + " : " + "-".repeat(carDto.getPosition())));
    }

    @Override
    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
