package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.rule.Rule;

class RuleTest {

    @DisplayName("처음 만든 rule은 진행중이다.")
    @Test
    void createdRuleIsOngoing() {
        Rule rule = Rule.from(1);

        boolean ongoing = rule.isOngoing();

        assertThat(ongoing).isTrue();
    }

    @DisplayName("움직이면 rule은 끝난다.")
    @Test
    void ruleAfterMovingIsNotOngoing() {
        int attemptCount = 2;
        Rule rule = Rule.from(attemptCount);
        for (int i = 0; i < attemptCount; i++) {
            rule.nextRound();
        }

        boolean ongoing = rule.isOngoing();

        assertThat(ongoing).isFalse();
    }
}