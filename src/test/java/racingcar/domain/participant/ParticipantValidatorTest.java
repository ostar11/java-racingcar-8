package racingcar.domain.participant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorCode;
import racingcar.exception.InvalidAttributeException;

class ParticipantValidatorTest {

    static ParticipantValidator participantValidator = new ParticipantValidator();

    @DisplayName("중복된 문자열을 가지면 예외가 발생한다.")
    @Test
    void duplicateStringArrayValidate() {
        String[] strArr = new String[]{"abc", "abc"};

        Assertions.assertThatThrownBy(() -> participantValidator.validate(strArr))
                .isInstanceOf(InvalidAttributeException.class)
                .hasMessage(ErrorCode.DUPLICATE_CAR_NAME.getMessage());
    }

}