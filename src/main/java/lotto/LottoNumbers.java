package lotto;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private static final int MIN_SIZE = 0;
    private static final int MAX_SIZE = 6;
    private static final String LOTTO_SIZE_ERROR = "로또 번호는 6개 이상이여야 합니다.";

    public List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        validLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        lottoShuffle();
        return lottoSort(getLottoSixNumber());
    }

    public List<Integer> getLottoSixNumber() {
        return lottoNumbers.subList(MIN_SIZE, MAX_SIZE);
    }

    private void lottoShuffle() {
        Collections.shuffle(lottoNumbers);
    }

    private List<Integer> lottoSort(List<Integer> returnLottoNumber) {
        Collections.sort(returnLottoNumber);
        return returnLottoNumber;
    }

    private void validLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() < MAX_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR);
        }
    }
}
