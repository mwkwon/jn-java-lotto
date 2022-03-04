package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final int SIZE = 6;
    private static final String LOTTO_SIZE_ERROR = "로또 번호는 6개 이상이여야 합니다.";

    private final List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        validLottoNumbers(lotto);
        this.lotto = lotto;
    }

    public List<LottoNumber> getLotto() {
        return this.lotto;
    }

    public int getLottoSize() {
        return lotto.size();
    }

    private void validLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() < SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR);
        }
    }
}
