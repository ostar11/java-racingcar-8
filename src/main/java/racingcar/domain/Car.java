package racingcar.domain;

import racingcar.exception.ErrorCode;
import racingcar.exception.InvalidAttributeException;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_MOVABLE_NUMBER = 4;

    private String name;
    private int position;

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
            throw new InvalidAttributeException(ErrorCode.INVALID_CAR_NAME);
        }
        return new Car(name, 0);
    }

    public void move(int number) {
        if (number >= MIN_MOVABLE_NUMBER) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
