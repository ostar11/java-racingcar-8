package racingcar.application;

import racingcar.domain.InformationDesk;
import racingcar.domain.Race;
import racingcar.io.InputReader;
import racingcar.io.RaceInputDto;

public class RaceApplication {

    private final InputReader inputReader = new InputReader();
    private final InformationDesk informationDesk = new InformationDesk();

    public void start() {
        RaceInputDto raceInputDto = inputReader.read();
        Race race = informationDesk.register(raceInputDto);
        race.start();
    }
}
