package racingcar.domain;

public class RaceScore {

    private final String name;
    private final int position;

    private RaceScore(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static RaceScore of(String name, int position) {
        return new RaceScore(name, position);
    }
}
