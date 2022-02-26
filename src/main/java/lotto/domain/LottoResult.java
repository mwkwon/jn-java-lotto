package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private static final int ZERO = 0;
    private static final int BOUND = 6;

    private Map<Integer, Integer> winningResult;
    private final Lottos lottos;
    private final Lotto winningLotto;

    public LottoResult(Lottos lottos, Lotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        init();
    }

    public void init() {
        winningResult = new HashMap<>();
        for (int i = ZERO; i <= BOUND; i++) {
            winningResult.put(i, ZERO);
        }
    }

    public Map<Integer, Integer> getWinningResult() {
        return this.winningResult;
    }

    public void winningLottosCheck() {
        for (Lotto lotto : lottos.getLottos()) {
            winningLottoCheck(lotto);
        }

    }

    private void winningLottoCheck(Lotto lotto) {
        int count = 0;
        for (Integer lottoNumber : winningLotto.getLotto().getLottoNumbers()) {
            count = winningCount(lotto, lottoNumber, count);
        }
        putLottoResult(count);
    }

    private int winningCount(Lotto lotto, Integer winningNumber, int count) {
        if (lotto.getLotto().getLottoNumbers().contains(winningNumber)) {
            count++;
        }
        return count;
    }

    private void putLottoResult(int count) {
        winningResult.put(count, winningResult.get(count) + 1);
    }

    public double winningProfit(int money) {
        double threeProfit = winningResult.get(LottoPrize.THREE_MATCH.count) * LottoPrize.THREE_MATCH.prize;
        double fourProfit = winningResult.get(LottoPrize.FOUR_MATCH.count) * LottoPrize.FOUR_MATCH.prize;
        double fiveProfit = winningResult.get(LottoPrize.FIVE_MATCH.count) * LottoPrize.FIVE_MATCH.prize;
        double sixProfit = winningResult.get(LottoPrize.SIX_MATCH.count) * LottoPrize.SIX_MATCH.prize;
        return (threeProfit + fourProfit + fiveProfit + sixProfit) / money;
    }
}
