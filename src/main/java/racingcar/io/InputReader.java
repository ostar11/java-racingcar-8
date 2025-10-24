package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    private static final String PARTICIPANTS_QUESTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_QUESTION = "시도할 횟수는 몇 회인가요?";

    public RaceInputDto read() {
        String participants = readParticipants();
        String attemptCount = readAttemptCount();

        Console.close();

        return new RaceInputDto(participants, attemptCount);
    }

    private String readParticipants() {
        System.out.println(PARTICIPANTS_QUESTION);
        return Console.readLine();
    }

    private String readAttemptCount() {
        System.out.println(ATTEMPT_COUNT_QUESTION);
        return Console.readLine();
    }
}
