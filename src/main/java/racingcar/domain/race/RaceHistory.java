package racingcar.domain.race;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaceHistory {

    private final Map<Integer, RaceRecord> roundRecords = new HashMap<>();

    public void save(int attempt, RaceRecord raceRecord) {
        roundRecords.put(attempt, raceRecord);
    }

    public List<String> findWinners(int lastPeriod) {
        RaceRecord lastRaceRecord = roundRecords.get(lastPeriod);
        return lastRaceRecord.findRoundWinners();
    }

    public Map<Integer, RaceRecord> getRoundRecords() {
        return roundRecords;
    }
}
