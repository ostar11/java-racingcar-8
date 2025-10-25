package racingcar.exception;

public class InvalidAttributeException extends RuntimeException {
    public InvalidAttributeException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
