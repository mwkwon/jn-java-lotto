package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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
        Set<LottoNumber> temp = new HashSet<>(lotto.getLotto());
        assertThat(temp.size()).isEqualTo(6);
    }

    @Test
    void 총_로또_번호_6개_아닌_경우_에러_테스트() {
        List<LottoNumber> test = new ArrayList<>();
        assertThatThrownBy(()-> new Lotto(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개여야 합니다.");
    }
}
