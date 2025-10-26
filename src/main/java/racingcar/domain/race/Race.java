package racingcar.domain.race;

import racingcar.domain.participant.Participants;
import racingcar.domain.race.rule.Rule;

public class Race {

    private final Participants participants;
    private final Rule rule;
    private final Referee referee = new Referee();

    private Race(Participants participants, Rule rule) {
        this.participants = participants;
        this.rule = rule;
    }

    public static Race of(Participants participants, Rule rule) {
        return new Race(participants, rule);
    }

    public RaceResult start() {
        while (rule.isOngoing()) {
            participants.move();
            rule.nextRound();
            referee.saveResult(rule.getCurrentAttemptCount(), participants);
        }

        int totalAttemptCount = rule.getTotalAttemptCount();
        return referee.getResult(totalAttemptCount);
    }
}
