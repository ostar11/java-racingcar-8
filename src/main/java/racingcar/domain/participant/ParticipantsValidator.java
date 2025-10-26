package racingcar.domain.participant;

import java.util.Arrays;
import racingcar.exception.ErrorCode;
import racingcar.exception.InvalidAttributeException;

public class ParticipantsValidator {

    public void checkDuplicateParticipants(String[] participants) {
        long participantsCount = Arrays.stream(participants).distinct().count();

        if (participantsCount != participants.length) {
            throw new InvalidAttributeException(ErrorCode.DUPLICATE_CAR_NAME);
        }
    }
}
