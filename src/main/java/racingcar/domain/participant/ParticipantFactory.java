package racingcar.domain.participant;

public class ParticipantFactory {

    private final ParticipantsValidator validator = new ParticipantsValidator();
    private final ParticipantParser parser = new ParticipantParser();

    public Participants build(String participantsInput) {
        String[] participants = parser.splitParticipants(participantsInput);
        validator.checkDuplicateParticipants(participants);
        return Participants.from(participants);
    }

}
