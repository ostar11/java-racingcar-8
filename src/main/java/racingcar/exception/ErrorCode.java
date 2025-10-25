package racingcar.exception;

public enum ErrorCode {

    EMPTY_INPUT("입력값이 비어있습니다."),
    INVALID_CAR_NAME("자동차 이름 길이가 잘못되었습니다."),
    DUPLICATE_CAR_NAME("중복된 참가자 이름이 있습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
