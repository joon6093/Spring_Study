package baseball.dto;

public class PlayerScoreDto {
    private final int strikeScore;
    private final int ballScore;

    public PlayerScoreDto(int strikeScore, int ballScore) {
        this.strikeScore = strikeScore;
        this.ballScore = ballScore;
    }

    public int getStrikeScore() {
        return strikeScore;
    }

    public int getBallScore() {
        return ballScore;
    }
}
