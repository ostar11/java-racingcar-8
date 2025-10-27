package racingcar.domain.rule;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ErrorCode;
import racingcar.exception.InvalidAttributeException;

class RuleValidatorTest {

    RuleValidator ruleValidator = new RuleValidator();

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 11})
    void numberOutOfRangeCannotPass(int wrongNumber) {
        assertThatThrownBy(() -> ruleValidator.validate(wrongNumber))
                .isInstanceOf(InvalidAttributeException.class)
                .hasMessage(ErrorCode.INVALID_ATTEMPT_COUNT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void numberInRangeCanPass(int number) {
        assertDoesNotThrow(() -> ruleValidator.validate(number));
    }
}