package racingcar.domain.participant;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.race.RaceRecord;
import racingcar.domain.race.RaceScore;
import racingcar.util.NumberGenerator;

public class Participants {

    private final List<Car> cars;

    private Participants(List<Car> cars) {
        this.cars = cars;
    }

    public static Participants from(String[] participants) {
        List<Car> cars = Arrays.stream(participants)
                .map(Car::from)
                .toList();

        return new Participants(cars);
    }

    public void move() {
        for (Car car : cars) {
            int randomNumber = NumberGenerator.generateRandomNumber();
            car.move(randomNumber);
        }
    }

    public RaceRecord getCurrentScores() {
        List<RaceScore> raceScores = cars.stream()
                .map(RaceScore::of)
                .toList();
        return new RaceRecord(raceScores);
    }
}
