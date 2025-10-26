package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {

    private final Map<Integer, RaceRecord> raceHistory = new HashMap<>();

    public void saveResult(int attempt, Participants participants) {
        RaceRecord raceRecord = participants.getCurrentScores();
        raceHistory.put(attempt, raceRecord);
    }

    public RaceResult getResult(int lastPeriod) {
        RaceRecord lastRaceRecord = raceHistory.get(lastPeriod);
        List<String> winners = lastRaceRecord.findWinners();

        return new RaceResult(lastPeriod, raceHistory, winners);
    }
}
