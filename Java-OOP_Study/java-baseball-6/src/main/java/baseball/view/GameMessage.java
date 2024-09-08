package baseball.view;

public enum GameMessage {
    PROMPT_INPUT_NUMBER("숫자를 입력해주세요 : "),
    PROMPT_RETRY_CONFIRM("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    INFO_START_GAME("숫자 야구 게임을 시작합니다."),
    INFO_SUCCESS_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    INFO_BALL("볼"),
    INFO_STRIKE("스트라이크"),
    INFO_NOTHING("낫싱"),
    ;

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
