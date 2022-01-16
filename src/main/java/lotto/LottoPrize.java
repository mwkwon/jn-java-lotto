package lotto;

public enum LottoPrize {
    NOTHING(0, 0),
    FOURTH_PRIZE(3, 5_000),
    THIRD_PRIZE(4, 50_000),
    SECOND_PRIZE(5, 1_500_000),
    FIRST_PRIZE(6, 2_000_000_000);

    public final int matchCount;
    public final int prize;

    LottoPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoPrize findLottoPrize(int matchCount) {
        if (matchCount == FIRST_PRIZE.matchCount) {
            return FIRST_PRIZE;
        } else if (matchCount == SECOND_PRIZE.matchCount) {
            return SECOND_PRIZE;
        } else if (matchCount == THIRD_PRIZE.matchCount) {
            return THIRD_PRIZE;
        } else if (matchCount == FOURTH_PRIZE.matchCount) {
            return FOURTH_PRIZE;
        }
        return NOTHING;
    }
}
