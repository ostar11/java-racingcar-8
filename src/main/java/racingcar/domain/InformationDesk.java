package racingcar.domain;

import racingcar.io.RaceInputDto;

public class InformationDesk {

    private final Inspector inspector = new Inspector();
    private final ParticipantFactory participantFactory = new ParticipantFactory();

    public Race register(RaceInputDto raceInputDto) {
        inspector.check(raceInputDto);

        Participants participants = participantFactory.build(raceInputDto.getParticipantsInput());
        Rule rule = Rule.from(raceInputDto.getAttemptCountInput());

        return Race.of(participants, rule);
    }
}
