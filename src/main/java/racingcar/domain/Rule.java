package racingcar.domain;

public class Rule {

    private final int attemptCount;

    private Rule(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public static Rule from(int attemptCount) {
        return new Rule(attemptCount);
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
