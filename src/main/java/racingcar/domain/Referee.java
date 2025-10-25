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

    public RaceResult getResult(int lastPeriod) {
        List<RaceScore> raceScores = totalScore.get(lastPeriod);

        Integer maxScore = raceScores.stream()
                .map(RaceScore::getPosition)
                .reduce(0, Integer::max);

        List<String> winners = raceScores.stream()
                .filter(raceScore -> raceScore.isMaxScore(maxScore))
                .map(RaceScore::getName)
                .toList();

        return new RaceResult(totalScore, winners);
    }
}
