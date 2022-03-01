package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TotalLottoNumbersTest {

    private TotalLottoNumbers totalLottoNumbers;

    @BeforeEach
    void setUp() {
        totalLottoNumbers = new TotalLottoNumbers();
    }

    @Test
    void 총_로또_번호_값_테스트() {
        for (int i = 1; i <= 45; i++) {
            assertThat(totalLottoNumbers.getTotalNumbers()).contains(i);
        }
    }

    @Test
    void 총_로또_번호_사이즈_테스트() {
        assertThat(totalLottoNumbers.getTotalLottoSize()).isEqualTo(45);
    }

    @Test
    void 로또_번호_생성_테스트() {
        assertThat(totalLottoNumbers.createLottoNumbers().getLottoSize()).isEqualTo(6);
    }
}