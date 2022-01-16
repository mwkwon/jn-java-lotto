package lotto;

import java.util.LinkedHashMap;

public class Calculator {

    private Calculator() {
    }

    public static float returnOnLotto(LinkedHashMap<LottoPrize, Integer> result) {
        int totalPrize = 0;
        int lottoCount = 0;
        for (LottoPrize lottoPrize : result.keySet()) {
            totalPrize += lottoPrize.prize * result.get(lottoPrize);
            lottoCount += result.get(lottoPrize);
        }
        return (float)totalPrize / (lottoCount * LottoMachine.LOTTO_PRICE);
    }
}
