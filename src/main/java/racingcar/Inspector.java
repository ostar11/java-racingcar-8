package racingcar;

import java.util.Objects;

public class Inspector {

    public void check(RaceInputDto raceInputDto) {
        String participantsInput = raceInputDto.getParticipantsInput();
        String attemptCountInput = raceInputDto.getAttemptCountInput();

        checkParticipantsIsEmpty(participantsInput);
        checkAttemptCountIsEmpty(attemptCountInput);
    }

    private void checkParticipantsIsEmpty(String participantsInput) {
        checkInputIsEmpty(participantsInput);
    }

    private void checkAttemptCountIsEmpty(String attemptCountInput) {
        checkInputIsEmpty(attemptCountInput);
    }

    private void checkInputIsEmpty(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new InputValidationException(ErrorCode.EMPTY_INPUT);
        }
    }

}
