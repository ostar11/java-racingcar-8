package racingcar.domain;

import java.util.Arrays;
import racingcar.exception.ErrorCode;
import racingcar.exception.InvalidAttributeException;

public class ParticipantFactory {

    public static final String PARTICIPANTS_DELIMITER = ",";

    public Participants build(String participantsInput) {
        String[] participants = splitParticipants(participantsInput);
        checkDuplicateParticipants(participants);
        return Participants.from(participants);
    }

    private static String[] splitParticipants(String participantsInput) {
        return participantsInput.split(PARTICIPANTS_DELIMITER);
    }

    private static void checkDuplicateParticipants(String[] participants) {
        long participantsCount = Arrays.stream(participants).distinct().count();
        if (participantsCount != participants.length) {
            throw new InvalidAttributeException(ErrorCode.DUPLICATE_CAR_NAME);
        }
    }
}
