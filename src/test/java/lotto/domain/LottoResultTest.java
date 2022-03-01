package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        // 당첨 로또 번호 생성
        Lotto winningLotto = new Lotto(asList(1, 2, 3, 4, 5, 6));
        // 로또 생성
        Lotto lotto = new Lotto(asList(1,2,3,13,14,15));
        // 로또들 생성
        Lottos lottos = new Lottos(Collections.singletonList(lotto));
        // 로또 결과 생성
        lottoResult = new LottoResult(lottos, winningLotto);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0:0",
            "1:0",
            "2:0",
            "3:0",
            "4:0",
            "5:0",
            "6:0",
    }, delimiter = ':')
    void 로또_결과_init_생성_테스트(int key, int value) {
        assertThat(lottoResult.getWinningResult()).containsEntry(key, value);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0:0",
            "1:0",
            "2:0",
            "3:1",
            "4:0",
            "5:0",
            "6:0",
    }, delimiter = ':')
    void 로또_당첨_체크_테스트(int key, int value) {
        lottoResult.winningLottosCheck();
        assertThat(lottoResult.getWinningResult()).containsEntry(key, value);
    }

    @Test
    void 로또_당첨_수익률_계산_테스트() {
        lottoResult.winningLottosCheck();
        assertThat(lottoResult.winningProfit(1000)).isEqualTo(5);
    }
}