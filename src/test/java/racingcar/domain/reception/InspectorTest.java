package racingcar.domain.reception;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ErrorCode;
import racingcar.exception.InputValidationException;
import racingcar.io.RaceInputDto;

class InspectorTest {

    Inspector inspector = new Inspector();

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", "가,a"})
    void participantsInputPass(String participantNames) {
        RaceInputDto raceInputDto = new RaceInputDto(participantNames, "1");
        assertDoesNotThrow(() -> inspector.check(raceInputDto));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a , b , c", "가1,a", "abc*,||"})
    void wrongParticipantsInputCannotPass(String wrongParticipantNames) {
        RaceInputDto raceInputDto = new RaceInputDto(wrongParticipantNames, "1");
        Assertions.assertThatThrownBy(() -> inspector.check(raceInputDto))
                .isInstanceOf(InputValidationException.class)
                .hasMessage(ErrorCode.INVALID_PARTICIPANTS_FORMAT.getMessage());
    }

    @Test
    void emptyParticipantsInputCannotPass() {
        RaceInputDto raceInputDto = new RaceInputDto("", "1");
        Assertions.assertThatThrownBy(() -> inspector.check(raceInputDto))
                .isInstanceOf(InputValidationException.class)
                .hasMessage(ErrorCode.EMPTY_INPUT.getMessage());
    }
}