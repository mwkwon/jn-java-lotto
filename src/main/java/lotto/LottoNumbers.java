package lotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class LottoNumbers implements Iterable<LottoNumber>{

    private static final String LOTTO_NUMBERS_NULL_EXCEPTION = "로또 번호는 Null 일 수 없습니다.";
    private static final String LOTTO_NUMBERS_COUNT_EXCEPTION = "로또 번호는 6개의 숫자로 입력해 주세요.";
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final String COMMA = ",";
    private Set<LottoNumber> lottoNumbers;

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

    public static LottoNumbers create(String strLottoNumbers) {
        List<LottoNumber> winningNumbers = new ArrayList<>();
        for (String number : strLottoNumbers.split(COMMA)) {
            winningNumbers.add(LottoNumber.of(Integer.parseInt(number.trim())));
        }
        return new LottoNumbers(winningNumbers);
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

    public boolean isMatchBonus(LottoNumber bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
