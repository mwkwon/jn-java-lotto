package lotto.domain;

import java.util.List;

public class Lotto {

    private static final int SIZE = 6;
    private static final String LOTTO_SIZE_ERROR = "로또 번호는 6개 이상이여야 합니다.";

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lotto) {
        validLottoNumbers(lotto);
        this.lottoNumbers = lotto;
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public int getLottoSize() {
        return lottoNumbers.size();
    }

    private void validLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() < SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR);
        }
    }
}
