package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.Lottos;

import java.util.Map;

public class OutputUtils {
    private static final String LOTTO_COUNT_OUTPUT = "개를 구매했습니다.";
    private static final String STATISTICS_QUESTION_OUTPUT = "당첨통계";
    private static final String LINE_OUTPUT = "----------";

    public static void lottoCountOutput(int count) {
        System.out.println(count + LOTTO_COUNT_OUTPUT);
    }

    public static void lottosOutput(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLotto().toString());
        }
    }

    public static void prizeOutput(Map<Integer, Integer> winningResult) {
        System.out.println();
        System.out.println(STATISTICS_QUESTION_OUTPUT);
        System.out.println(LINE_OUTPUT);
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            System.out.println(String.format("%d개 일치 (%d원)- %d개", lottoPrize.count, lottoPrize.prize, winningResult.get(lottoPrize.count)));
        }
    }

    public static void profitOutput(double profit) {
        System.out.printf("총 수익률은 %.2f 입니다.", profit);
    }
}
