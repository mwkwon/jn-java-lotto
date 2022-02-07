package lotto;

public class OutputUtils {

    private OutputUtils() {
    }

    public static void printLottoCount(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }

    public static void printLottosResult(LottoResult lottoResult) {
        LottoResult cloneResult = new LottoResult(lottoResult);
        cloneResult.removeNothing();
        System.out.println("\n당첨 통계\n---------");
        for (LottoPrize lottoPrize : cloneResult) {
            System.out.printf(lottoPrize.message + "\n", lottoPrize.matchCount, lottoPrize.prize, cloneResult.prizeCount(lottoPrize));
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
