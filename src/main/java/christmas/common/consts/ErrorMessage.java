package christmas.common.consts;

public enum ErrorMessage {
    NULL_VALUE_ERROR("[ERROR] NULL 값이 들어왔습니다."),
    ZERO_VALUE_ERROR("[ERROR] 0 값이 들어왔습니다."),
    INVALID_DAY_INPUT_ERROR("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_NUMBER_FORMAT_ERROR("[ERROR] 정수값이 아닙니다."),
    OUT_BOUND_OF_MAX_ORDER_ERROR("[ERROR] 주문 수량 20개를 초과하였습니다. 해당 주문은 삭제합니다."),
    INVALID_INPUT_ORDER_ERROR("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String errorMessage;


    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
