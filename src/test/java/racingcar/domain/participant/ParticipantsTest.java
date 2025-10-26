package racingcar.domain.participant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.race.RaceRecord;
import racingcar.domain.race.RaceScore;
import racingcar.exception.ErrorCode;
import racingcar.exception.InvalidAttributeException;

class ParticipantsTest {

    @DisplayName("주어진 문자열로부터 참가자 목록 생성")
    @Test
    void createParticipantsFromStringArray() {
        String[] participantNames = new String[]{"a", "ab", "abc", "abcd", "abcde"};

        Participants participants = Participants.from(participantNames);

        RaceRecord raceRecord = participants.getCurrentScores();
        List<RaceScore> raceScores = raceRecord.getRaceScores();
        assertThat(raceScores).extracting(RaceScore::getName).contains(participantNames);
    }

    @DisplayName("주어진 문자열 중 이름이 긴 참가자가 있으면 생성 실패")
    @Test
    void longNameParticipantFailCreating() {
        String[] participantNames = new String[]{"abcde", "abcdef"};

        assertThatThrownBy(() -> Participants.from(participantNames))
                .isInstanceOf(InvalidAttributeException.class)
                .hasMessage(ErrorCode.INVALID_CAR_NAME.getMessage());
    }

    @DisplayName("참가자를 등록하면 0점부터 시작한다.")
    @Test
    void ParticipantScoreIsZeroAtStart() {
        String[] participantNames = new String[]{"a", "ab", "abc"};
        Participants participants = Participants.from(participantNames);

        RaceRecord raceRecord = participants.getCurrentScores();

        List<RaceScore> raceScores = raceRecord.getRaceScores();
        assertThat(raceScores).extracting(RaceScore::getName).contains(participantNames);
        assertThat(raceScores).extracting(RaceScore::getPosition).containsOnly(0);
    }

    @DisplayName("움직임 명령이 일어나면 참가자 위치는 0이나 1이다.")
    @Test
    void carIsOneOrZeroAfterMove() {
        String[] participantNames = new String[]{"a", "ab", "abc"};
        Participants participants = Participants.from(participantNames);

        participants.move();

        RaceRecord raceRecord = participants.getCurrentScores();
        List<RaceScore> raceScores = raceRecord.getRaceScores();
        assertThat(raceScores).extracting(RaceScore::getPosition).containsAnyOf(0, 1);
    }
}