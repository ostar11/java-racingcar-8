package racingcar;

public enum ErrorCode {

    EMPTY_INPUT("입력값이 비어있습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
