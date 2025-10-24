package racingcar;

public class RaceApplication {

    private final InputReader inputReader = new InputReader();
    private final InformationDesk informationDesk = new InformationDesk();

    public void start() {
        RaceInputDto raceInputDto = inputReader.read();
        Race race = informationDesk.register(raceInputDto);
    }
}
