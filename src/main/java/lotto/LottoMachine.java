package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static final int LOTTO_PRICE = 1_000;
    private final int lottoCount;
    private final RandomNumbers randomNumbers;

    public LottoMachine(Money money, RandomNumbers randomNumbers) {
        lottoCount = money.numberOfLottoCanBuy(LOTTO_PRICE);
        this.randomNumbers = new RandomNumbers(randomNumbers);
    }

    public Lottos purchaseLottos() {
        List<Lotto> lottosParams = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottosParams.add(new Lotto(new LottoNumbers(randomNumbers.lottoNumbers())));
        }
        return new Lottos(lottosParams);
    }
}
