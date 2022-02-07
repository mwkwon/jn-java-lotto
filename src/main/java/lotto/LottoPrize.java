package lotto;

import java.util.Arrays;

public enum LottoPrize {
    NOTHING(0, false, 0, "%d개 일치 (%d원)- %d개"),
    FIFTH_PRIZE(3, false, 5_000, "%d개 일치 (%d원)- %d개"),
    FOURTH_PRIZE(4, false, 50_000, "%d개 일치 (%d원)- %d개"),
    THIRD_PRIZE(5, false, 1_500_000, "%d개 일치 (%d원)- %d개"),
    SECOND_PRIZE(5, true, 30_000_000, "%d개 일치, 보너스 볼 일치(%d원)- %d개"),
    FIRST_PRIZE(6, false, 2_000_000_000, "%d개 일치 (%d원)- %d개");

    private static final Integer FIVE = 5;
    public final Integer matchCount;
    public final Boolean isMatchBonus;
    public final Integer prize;
    public final String message;

    LottoPrize(int matchCount, boolean isMatchBonus, int prize, String message) {
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
        this.prize = prize;
        this.message = message;
    }

    public static LottoPrize findLottoPrize(Integer matchCount, boolean isMatchBonus) {
        return Arrays.stream(LottoPrize.values())
            .filter(e -> (matchCount.equals(FIVE) && e.matchCount.equals(matchCount) && e.isMatchBonus.equals(isMatchBonus)) ||
                (!matchCount.equals(FIVE) && e.matchCount.equals(matchCount)))
            .findFirst()
            .orElse(LottoPrize.NOTHING);
    }
}
