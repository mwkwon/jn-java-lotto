package lotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Lottos implements Iterable<Lotto> {

    private final int ZERO = 0;
    private final ArrayList<Lotto> lottos;

    public Lottos(ArrayList<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LinkedHashMap<LottoPrize, Integer> lottosResult(LottoNumbers winningNumbers) {
        LinkedHashMap<LottoPrize, Integer> result = initResult();
        int matchCount;
        for (Lotto lotto : lottos) {
            matchCount = lotto.matchCount(winningNumbers);
            LottoPrize lottoPrize = LottoPrize.findLottoPrize(matchCount);
            result.put(lottoPrize, result.get(lottoPrize) + 1);
        }
        return result;
    }

    private LinkedHashMap<LottoPrize, Integer> initResult() {
        LinkedHashMap<LottoPrize, Integer> result = new LinkedHashMap<>();
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            result.put(lottoPrize, ZERO);
        }
        return result;
    }

    @Override
    public Iterator<Lotto> iterator() {
        return new Iterator<Lotto> () {
            private final Iterator<Lotto> iter = lottos.iterator();

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public Lotto next() {
                return iter.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("no changes allowed");
            }
        };
    }
}
