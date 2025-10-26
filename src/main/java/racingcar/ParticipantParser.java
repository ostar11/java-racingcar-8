package racingcar;

public class ParticipantParser {

    private static final String PARTICIPANTS_DELIMITER = ",";

    public String[] splitParticipants(String participantsInput) {
        return participantsInput.split(PARTICIPANTS_DELIMITER);
    }
}
