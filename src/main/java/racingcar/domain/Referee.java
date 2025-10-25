package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {

    private final Map<Integer, List<RaceScore>> totalScore = new HashMap<>();

    public void saveResult(int attempt, Participants participants) {
        List<RaceScore> raceScores = participants.getCurrentPositions();
        totalScore.put(attempt, raceScores);
    }
}
