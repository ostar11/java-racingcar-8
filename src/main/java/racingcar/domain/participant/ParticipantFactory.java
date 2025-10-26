package racingcar.domain.participant;

public class ParticipantFactory {

    private final ParticipantValidator participantValidator = new ParticipantValidator();
    private final ParticipantParser parser = new ParticipantParser();

    public Participants build(String participantsInput) {
        String[] participants = parser.splitParticipants(participantsInput);

        participantValidator.check(participants);
        return Participants.from(participants);
    }

}
