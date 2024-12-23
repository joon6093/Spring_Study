package oncall.error;

public enum ErrorType {
    
    INVALID_INPUT("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");

    private final String message;

    ErrorType(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
