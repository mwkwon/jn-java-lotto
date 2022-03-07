package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoCountTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 100})
    void 로또_구매_개수_생성(int lottoNumber) {
        assertThat(new LottoCount(lottoNumber)).isEqualTo(new LottoCount(lottoNumber));
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -1})
    void 로또_번호_범위_유효성_검사(int lottoNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoCount(lottoNumber));
    }
}