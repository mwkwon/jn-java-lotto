package lotto;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoPrize {
    NOTHING(0, false, 0, "%d개 일치 (%d원)- %d개", (matchCount, isMatchBonus) -> matchCount < 3),
    FIFTH_PRIZE(3, false, 5_000, "%d개 일치 (%d원)- %d개", (matchCount, isMatchBonus) -> matchCount == 3),
    FOURTH_PRIZE(4, false, 50_000, "%d개 일치 (%d원)- %d개", (matchCount, isMatchBonus) -> matchCount == 4),
    THIRD_PRIZE(5, false, 1_500_000, "%d개 일치 (%d원)- %d개", (matchCount, isMatchBonus) -> matchCount == 5 && !isMatchBonus),
    SECOND_PRIZE(5, true, 30_000_000, "%d개 일치, 보너스 볼 일치(%d원)- %d개", (matchCount, isMatchBonus) -> matchCount == 5 && isMatchBonus),
    FIRST_PRIZE(6, false, 2_000_000_000, "%d개 일치 (%d원)- %d개", (matchCount, isMatchBonus) -> matchCount == 6);

    private static final Integer FIVE = 5;
    public final Integer matchCount;
    public final Boolean isMatchBonus;
    public final Integer prize;
    public final String message;
    private final BiPredicate<Integer, Boolean> calcLottoResult;

    LottoPrize(int matchCount, boolean isMatchBonus, int prize, String message, BiPredicate<Integer, Boolean> calcLottoResult) {
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
        this.prize = prize;
        this.message = message;
        this.calcLottoResult = calcLottoResult;
    }

    public static LottoPrize findLottoPrize(Integer matchCount, boolean isMatchBonus) {
        return Arrays.stream(LottoPrize.values())
            .filter(lottoPrize -> lottoPrize.calcLottoResult.test(matchCount, isMatchBonus))
            .findFirst()
            .orElse(LottoPrize.NOTHING);
    }
}
