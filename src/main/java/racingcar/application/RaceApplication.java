package racingcar.application;

import racingcar.domain.race.Race;
import racingcar.domain.race.RaceResult;
import racingcar.domain.reception.InformationDesk;
import racingcar.io.InputReader;
import racingcar.io.OutputWriter;
import racingcar.io.RaceInputDto;

public class RaceApplication {

    private final InputReader inputReader;
    private final InformationDesk informationDesk;
    private final OutputWriter outputWriter;

    public RaceApplication(InputReader inputReader, InformationDesk informationDesk, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.informationDesk = informationDesk;
        this.outputWriter = outputWriter;
    }

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
