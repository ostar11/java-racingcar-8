package racingcar.domain.participant;

public class ParticipantFactory {

    private final ParticipantValidator participantValidator;
    private final ParticipantParser parser;

    public ParticipantFactory(ParticipantValidator participantValidator, ParticipantParser parser) {
        this.participantValidator = participantValidator;
        this.parser = parser;
    }

    public Participants build(String participantsInput) {
        String[] participants = parser.splitParticipants(participantsInput);

        participantValidator.check(participants);
        return Participants.from(participants);
    }

}
