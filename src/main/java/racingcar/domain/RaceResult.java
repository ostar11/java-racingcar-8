package racingcar.domain;

import java.util.List;
import java.util.Map;

public class RaceResult {

    private final Map<Integer, List<RaceScore>> totalScore;
    private final List<String> winners;

    public RaceResult(Map<Integer, List<RaceScore>> totalScore, List<String> winners) {
        this.totalScore = totalScore;
        this.winners = winners;
    }
}
