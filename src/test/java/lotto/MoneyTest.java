package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NonAsciiCharacters")
public class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {-1000, 0, 100, 999})
    void 로또_살_수_없는_돈이_들어온_경우_유효성_검사(int money) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(money));
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 1000000})
    void 천원이상_정수_타입_돈이_들어온_경우(int money) {
        assertThat(new Money(money)).isEqualTo(new Money(money));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "1000000"})
    void 천원이상_문자_타입_돈이_들어온_경우(String money) {
        assertThat(Money.create(money)).isEqualTo(Money.create(money));
    }

    @ParameterizedTest
    @ValueSource(strings = {"가나다", "", "abcd"})
    void 숫자_문자_타입이_아닌_돈이_들어온_경우(String money) {
        assertThatIllegalArgumentException().isThrownBy(() -> Money.create(money));
    }

    @ParameterizedTest
    @CsvSource({
            "1000, 1",
            "1999, 1",
            "30000, 30"
    })
    void 로또_살_수_있는_개수(int money, int lottoCount) {
        assertEquals(new Money(money).numberOfLottoCanBuy(1000), lottoCount);
    }
}
