package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;

import java.util.List;
import java.util.Map;

public class OutputUtils {

    private static final String LOTTO_COUNT_OUTPUT = "개를 구매했습니다.";
    private static final String STATISTICS_QUESTION_OUTPUT = "당첨통계";
    private static final String LINE_OUTPUT = "----------";

    public static void lottoCountOutput(int count) {
        System.out.println(count + LOTTO_COUNT_OUTPUT);
    }

    public static void lottosOutput(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLotto().getLottoNumbers().toString());
        }
    }

    public static void prizeOutput(Map<Integer, Integer> winningResult) {
        System.out.println();
        System.out.println(STATISTICS_QUESTION_OUTPUT);
        System.out.println(LINE_OUTPUT);
        System.out.println(String.format("%d개 일치 (%d원)- %d개", LottoPrize.THREE_MATCH.count, LottoPrize.THREE_MATCH.prize, winningResult.get(LottoPrize.THREE_MATCH.count)));
        System.out.println(String.format("%d개 일치 (%d원)- %d개", LottoPrize.FOUR_MATCH.count, LottoPrize.FOUR_MATCH.prize, winningResult.get(LottoPrize.FOUR_MATCH.count)));
        System.out.println(String.format("%d개 일치 (%d원)- %d개", LottoPrize.FIVE_MATCH.count, LottoPrize.FIVE_MATCH.prize, winningResult.get(LottoPrize.FIVE_MATCH.count)));
        System.out.println(String.format("%d개 일치 (%d원)- %d개", LottoPrize.SIX_MATCH.count, LottoPrize.SIX_MATCH.prize, winningResult.get(LottoPrize.SIX_MATCH.count)));
    }

    public static void profitOutput(double profit) {
        System.out.printf("총 수익률은 %.2f 입니다.", profit);
    }
}
