package racingcar.domain.participant;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.race.RaceRecord;
import racingcar.domain.race.RaceScore;

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
            int randomNumber = Randoms.pickNumberInRange(0, 9);
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
