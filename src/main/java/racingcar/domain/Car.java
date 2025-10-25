package racingcar.domain;

import racingcar.exception.ErrorCode;
import racingcar.exception.InvalidAttributeException;

public class Car {

    private String name;
    private int position;

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new InvalidAttributeException(ErrorCode.INVALID_CAR_NAME);
        }
        return new Car(name, 0);
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) position++;
    }
}
