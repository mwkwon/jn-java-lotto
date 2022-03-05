package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    private static final String LOTTO_NUMBER_BOUND_ERROR = "로또 번호는 1 ~ 45 사이에 숫자만 가능합니다.";
    private static final int START_BOUND = 1;
    private static final int END_BOUND = 45;
    private final Integer lottoNumber;

    public LottoNumber(int lottoNumber) {
        validBoundLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validBoundLottoNumber(int lottoNumber) {
        if (lottoNumber < START_BOUND || lottoNumber > END_BOUND) {
            throw new IllegalArgumentException(LOTTO_NUMBER_BOUND_ERROR);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(lottoNumber, o.lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
