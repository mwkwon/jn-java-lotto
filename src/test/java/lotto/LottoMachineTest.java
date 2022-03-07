package lotto;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class LottoMachineTest {

    @Test
    void 로또_구메_테스트() {
        LottoMachine lottoMachine = new LottoMachine(new Money(5000), new RandomNumbers());
        Lottos lottos = lottoMachine.purchaseLottos();
        assertThat(lottos).isEqualTo(new Lottos(lottos));
    }
}
