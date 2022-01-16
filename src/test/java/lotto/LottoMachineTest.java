package lotto;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class LottoMachineTest {
    @Test
    void 로또_구메_테스트() {
        LottoMachine lottoMachine = new LottoMachine(new Money(5000));
        lottoMachine.purchaseLottos();
    }
}
