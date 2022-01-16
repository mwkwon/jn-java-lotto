package lotto;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class LottoMachine {

    public static final int LOTTO_PRICE = 1_000;
    private final int lottoCount;
    private Lottos lottos;

    public LottoMachine(Money money) {
        lottoCount = money.numberOfLottoCanBuy(LOTTO_PRICE);
    }

    public Lottos purchaseLottos() {
        ArrayList<Lotto> lottosParms = new ArrayList<>();
        RandomNumbers randomNumbers = new RandomNumbers();
        for (int i = 0; i < lottoCount; i++) {
            lottosParms.add(new Lotto(new LottoNumbers(randomNumbers.lottoNumbers())));
        }
        lottos = new Lottos(lottosParms);
        return lottos;
    }

    public LinkedHashMap<LottoPrize, Integer> lottosResult(LottoNumbers winningNumbers) {
        return lottos.lottosResult(winningNumbers);
    }
}
