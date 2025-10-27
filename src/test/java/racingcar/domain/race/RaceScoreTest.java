package racingcar.domain.race;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.participant.Car;

class RaceScoreTest {

    @Test
    void carPositionIsInitializedAsZero() {
        String name = "java";
        Car car = Car.from(name);
        RaceScore raceScore = RaceScore.of(car);

        int initializedPosition = 0;

        Assertions.assertThat(raceScore.isSamePosition(initializedPosition)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void carPositionIsNotInitializedAboveZero(int position) {
        String name = "java";
        Car car = Car.from(name);
        RaceScore raceScore = RaceScore.of(car);

        Assertions.assertThat(raceScore.isSamePosition(position)).isFalse();
    }
  
}