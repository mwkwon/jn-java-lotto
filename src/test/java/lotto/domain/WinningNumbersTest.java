package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class WinningNumbersTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3, 4, 5, 6:6",
            "1, 2, 10, 20, 30, 40,:6",
            "qwd1,2,3,4,5,6:6",
            "1,2,3,4,5,6:6",
    }, delimiter = ':')
    void 당첨_번호_입력_정상_테스트(String s, int size) {
        WinningNumbers winningNumbers = new WinningNumbers(s);
        Lotto lotto = winningNumbers.changeWinningLotto();
        assertThat(lotto.getLottoSize()).isEqualTo(size);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3, 4, 5",
            "1, 2, 10, 20",
            "123456",
            "1,2,3,4,5,6,7"
    }, delimiter = ':')
    void 당첨_번호_입력_에러_테스트(String expect) {
        assertThatThrownBy(()-> new WinningNumbers(expect))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개여야 합니다.");
    }
}
