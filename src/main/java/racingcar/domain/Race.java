package racingcar.domain;

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
        int attemptCount = rule.getAttemptCount();

        for (int i = 1; i <= attemptCount; i++) {
            participants.move();
            referee.saveResult(i, participants);
        }

        return referee.getResult(attemptCount);
    }
}
