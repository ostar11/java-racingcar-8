package racingcar.domain.rule;

import racingcar.common.validator.Validator;
import racingcar.exception.ErrorCode;
import racingcar.exception.InvalidAttributeException;

public class RuleValidator implements Validator<Integer> {

    private static final int MIN_RACE_COUNT = 1;
    private static final int MAX_RACE_COUNT = 10;

    @Override
    public void validate(Integer attemptCount) {
        if (attemptCount < MIN_RACE_COUNT || attemptCount > MAX_RACE_COUNT) {
            throw new InvalidAttributeException(ErrorCode.INVALID_ATTEMPT_COUNT);
        }
    }
}
