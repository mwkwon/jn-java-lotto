package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10, 44, 45})
    void 로또_번호_생성(int lottoNumber) {
        new LottoNumber(lottoNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 로또_번호_범위_유효성_검사(int lottoNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(lottoNumber));
    }
}
