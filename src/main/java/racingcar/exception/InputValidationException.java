package racingcar.exception;

public class InputValidationException extends RuntimeException {

    public InputValidationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
