package racingcar.io;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.domain.RaceResult;
import racingcar.domain.RaceScore;

public class OutputWriter {

    public void write(RaceResult result) {
        writeTotalScore(result);
        writeWinners(result);
    }

    private static void writeTotalScore(RaceResult result) {
        System.out.println("실행 결과");

        int attemptCount = result.getAttemptCount();
        Map<Integer, List<RaceScore>> totalScore = result.getTotalScore();

        for (int period = 1; period <= attemptCount; period++) {
            List<RaceScore> raceScores = totalScore.get(period);
            for (RaceScore raceScore : raceScores) {
                System.out.println(raceScore.toView());
            }
            System.out.println();
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
