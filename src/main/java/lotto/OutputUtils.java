package lotto;

import java.util.LinkedHashMap;

public class OutputUtils {

    private OutputUtils() {
    }

    public static void printLottoCount(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }

    public static void printLottosResult(LinkedHashMap<LottoPrize, Integer> result) {
        LinkedHashMap<LottoPrize, Integer> cloneResult = new LinkedHashMap<>(result);
        System.out.println("\n당첨 통계\n---------");
        cloneResult.remove(LottoPrize.NOTHING);
        for (LottoPrize lottoPrize : cloneResult.keySet()) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", lottoPrize.matchCount, lottoPrize.prize, cloneResult.get(lottoPrize));
        }
    }

    public static void printReturnOnLotto(float returnOnLotto) {
        System.out.printf("총 수익률은 %.2f입니다.\n", returnOnLotto);
    }

    public static void printLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
}
