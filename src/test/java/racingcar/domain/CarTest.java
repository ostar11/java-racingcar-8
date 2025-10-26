package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ErrorCode;
import racingcar.exception.InvalidAttributeException;

class CarTest {

    @DisplayName("4보다 크면 움직인다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void MoveWhenNumberIsInRange(int value) {
        Car car = Car.from("test");

        car.move(value);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("4보다 작으면 움직이지 않는다.")
    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest
    void stayWhenNumberIsOutOfRange(int value) {
        Car car = Car.from("test");

        car.move(value);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("이름 길이가 5보다 크면 예외 발생")
    @ValueSource(strings = {"abcdef", "abcabcabc"})
    @ParameterizedTest
    void nameLengthOverFiveCannotMakeCar(String name) {
        assertThatThrownBy(() -> Car.from(name))
                .isInstanceOf(InvalidAttributeException.class)
                .hasMessage(ErrorCode.INVALID_CAR_NAME.getMessage());
    }

    @DisplayName("이름 길이가 5보다 작으면 예외 발생")
    @ValueSource(strings = {"a", "ab", "abc", "abcd"})
    @ParameterizedTest
    void nameLengthInRangeCanMakeCar(String name) {
        Car car = Car.from(name);

        assertThat(car.getName()).isEqualTo(name);
    }
}