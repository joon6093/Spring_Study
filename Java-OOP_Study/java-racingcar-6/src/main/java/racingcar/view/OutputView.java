package racingcar.view;

import java.util.List;
import racingcar.dto.RaceDto;

public interface OutputView {
    void printRaceStatus(RaceDto raceDto);

    void printWinners(List<String> winners);
}
