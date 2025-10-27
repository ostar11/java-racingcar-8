package racingcar.domain.rule;

import racingcar.exception.ErrorCode;
import racingcar.exception.InvalidAttributeException;

public class RuleParser {

    public int parse(String attemptCountInput) {
        try {
            return Integer.parseInt(attemptCountInput);
        } catch (NumberFormatException e) {
            throw new InvalidAttributeException(ErrorCode.INVALID_NUMBER_FORMAT);
        }
    }
}
