package racingcar.domain.race;

import java.util.List;

public class RaceRecord {

    private final List<RaceScore> raceScores;

    public RaceRecord(List<RaceScore> raceScores) {
        this.raceScores = raceScores;
    }

    public List<String> findRoundWinners() {
        int maxScore = findMaxScore();

        return raceScores.stream()
                .filter(raceScore -> raceScore.isSamePosition(maxScore))
                .map(RaceScore::getName)
                .toList();
    }

    public int findMaxScore() {
        return raceScores.stream()
                .map(RaceScore::getPosition)
                .reduce(0, Integer::max);
    }

    public List<RaceScore> getRaceScores() {
        return raceScores;
    }
}
