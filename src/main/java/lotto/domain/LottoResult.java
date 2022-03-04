package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private static final int ZERO = 0;
    private static final int BOUND = 6;

    private final Map<Integer, Integer> winningResult;
    private final Lottos lottos;
    private final Lotto winningLotto;

    public LottoResult(Lottos lottos, Lotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.winningResult = new HashMap<>(makeWinningResult());
    }

    public Map<Integer, Integer> getWinningResult() {
        return this.winningResult;
    }

    public void winningLottosCheck() {
        for (Lotto lotto : lottos.getLottos()) {
            winningLottoCheck(lotto);
        }
    }

    public double winningProfit(int money) {
        double sum = 0;
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            sum += winningResult.get(lottoPrize.count) * lottoPrize.prize;
        }
        return sum / money;
    }

    private Map<Integer, Integer> makeWinningResult() {
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = ZERO; i <= BOUND; i++) {
            temp.put(i, ZERO);
        }
        return temp;
    }

    private void winningLottoCheck(Lotto lotto) {
        int count = 0;
        for (Integer lottoNumber : winningLotto.getLotto()) {
            count = winningCount(lotto, lottoNumber, count);
        }
        putLottoResult(count);
    }

    private int winningCount(Lotto lotto, Integer winningNumber, int count) {
        if (lotto.getLotto().contains(winningNumber)) {
            count++;
        }
        return count;
    }

    private void putLottoResult(int count) {
        winningResult.put(count, winningResult.get(count) + 1);
    }
}
