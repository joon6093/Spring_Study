package racingcar.dto;

import java.util.List;
import racingcar.model.Race;

public class RaceDto {
    private final List<CarDto> carDtos;

    public RaceDto(List<CarDto> carDtos) {
        this.carDtos = carDtos;
    }

    public List<CarDto> getCarDtos() {
        return carDtos;
    }

    public static RaceDto from(Race race) {
        return new RaceDto(race.getCars().stream()
                .map(CarDto::from)
                .toList());
    }
}
