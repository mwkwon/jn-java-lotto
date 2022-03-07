package lotto;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResult implements Iterable<LottoPrize> {

    private final int ZERO = 0;
    private final Map<LottoPrize, Integer> result;
    private final Lottos lottos;
    private final Lotto winningLotto;
    private final LottoNumber bonusLottoNumber;

    public LottoResult(Lottos lottos, Lotto winningLotto, LottoNumber bonusLottoNumber) {
        this.lottos = new Lottos(lottos);
        this.winningLotto = new Lotto(winningLotto);
        this.bonusLottoNumber = bonusLottoNumber;
        this.result = initResult();
        calculatorResult();
    }

    public LottoResult(LottoResult lottoResult) {
        this.result = new LinkedHashMap<>(lottoResult.result);
        this.lottos = new Lottos(lottoResult.lottos);
        this.winningLotto = new Lotto(lottoResult.winningLotto);
        this.bonusLottoNumber = lottoResult.bonusLottoNumber;
    }

    private Map<LottoPrize, Integer> initResult() {
        Map<LottoPrize, Integer> result = new LinkedHashMap<>();
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            result.put(lottoPrize, ZERO);
        }
        return result;
    }

    private void calculatorResult() {
        int matchCount;
        boolean isMatchBonus;
        for (Lotto lotto : lottos) {
            matchCount = lotto.matchCount(winningLotto);
            isMatchBonus = lotto.isMatchBonus(bonusLottoNumber);
            LottoPrize lottoPrize = LottoPrize.findLottoPrize(matchCount, isMatchBonus);
            result.put(lottoPrize, result.get(lottoPrize) + 1);
        }
    }

    public float rateOfReturn() {
        int totalPrize = 0;
        int lottoCount = 0;
        for (LottoPrize lottoPrize : result.keySet()) {
            totalPrize += lottoPrize.prize * result.get(lottoPrize);
            lottoCount += result.get(lottoPrize);
        }
        return (float) totalPrize / (lottoCount * LottoMachine.LOTTO_PRICE);
    }

    public Integer prizeCount(LottoPrize lottoPrize) {
        return result.get(lottoPrize);
    }

    public void removeNothing() {
        result.remove(LottoPrize.NOTHING);
    }

    @Override
    public Iterator<LottoPrize> iterator() {
        return result.keySet().iterator();
    }
}
