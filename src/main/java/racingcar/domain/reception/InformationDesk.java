package racingcar.domain.reception;

import racingcar.domain.participant.ParticipantFactory;
import racingcar.domain.participant.Participants;
import racingcar.domain.race.Race;
import racingcar.domain.rule.Rule;
import racingcar.domain.rule.RuleFactory;
import racingcar.io.RaceInputDto;

public class InformationDesk {

    private final Inspector inspector;
    private final ParticipantFactory participantFactory;
    private final RuleFactory ruleFactory;

    public InformationDesk(Inspector inspector, ParticipantFactory participantFactory, RuleFactory ruleFactory) {
        this.inspector = inspector;
        this.participantFactory = participantFactory;
        this.ruleFactory = ruleFactory;
    }

    public Race register(RaceInputDto raceInputDto) {
        inspector.check(raceInputDto);

        Participants participants = participantFactory.build(raceInputDto.getParticipantsInput());
        Rule rule = ruleFactory.build(raceInputDto.getAttemptCountInput());

        return Race.of(participants, rule);
    }
}
