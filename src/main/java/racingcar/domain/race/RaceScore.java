package racingcar.domain.race;

import racingcar.domain.participant.Car;

public class RaceScore {

    private final String name;
    private final int position;

    private RaceScore(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static RaceScore of(Car car) {
        return new RaceScore(car.getName(), car.getPosition());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isMaxScore(int maxScore) {
        return position == maxScore;
    }

    public String toView() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        String position = sb.toString();
        return name + " : " + position;
    }
}
