package racingcar.domain.rule;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ErrorCode;
import racingcar.exception.InvalidAttributeException;

class RuleParserTest {

    RuleParser parser = new RuleParser();

    @ParameterizedTest
    @ValueSource(strings = {"abc", "12 ", " 1", " 1 "})
    void WrongStringCannotMakeNumber(String input) {
        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(InvalidAttributeException.class)
                .hasMessage(ErrorCode.INVALID_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "100", "-1", "0"})
    void parsingNumberFormatStringSuccess(String input) {
        assertDoesNotThrow(() -> parser.parse(input));
    }
}