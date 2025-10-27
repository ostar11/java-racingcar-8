package racingcar.domain.participant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.race.RaceRecord;
import racingcar.domain.race.RaceScore;
import racingcar.exception.InvalidAttributeException;

class ParticipantFactoryTest {

    ParticipantValidator validator = new ParticipantValidator();
    ParticipantParser parser = new ParticipantParser();
    ParticipantFactory participantFactory = new ParticipantFactory(validator, parser);

    @Test
    void buildParticipants() {
        String input = "abc,abcd,abcde";

        Participants participants = participantFactory.build(input);

        RaceRecord raceRecord = participants.getCurrentScores();
        List<RaceScore> raceScores = raceRecord.getRaceScores();
        assertThat(raceScores).extracting(RaceScore::getName).containsExactly(input.split(","));
    }

    @Test
    void duplicateNameCannotMakeParticipants() {
        String input = "abc,abcd,abcd";

        assertThatThrownBy(() -> participantFactory.build(input))
                .isInstanceOf(InvalidAttributeException.class);
    }

    @Test
    void wrongNameCannotMakeParticipants() {
        String input = "abc,abcabc";
        assertThatThrownBy(() -> participantFactory.build(input))
                .isInstanceOf(InvalidAttributeException.class);
    }
}