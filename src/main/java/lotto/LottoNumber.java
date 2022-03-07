package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final String LOTTO_NUMBERS_RANGE_EXCEPTION = "로또 번호는 1부터 45까지 숫자로 입력해주세요.";
    private static final Integer MIN_NUM = 1;
    private static final Integer MAX_NUM = 45;
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();
    private final Integer lottoNumber;

    static {
        for (int i = MIN_NUM; i <= MAX_NUM; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber createBonusLottoNumber(String lottoNumber) {
        return new LottoNumber(Integer.parseInt(lottoNumber.trim()));
    }

    public static LottoNumber of(Integer number) {
        checkLottoNumberRange(number);
        return lottoNumbers.get(number);
    }

    private static void checkLottoNumberRange(Integer lottoNumber) {
        if (Objects.isNull(lottoNumber) || MIN_NUM > lottoNumber || MAX_NUM < lottoNumber) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_RANGE_EXCEPTION);
        }
    }

    @Override
    public String toString() {
        return Integer.toString(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(lottoNumber, o.lottoNumber);
    }
}
