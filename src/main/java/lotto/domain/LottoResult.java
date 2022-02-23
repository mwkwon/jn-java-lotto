package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Integer, Integer> winningResult;

    public LottoResult() {
        this.winningResult = new HashMap<>();
    }

    public Map<Integer, Integer> getWinningResult() {
        return this.winningResult;
    }

    public void winningCheck(List<Integer> lotto, List<Integer> winningLotto) {
        int count = 0;
        for (int i = 0; i < winningLotto.size(); i++) {
            count = winningCount(lotto, winningLotto.get(i), count);
        }
        putLottoResult(count);
    }

    private int winningCount(List<Integer> lotto, Integer winningNumber, int count) {
        if (lotto.contains(winningNumber)) {
            count++;
        }
        return count;
    }

    private Integer putLottoResult(int count) {
        if (winningResult.containsKey(count)) {
            return winningResult.put(count, winningResult.get(count) + 1);
        }
        return winningResult.put(count, 1);
    }
}
