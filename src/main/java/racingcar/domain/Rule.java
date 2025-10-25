package racingcar.domain;

import racingcar.exception.ErrorCode;
import racingcar.exception.InvalidAttributeException;

public class Rule {

    private static final int MAX_RACE_COUNT = 10;
    private final int attemptCount;

    private Rule(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public static Rule from(String attemptCountInput) {
        int attemptCount = Integer.parseInt(attemptCountInput);

        if (attemptCount <= 0 || attemptCount > MAX_RACE_COUNT) {
            throw new InvalidAttributeException(ErrorCode.INVALID_ATTEMPT_COUNT);
        }

        return new Rule(attemptCount);
    }
}
