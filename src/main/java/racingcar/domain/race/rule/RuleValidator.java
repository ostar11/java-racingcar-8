package racingcar.domain.race.rule;

import racingcar.exception.ErrorCode;
import racingcar.exception.InvalidAttributeException;
import racingcar.validator.Validator;

public class RuleValidator implements Validator<Integer> {

    private static final int MIN_RACE_COUNT = 1;
    private static final int MAX_RACE_COUNT = 10;

    @Override
    public void check(Integer attemptCount) {
        if (attemptCount < MIN_RACE_COUNT || attemptCount > MAX_RACE_COUNT) {
            throw new InvalidAttributeException(ErrorCode.INVALID_ATTEMPT_COUNT);
        }
    }
}
