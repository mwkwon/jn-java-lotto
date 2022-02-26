package lotto;

import java.util.Iterator;

public class Lotto implements Iterable<LottoNumber> {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(Lotto lotto) {
        this.lottoNumbers = new LottoNumbers(lotto.lottoNumbers);
    }

    public int matchCount(Lotto winningLotto) {
        return lottoNumbers.matchCount(winningLotto);
    }

    public boolean isMatchBonus(LottoNumber bonusNumber) {
        return lottoNumbers.isMatchBonus(bonusNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lottoNumbers.iterator();
    }
}
