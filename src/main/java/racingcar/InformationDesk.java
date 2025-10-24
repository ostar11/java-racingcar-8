package racingcar;

public class InformationDesk {

    private final Inspector inspector = new Inspector();

    public Race register(RaceInputDto raceInputDto) {
        inspector.check(raceInputDto);
        return null;
    }
}
