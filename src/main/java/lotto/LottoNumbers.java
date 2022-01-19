package lotto;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class LottoNumbers implements Iterable<LottoNumber>{

    private static final String LOTTO_NUMBERS_NULL_EXCEPTION = "로또 번호는 Null 일 수 없습니다.";
    private static final String LOTTO_NUMBERS_COUNT_EXCEPTION = "로또 번호는 6개의 숫자로 입력해 주세요.";
    private static final int LOTTO_NUMBERS_COUNT = 6;
    Set<LottoNumber> lottoNumbers;

    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        init(lottoNumbers);
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_NULL_EXCEPTION);
        }
        init(new TreeSet<>(lottoNumbers));
    }

    public LottoNumbers(LottoNumbers lottoNumbers) {
        this.lottoNumbers = new TreeSet<>(lottoNumbers.lottoNumbers);
    }

    private void init(Set<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_NULL_EXCEPTION);
        }
        checkLottoNumbersValidation(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkLottoNumbersValidation(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_COUNT_EXCEPTION);
        }
    }

    public int matchCount(Lotto winningLotto) {
        int matchCount = 0;
        for (LottoNumber winningNumber : winningLotto) {
            matchCount = isContainNumber(matchCount, winningNumber);
        }
        return matchCount;
    }

    private int isContainNumber(int matchCount, LottoNumber winningNumber) {
        if (lottoNumbers.contains(winningNumber)) {
            ++matchCount;
        }
        return matchCount;
    }

    @Override
    public String toString() {
        return lottoNumbers + "";
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lottoNumbers.iterator();
    }
}
