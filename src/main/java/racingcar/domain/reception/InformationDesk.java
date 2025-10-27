package racingcar.domain.reception;

import racingcar.domain.rule.RuleFactory;
import racingcar.domain.participant.ParticipantFactory;
import racingcar.domain.participant.Participants;
import racingcar.domain.race.Race;
import racingcar.domain.rule.Rule;
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
