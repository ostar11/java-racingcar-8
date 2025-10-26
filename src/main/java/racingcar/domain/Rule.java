package racingcar.domain;

public class Rule {

    private final int totalAttemptCount;
    private int currentAttemptCount;

    private Rule(int totalAttemptCount) {
        this.totalAttemptCount = totalAttemptCount;
        this.currentAttemptCount = 0;
    }

    public static Rule from(int attemptCount) {
        return new Rule(attemptCount);
    }

    public boolean isOngoing() {
        return currentAttemptCount < totalAttemptCount;
    }

    public void nextRound() {
        currentAttemptCount++;
    }

    public int getTotalAttemptCount() {
        return totalAttemptCount;
    }

    public int getCurrentAttemptCount() {
        return currentAttemptCount;
    }
}
