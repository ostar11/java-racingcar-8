package racingcar.domain.reception;

import java.util.Objects;
import java.util.regex.Pattern;
import racingcar.exception.ErrorCode;
import racingcar.exception.InputValidationException;
import racingcar.io.RaceInputDto;

public class Inspector {

    private static final String REGEX = "^[a-zA-Zㄱ-ㅎ가-힣,]*$";

    public void check(RaceInputDto raceInputDto) {
        String participantsInput = raceInputDto.getParticipantsInput();

        checkInputIsEmpty(participantsInput);
        checkParticipantsFormat(participantsInput);
    }

    private void checkInputIsEmpty(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new InputValidationException(ErrorCode.EMPTY_INPUT);
        }
    }

    private static void checkParticipantsFormat(String participantsInput) {
        if (!Pattern.matches(REGEX, participantsInput)) {
            throw new InputValidationException(ErrorCode.INVALID_PARTICIPANTS_FORMAT);
        }
    }
}
