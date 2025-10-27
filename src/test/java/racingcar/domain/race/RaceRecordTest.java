package racingcar.domain.race;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.participant.Car;

class RaceRecordTest {

    @Test
    void AllParticipantsIsWinnerWhenInitialized() {
        String[] participantNames = {"a", "b", "c"};
        List<RaceScore> raceScores = Arrays.stream(participantNames)
                .map(Car::from)
                .map(RaceScore::of)
                .toList();
        RaceRecord raceRecord = new RaceRecord(raceScores);

        List<String> roundWinners = raceRecord.findRoundWinners();

        assertThat(roundWinners).containsExactlyInAnyOrder("a", "b", "c");
    }
}