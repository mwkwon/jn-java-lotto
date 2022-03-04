package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {

    @ParameterizedTest
    @CsvSource(value = {
            "THREE_MATCH:3:5000",
            "FOUR_MATCH:4:50000",
            "FIVE_MATCH:5:1500000",
            "SIX_MATCH:6:2000000000"
    }, delimiter = ':')
    void 로또_상금_생성_테스트(String name, int matchCount, int prize) {
        assertThat(LottoPrize.valueOf(name).count).isEqualTo(matchCount);
        assertThat(LottoPrize.valueOf(name).prize).isEqualTo(prize);
    }
}
