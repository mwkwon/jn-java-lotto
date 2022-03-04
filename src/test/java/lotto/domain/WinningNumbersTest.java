package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningNumbersTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3, 4, 5, 6:6",
            "1, 2, 10, 20, 30, 40,:6",
            "qwd1,2,3,4,5,6:6",
            "1,2,3,4,5,6:6",
    }, delimiter = ':')
    void 당첨_번호_정상_입력_테스트(String s, int size) {
        String[] strings = s.split(",");
        WinningNumbers winningNumbers = new WinningNumbers(strings);
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
    void 당첨_번호_에러_입력_테스트(String s) {
        String[] strings = s.split(",");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningNumbers(strings);
        });
    }
}
