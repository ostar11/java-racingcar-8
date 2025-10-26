package racingcar.domain;

import java.util.List;

public class RaceRecord {

    private final List<RaceScore> raceScores;

    public RaceRecord(List<RaceScore> raceScores) {
        this.raceScores = raceScores;
    }

    public List<String> findRoundWinners() {
        int maxScore = getMaxScore();

        return raceScores.stream()
                .filter(raceScore -> raceScore.isMaxScore(maxScore))
                .map(RaceScore::getName)
                .toList();
    }

    public int getMaxScore() {
        return raceScores.stream()
                .map(RaceScore::getPosition)
                .reduce(0, Integer::max);
    }

    public List<RaceScore> getRaceScores() {
        return raceScores;
    }
}
