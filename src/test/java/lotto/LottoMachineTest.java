package lotto;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class LottoMachineTest {

    @Test
    void 로또_자동_구메_테스트() {
        LottoMachine lottoMachine = new LottoMachine(new Money(5000), new RandomNumbers(), new LottoCount(1));
        Lottos lottos = lottoMachine.purchaseAutoLottos();
        assertThat(lottos).isEqualTo(new Lottos(lottos));
    }

    @Test
    void 로또_수동_구메_테스트() {
        Lottos lottos = new Lottos(
            Arrays.asList(
                new Lotto(new LottoNumbers(Arrays.stream(new int[]{1, 2, 3, 11, 12, 13}).boxed().map(LottoNumber::of).collect(Collectors.toList()))),
                new Lotto(new LottoNumbers(Arrays.stream(new int[]{1, 2, 3, 21, 22, 23}).boxed().map(LottoNumber::of).collect(Collectors.toList())))
            )
        );
        LottoMachine lottoMachine = new LottoMachine(new Money(5000), new RandomNumbers(), new LottoCount(1));
        assertThat(lottoMachine.addManualLottos(lottos)).isEqualTo(lottos);
    }
}
