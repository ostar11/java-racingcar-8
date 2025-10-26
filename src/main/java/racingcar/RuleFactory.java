package racingcar;

import racingcar.domain.Rule;

public class RuleFactory {

    private final RuleParser parser = new RuleParser();
    private final RuleValidator validator = new RuleValidator();

    public Rule build(String attemptCountInput) {
        int attemptCount = parser.parse(attemptCountInput);
        validator.checkAttemptRange(attemptCount);

        return Rule.from(attemptCount);
    }
}
