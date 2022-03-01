package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        TotalLottoNumbers totalLottoNumbers = new TotalLottoNumbers();
        lotto = totalLottoNumbers.createLottoNumbers();
    }

    @Test
    void 로또_번호_사이즈_테스트() {
        assertThat(lotto.getLottoSize()).isEqualTo(6);
    }

    @Test
    void 로또_번호_중첩_테스트() {
        Set<Integer> temp = new HashSet<>(lotto.getLottoNumbers());
        assertThat(temp.size()).isEqualTo(6);
    }

    @Test
    void 총_로또_번호_6개_아닌_테스트() {
        List<Integer> test = new ArrayList<>();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(test);
        });
    }

}