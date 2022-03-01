package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    // lottos 말고 다른 명칭 사용하라고 하는데...
    // 좋은 다른 명칭이 생각이 안난다..
    private final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public void createLottos(int count, TotalLottoNumbers totalLottoNumbers) {
        for (int i = 0; i < count; i++) {
            lottos.add(totalLottoNumbers.createLottoNumbers());
        }
    }


}
