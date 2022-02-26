package lotto.domain;

import java.util.List;

public class LottoNumbers {

    private static final int MAX_SIZE = 6;
    private static final String LOTTO_SIZE_ERROR = "로또 번호는 6개 이상이여야 합니다.";


    private List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        validLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }

    private void validLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() < MAX_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR);
        }
    }
}
