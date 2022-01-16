package lotto;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int matchCount(LottoNumbers winningNumbers) {
        return lottoNumbers.matchCount(winningNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
