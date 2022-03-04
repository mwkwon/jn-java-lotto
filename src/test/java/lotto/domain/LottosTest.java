package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private TotalLottoNumbers totalLottoNumbers;

    @BeforeEach
    void setUp() {
        totalLottoNumbers = new TotalLottoNumbers();
    }

    @Test
    void 로또들_생성_테스트() {
        Lottos lottos = new Lottos();
        lottos.createLottos(10, totalLottoNumbers);
        assertThat(lottos.getLottosSize()).isEqualTo(10);
    }
}
