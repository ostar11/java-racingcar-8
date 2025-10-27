package racingcar.domain.rule;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RuleFactoryTest {

    RuleValidator validator = new RuleValidator();
    RuleParser parser = new RuleParser();
    RuleFactory ruleFactory = new RuleFactory(parser, validator);

    @Test
    void buildRule() {
        String attemptCountInput = "5";

        Rule rule = ruleFactory.build(attemptCountInput);

        assertThat(rule.getCurrentAttemptCount()).isEqualTo(0);
        assertThat(rule.getTotalAttemptCount()).isEqualTo(Integer.parseInt(attemptCountInput));
    }
}