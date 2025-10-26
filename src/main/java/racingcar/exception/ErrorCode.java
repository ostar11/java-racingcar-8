package racingcar.exception;

public enum ErrorCode {

    EMPTY_INPUT("입력값이 비어있습니다."),
    INVALID_CAR_NAME("자동차 이름 길이가 잘못되었습니다."),
    DUPLICATE_CAR_NAME("중복된 참가자 이름이 있습니다."),
    INVALID_ATTEMPT_COUNT("시도 횟수가 범위 밖입니다."),
    INVALID_NUMBER_FORMAT("입력한 문자열이 숫자가 아닙니다."),
    INVALID_PARTICIPANTS_FORMAT("참가자 목록이 잘못된 형식입니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
