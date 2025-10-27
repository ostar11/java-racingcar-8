package racingcar.util;

import java.util.List;
import java.util.Map;
import racingcar.domain.race.RaceRecord;
import racingcar.domain.race.RaceResult;
import racingcar.domain.race.RaceScore;

public class RaceResultMapper {

    private static final String POSITION_CHARACTER = "-";
    private static final String NEW_LINE_CHARACTER = "\n";
    private static final String WINNER_DELIMITER = ", ";

    public static String formatRecord(RaceResult result) {
        StringBuilder sb = new StringBuilder();

        int attemptCount = result.getAttemptCount();
        Map<Integer, RaceRecord> raceHistory = result.getRaceHistory();

        for (int roundNumber = 1; roundNumber <= attemptCount; roundNumber++) {
            RaceRecord raceRecord = raceHistory.get(roundNumber);

            List<RaceScore> raceScores = raceRecord.getRaceScores();
            for (RaceScore raceScore : raceScores) {
                sb.append(raceScore.getName()).append(" : ");
                sb.append(POSITION_CHARACTER.repeat(raceScore.getPosition()));
                sb.append(NEW_LINE_CHARACTER);
            }
            sb.append(NEW_LINE_CHARACTER);
        }

        return sb.toString();
    }

    public static String formatWinners(RaceResult result) {
        return String.join(WINNER_DELIMITER, result.getWinners());
    }
}
