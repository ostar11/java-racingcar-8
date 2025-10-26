package racingcar.io;

import java.util.Map;
import java.util.stream.Collectors;
import racingcar.domain.RaceRecord;
import racingcar.domain.RaceResult;

public class OutputWriter {

    public void write(RaceResult result) {
        writeTotalScore(result);
        writeWinners(result);
    }

    private static void writeTotalScore(RaceResult result) {
        System.out.println("실행 결과");

        int attemptCount = result.getAttemptCount();
        Map<Integer, RaceRecord> raceHistory = result.getRaceHistory();

        for (int period = 1; period <= attemptCount; period++) {
            RaceRecord raceRecord = raceHistory.get(period);
            // 결과 출력
        }
    }

    private static void writeWinners(RaceResult result) {
        String winnerString = getWinners(result);
        System.out.println("최종 우승자 : " + winnerString);
    }

    private static String getWinners(RaceResult result) {
        return result.getWinners().stream().collect(Collectors.joining(", "));
    }
}
