package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int SIZE = 6;
    private static final String LOTTO_SIZE_ERROR = "로또 번호는 6개여야 합니다.";
    private final Set<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        this.lotto = new HashSet<>(lotto);
        validLottoNumbers(this.lotto);
    }

    public Set<LottoNumber> getLotto() {
        return this.lotto;
    }

    public int getLottoSize() {
        return lotto.size();
    }

    public boolean lottoWinningCheck(LottoNumber winningNumber) {
        return lotto.contains(winningNumber);
    }

    private void validLottoNumbers(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR);
        }
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
