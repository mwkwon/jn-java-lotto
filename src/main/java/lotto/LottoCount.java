package lotto;

import java.util.Objects;
import java.util.regex.Pattern;

public class LottoCount {

    private static final Integer MIN_COUNT = 0;
    private static final String LOTTO_COUNT_VALIDATION_EXCEPTION = "로또는 0개 이상 구입 가능합니다.";
    private static final String LOTTO_COUNT_STRING_EXCEPTION = "로또 구매 수량은 숫자만 가능합니다.";
    private static final String LOTTO_COUNT_MAX_EXCEPTION = "로또 구매 가능 수량을 넘길 수 없습니다.";
    private static final String INTEGER_REGEX = "[0-9]+";
    private final Integer lottoCount;


    LottoCount(Integer lottoCount) {
        checkLottoCountValidation(lottoCount);
        this.lottoCount = lottoCount;
    }

    public LottoCount(LottoCount lottoCount) {
        this.lottoCount = lottoCount.lottoCount;
    }

    public static LottoCount createManualLottoCount(String lottoCount, LottoCount totalLottoCount) {
        if (!Pattern.matches(INTEGER_REGEX, lottoCount)) {
            throw new IllegalArgumentException(LOTTO_COUNT_STRING_EXCEPTION);
        }
        LottoCount manualLottoCount = new LottoCount(Integer.parseInt(lottoCount));
        if (totalLottoCount.lottoCount < manualLottoCount.lottoCount) {
            throw new IllegalArgumentException(LOTTO_COUNT_MAX_EXCEPTION);
        }
        return manualLottoCount;
    }

    public LottoCount subtract(LottoCount lottoCount) {
        return new LottoCount(this.lottoCount - lottoCount.lottoCount);
    }

    private static void checkLottoCountValidation(Integer lottoCount) {
        if (Objects.isNull(lottoCount) || MIN_COUNT > lottoCount) {
            throw new IllegalArgumentException(LOTTO_COUNT_VALIDATION_EXCEPTION);
        }
    }

    public Integer getLottoCount() {
        return lottoCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoCount that = (LottoCount) o;
        return Objects.equals(lottoCount, that.lottoCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoCount);
    }

    @Override
    public String toString() {
        return lottoCount.toString();
    }
}
