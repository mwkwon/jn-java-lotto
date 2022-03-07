package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static final int LOTTO_PRICE = 1_000;
    private final LottoCount totalLottoCount;
    private final LottoCount manualLottoCount;
    private final LottoCount autoLottoCount;
    private final RandomNumbers randomNumbers;
    private Lottos lottos = new Lottos();

    public LottoMachine(Money money, RandomNumbers randomNumbers, LottoCount manualLottoCount) {
        this.totalLottoCount = new LottoCount(money.numberOfLottoCanBuy(LOTTO_PRICE));
        this.manualLottoCount = new LottoCount(manualLottoCount);
        this.autoLottoCount = this.totalLottoCount.subtract(this.manualLottoCount);
        this.randomNumbers = new RandomNumbers(randomNumbers);
    }

    public Lottos addManualLottos(Lottos manualLottos) {
        this.lottos.add(manualLottos);
        return this.lottos;
    }

    public Lottos purchaseAutoLottos() {
        List<Lotto> lottosParams = new ArrayList<>();
        for (int i = 0; i < autoLottoCount.getLottoCount(); i++) {
            lottosParams.add(new Lotto(new LottoNumbers(randomNumbers.lottoNumbers())));
        }
        this.lottos.add(new Lottos(lottosParams));
        return this.lottos;
    }

    public LottoCount getAutoLottoCount() {
        return autoLottoCount;
    }
}
