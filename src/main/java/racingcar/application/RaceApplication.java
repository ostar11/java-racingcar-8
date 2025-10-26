package racingcar.application;

import racingcar.domain.InformationDesk;
import racingcar.domain.Race;
import racingcar.domain.RaceResult;
import racingcar.io.InputReader;
import racingcar.io.OutputWriter;
import racingcar.io.RaceInputDto;

public class RaceApplication {

    private final InputReader inputReader = new InputReader();
    private final InformationDesk informationDesk = new InformationDesk();
    private final OutputWriter outputWriter = new OutputWriter();

    public void start() {
        try {
            RaceInputDto raceInputDto = inputReader.read();
            Race race = informationDesk.register(raceInputDto);
            RaceResult result = race.start();
            outputWriter.write(result);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
