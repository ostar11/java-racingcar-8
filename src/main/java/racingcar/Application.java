package racingcar;

import racingcar.application.RaceApplication;
import racingcar.config.ApplicationConfiguration;

public class Application {
    public static void main(String[] args) {
        RaceApplication raceApplication = new ApplicationConfiguration().raceApplication();
//        RaceApplication raceApplication = new RaceApplication();
        raceApplication.start();
    }
}
