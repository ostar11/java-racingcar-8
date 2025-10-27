package racingcar.domain.reception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.participant.ParticipantFactory;
import racingcar.domain.participant.ParticipantParser;
import racingcar.domain.participant.ParticipantValidator;
import racingcar.domain.rule.RuleFactory;
import racingcar.domain.rule.RuleParser;
import racingcar.domain.rule.RuleValidator;
import racingcar.exception.InputValidationException;
import racingcar.exception.InvalidAttributeException;
import racingcar.io.RaceInputDto;

class InformationDeskTest {

    static InformationDesk informationDesk;

    @BeforeAll
    static void setup() {
        Inspector inspector = new Inspector();

        ParticipantValidator participantValidator = new ParticipantValidator();
        ParticipantParser participantParser = new ParticipantParser();
        ParticipantFactory participantFactory = new ParticipantFactory(participantValidator, participantParser);

        RuleValidator ruleValidator = new RuleValidator();
        RuleParser ruleParser = new RuleParser();
        RuleFactory ruleFactory = new RuleFactory(ruleParser, ruleValidator);

        informationDesk = new InformationDesk(inspector, participantFactory, ruleFactory);
    }

    @MethodSource("provideWrongFormatInput")
    @ParameterizedTest
    void wrongInputFormatCannotRegister(RaceInputDto raceInputDto) {
        assertThatThrownBy(() -> informationDesk.register(raceInputDto))
                .isInstanceOf(InputValidationException.class);
    }

    @MethodSource("provideWrongAttributeInput")
    @ParameterizedTest
    void wrongInputAttributeCannotRegister(RaceInputDto raceInputDto) {
        assertThatThrownBy(() -> informationDesk.register(raceInputDto))
                .isInstanceOf(InvalidAttributeException.class);
    }

    @MethodSource("provideSuccessInput")
    @ParameterizedTest
    void registerSuccess(RaceInputDto raceInputDto) {
        assertDoesNotThrow(() -> informationDesk.register(raceInputDto));
    }

    private static Stream<Arguments> provideWrongFormatInput() {
        return Stream.of(
                Arguments.of(new RaceInputDto("*,|", "1")),
                Arguments.of(new RaceInputDto("1,2", "1")),
                Arguments.of(new RaceInputDto("a , b ,c", "1")),
                Arguments.of(new RaceInputDto(",|", "1")),
                Arguments.of(new RaceInputDto(" ", "1"))
        );
    }

    private static Stream<Arguments> provideWrongAttributeInput() {
        return Stream.of(
                Arguments.of(new RaceInputDto("abcdef,a,b", "1")),
                Arguments.of(new RaceInputDto("a,a,b", "1")),
                Arguments.of(new RaceInputDto("a,b,c", "-1")),
                Arguments.of(new RaceInputDto("a,b,c", "f"))
        );
    }

    private static Stream<Arguments> provideSuccessInput() {
        return Stream.of(
                Arguments.of(new RaceInputDto("abcde,a,b", "1")),
                Arguments.of(new RaceInputDto("a,b,c", "2"))
        );
    }
}