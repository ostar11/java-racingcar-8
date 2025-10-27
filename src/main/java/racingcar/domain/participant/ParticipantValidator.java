package racingcar.domain.participant;

import java.util.Arrays;
import racingcar.exception.ErrorCode;
import racingcar.exception.InvalidAttributeException;
import racingcar.common.validator.Validator;

public class ParticipantValidator implements Validator<String[]> {

    @Override
    public void validate(String[] participants) {
        long participantsCount = Arrays.stream(participants).distinct().count();

        if (participantsCount != participants.length) {
            throw new InvalidAttributeException(ErrorCode.DUPLICATE_CAR_NAME);
        }
    }
}
