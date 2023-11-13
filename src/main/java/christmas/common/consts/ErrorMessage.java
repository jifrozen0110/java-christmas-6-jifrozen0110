package christmas.common.consts;

public enum ErrorMessage {
    INVALID_DAY_INPUT_ERROR("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ;

    private final String errorMessage;


    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
