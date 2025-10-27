package racingcar.domain.rule;

public class RuleFactory {

    private final RuleParser parser;
    private final RuleValidator validator;

    public RuleFactory(RuleParser parser, RuleValidator validator) {
        this.parser = parser;
        this.validator = validator;
    }

    public Rule build(String attemptCountInput) {
        int attemptCount = parser.parse(attemptCountInput);
        validator.check(attemptCount);

        return Rule.from(attemptCount);
    }
}
