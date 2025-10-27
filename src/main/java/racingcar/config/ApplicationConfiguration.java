package racingcar.config;

import racingcar.application.RaceApplication;
import racingcar.domain.participant.ParticipantFactory;
import racingcar.domain.participant.ParticipantParser;
import racingcar.domain.participant.ParticipantValidator;
import racingcar.domain.reception.InformationDesk;
import racingcar.domain.reception.Inspector;
import racingcar.domain.rule.RuleFactory;
import racingcar.domain.rule.RuleParser;
import racingcar.domain.rule.RuleValidator;
import racingcar.io.InputReader;
import racingcar.io.OutputWriter;

public class ApplicationConfiguration {

    public RaceApplication raceApplication() {
        return new RaceApplication(inputReader(), informationDesk(), outputWriter());
    }

    private InformationDesk informationDesk() {
        return new InformationDesk(inspector(), participantFactory(), ruleFactory());
    }

    private InputReader inputReader() {
        return new InputReader();
    }

    private OutputWriter outputWriter() {
        return new OutputWriter();
    }

    private Inspector inspector() {
        return new Inspector();
    }

    private ParticipantFactory participantFactory() {
        return new ParticipantFactory(participantValidator(), participantParser());
    }

    private RuleFactory ruleFactory() {
        return new RuleFactory(RuleParser(), ruleValidator());
    }

    private ParticipantValidator participantValidator() {
        return new ParticipantValidator();
    }

    private ParticipantParser participantParser() {
        return new ParticipantParser();
    }

    private RuleParser RuleParser() {
        return new RuleParser();
    }

    private static RuleValidator ruleValidator() {
        return new RuleValidator();
    }
}
