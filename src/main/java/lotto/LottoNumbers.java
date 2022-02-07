package lotto;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private static final int MIN_SIZE = 0;
    private static final int MAX_SIZE = 6;

    public List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        List<Integer> returnLottoNumber = lottoNumbers.subList(MIN_SIZE, MAX_SIZE);
        return getSort(returnLottoNumber);
    }

    private List<Integer> getSort(List<Integer> returnLottoNumber) {
        Collections.sort(returnLottoNumber);
        return returnLottoNumber;
    }
}
