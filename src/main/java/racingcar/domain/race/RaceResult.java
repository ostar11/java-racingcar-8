package racingcar.domain.race;

import java.util.List;
import java.util.Map;

public class RaceResult {

    private final int attemptCount;
    private final Map<Integer, RaceRecord> raceHistory;
    private final List<String> winners;

    public RaceResult(int attemptCount, Map<Integer, RaceRecord> raceHistory, List<String> winners) {
        this.attemptCount = attemptCount;
        this.raceHistory = raceHistory;
        this.winners = winners;
    }

    public static RaceResult of(int lastPeriod, RaceHistory raceHistory) {
        Map<Integer, RaceRecord> roundRecords = raceHistory.getRoundRecords();
        List<String> winners = raceHistory.findWinners(lastPeriod);

        return new RaceResult(lastPeriod, roundRecords, winners);
    }

    public Map<Integer, RaceRecord> getRaceHistory() {
        return raceHistory;
    }

    public List<String> getWinners() {
        return winners;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
