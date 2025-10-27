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
        String attemptCountInput = raceInputDto.getAttemptCountInput();

        checkInputIsEmpty(participantsInput);
        checkInputIsEmpty(attemptCountInput);
        checkParticipantsFormat(participantsInput);
    }

    private void checkInputIsEmpty(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new InputValidationException(ErrorCode.EMPTY_INPUT);
        }
    }

    private void checkParticipantsFormat(String input) {
        if (!Pattern.matches(REGEX, input)) {
            throw new InputValidationException(ErrorCode.INVALID_PARTICIPANTS_FORMAT);
        }
    }
}
