package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersTest {

    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        TotalLottoNumbers totalLottoNumbers = new TotalLottoNumbers();
        lottoNumbers = new LottoNumbers(totalLottoNumbers.getTotalLottoNumbers());
    }

    @Test
    void 로또_번호_6개_생성_테스트() {
        List<Integer> numbers = lottoNumbers.getLottoNumber();
        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    void 총로또_번호_리스트_6자_미만_테스트() {
        List<Integer> test = new ArrayList<>();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(test);
        });
    }

}