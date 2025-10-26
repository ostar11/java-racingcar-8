package racingcar.domain;

public class Referee {

    private final RaceHistory raceHistory;

    public Referee() {
        this.raceHistory = new RaceHistory();
    }

    public void saveResult(int attempt, Participants participants) {
        RaceRecord raceRecord = participants.getCurrentScores();
        raceHistory.save(attempt, raceRecord);
    }

    public RaceResult getResult(int lastPeriod) {
        return RaceResult.of(lastPeriod, raceHistory);
    }
}
