package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.exception.ErrorCode;
import racingcar.exception.InvalidAttributeException;

public class Participants {

    public static final String DELIMITER = ",";

    private final List<Car> cars;

    private Participants(List<Car> cars) {
        this.cars = cars;
    }

    public static Participants from(String participantsInput) {
        String[] splitParticipants = participantsInput.split(DELIMITER);
        List<Car> cars = Arrays.stream(splitParticipants)
                .map(Car::from)
                .toList();

        if (splitParticipants.length != cars.size()) {
            throw new InvalidAttributeException(ErrorCode.DUPLICATE_CAR_NAME);
        }

        return new Participants(cars);
    }
}
