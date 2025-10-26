package racingcar.domain;

import java.util.List;
import java.util.Map;

public class RaceResult {

    private final int attemptCount;
    private final Map<Integer, List<RaceScore>> totalScore;
    private final List<String> winners;

    public RaceResult(int attemptCount, Map<Integer, List<RaceScore>> totalScore, List<String> winners) {
        this.attemptCount = attemptCount;
        this.totalScore = totalScore;
        this.winners = winners;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public Map<Integer, List<RaceScore>> getTotalScore() {
        return totalScore;
    }

    public List<String> getWinners() {
        return winners;
    }
}
