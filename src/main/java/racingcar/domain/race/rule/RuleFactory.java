package racingcar.domain.race.rule;

public class RuleFactory {

    private final RuleParser parser = new RuleParser();
    private final RuleValidator validator = new RuleValidator();

    public Rule build(String attemptCountInput) {
        int attemptCount = parser.parse(attemptCountInput);
        validator.check(attemptCount);

        return Rule.from(attemptCount);
    }
}
