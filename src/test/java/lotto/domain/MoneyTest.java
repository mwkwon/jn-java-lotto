package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


public class MoneyTest {

    @Test
    void 돈_생성_테스트() {
        Money money = new Money(1000);
        assertThat(money.getPrice()).isEqualTo(1000);
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
        assertThat(money.lottoQuantity()).isEqualTo(count);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1000, -2000, -3000})
    void 돈_0_또는_음수_에러_테스트(int expect) {
        assertThatThrownBy(() -> new Money(expect))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("돈은 음수이거나 0일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {500, 600, 700, 800, 900})
    void 돈_1000원_보다_작은_경우_에러_테스트(int expect) {
        assertThatThrownBy(() -> new Money(expect))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("돈은 1000원 보다 작을 수 없습니다.");
    }
}
