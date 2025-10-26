package racingcar.domain.participant;

public class ParticipantFactory {

    private final DuplicateValidator duplicateValidator = new DuplicateValidator();
    private final ParticipantParser parser = new ParticipantParser();

    public Participants build(String participantsInput) {
        String[] participants = parser.splitParticipants(participantsInput);

        duplicateValidator.check(participants);
        return Participants.from(participants);
    }

}
