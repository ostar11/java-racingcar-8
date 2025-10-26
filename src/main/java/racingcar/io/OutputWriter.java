package racingcar.io;

import racingcar.domain.RaceResult;
import racingcar.util.RaceResultMapper;

public class OutputWriter {

    public void write(RaceResult result) {
        writeTotalScore(result);
        writeWinners(result);
    }

    private void writeTotalScore(RaceResult result) {
        System.out.println("실행 결과");

        String totalRecord = RaceResultMapper.formatRecord(result);
        System.out.println(totalRecord);
    }

    private void writeWinners(RaceResult result) {
        String winners = RaceResultMapper.formatWinners(result);
        System.out.println("최종 우승자 : " + winners);
    }
}
