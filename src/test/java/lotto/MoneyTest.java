package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class MoneyTest {

    @Test
    void 돈_생성_테스트() {
        Money money = new Money(1000);
        assertThat(money.getMoney()).isEqualTo(1000);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1000:1",
            "2000:2",
            "3000:3",
            "4000:4"
    }, delimiter = ':')
    void 돈_액수에따른_로또_횟수_계산_테스트(int cost, int count) {
        Money money = new Money(cost);
        assertThat(money.calculate()).isEqualTo(count);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1000, -2000, -3000})
    void 돈_0_또는_음수_에러_테스트(int expect) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Money(expect);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {500, 800, 1200, 1700})
    void 돈_1000원_단위_아닌_에러_테스트(int expect) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Money(expect);
        });
    }

}