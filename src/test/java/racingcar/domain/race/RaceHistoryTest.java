package racingcar.domain.race;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.participant.Car;

class RaceHistoryTest {

    @Test
    void findFinalWinner() {
        //given
        String[] participantNames = {"a", "b", "c"};
        List<Car> cars = Arrays.stream(participantNames)
                .map(Car::from)
                .toList();

        List<RaceScore> firstRoundScores = cars.stream().map(RaceScore::of).toList();
        RaceRecord firstRoundRecord = new RaceRecord(firstRoundScores);

        cars.get(0).move(5);
        List<RaceScore> secondRoundScores = cars.stream().map(RaceScore::of).toList();
        RaceRecord secondRoundRecord = new RaceRecord(secondRoundScores);

        RaceHistory raceHistory = new RaceHistory();
        raceHistory.save(1, firstRoundRecord);
        raceHistory.save(2, secondRoundRecord);

        // when
        List<String> winners = raceHistory.findWinners(2);

        // then
        assertThat(winners).containsOnly("a");
    }
}