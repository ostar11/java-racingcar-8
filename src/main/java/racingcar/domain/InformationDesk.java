package racingcar.domain;

import racingcar.RuleFactory;
import racingcar.io.RaceInputDto;

public class InformationDesk {

    private final Inspector inspector = new Inspector();
    private final ParticipantFactory participantFactory = new ParticipantFactory();
    private final RuleFactory ruleFactory = new RuleFactory();

    public Race register(RaceInputDto raceInputDto) {
        inspector.check(raceInputDto);

        Participants participants = participantFactory.build(raceInputDto.getParticipantsInput());
        Rule rule = ruleFactory.build(raceInputDto.getAttemptCountInput());

        return Race.of(participants, rule);
    }
}
