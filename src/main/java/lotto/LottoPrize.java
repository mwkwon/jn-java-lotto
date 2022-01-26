package lotto;

import java.util.Arrays;

public enum LottoPrize {
    NOTHING(0, 0),
    FOURTH_PRIZE(3, 5_000),
    THIRD_PRIZE(4, 50_000),
    SECOND_PRIZE(5, 1_500_000),
    FIRST_PRIZE(6, 2_000_000_000);

    public final Integer matchCount;
    public final Integer prize;

    LottoPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoPrize findLottoPrize(Integer matchCount) {
        return Arrays.stream(LottoPrize.values())
                .filter(e -> e.matchCount.equals(matchCount))
                .findFirst()
                .orElse(LottoPrize.NOTHING);
    }
}
