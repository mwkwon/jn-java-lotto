package lotto;

import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class LottoNumbers {

    private static final String LOTTO_NUMBERS_NULL_EXCEPTION = "로또 번호는 Null 일 수 없습니다.";
    private static final String LOTTO_NUMBERS_COUNT_EXCEPTION = "로또 번호는 6개의 숫자로 입력해 주세요.";
    private static final String LOTTO_NUMBERS_RANGE_EXCEPTION = "로또 번호는 1부터 45까지 숫자로 입력해주세요.";
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final Integer MIN_NUM = 1;
    private static final Integer MAX_NUM = 45;
    TreeSet<Integer> lottoNumbers;

    public LottoNumbers(TreeSet<Integer> lottoNumbers) {
        init(lottoNumbers);
    }

    public LottoNumbers(List<Integer> lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_NULL_EXCEPTION);
        }
        init(new TreeSet<>(lottoNumbers));
    }

    private void init(TreeSet<Integer> lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_NULL_EXCEPTION);
        }
        checkLottoNumbersValidation(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkLottoNumbersValidation(TreeSet<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_COUNT_EXCEPTION);
        }
        for (Integer lottoNumber : lottoNumbers) {
            checkLottoNumberRange(lottoNumber);
        }
    }

    private void checkLottoNumberRange(Integer lottoNumber) {
        if (MIN_NUM > lottoNumber || MAX_NUM < lottoNumber) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_RANGE_EXCEPTION);
        }
    }

    public int matchCount(LottoNumbers winningNumbers) {
        int matchCount = 0;
        for (Integer winningNumber : winningNumbers.lottoNumbers) {
            matchCount = isContainNumber(matchCount, winningNumber);
        }
        return matchCount;
    }

    private int isContainNumber(int matchCount, Integer winningNumber) {
        if (lottoNumbers.contains(winningNumber)) {
            ++matchCount;
        }
        return matchCount;
    }

    @Override
    public String toString() {
        return lottoNumbers + "";
    }
}
