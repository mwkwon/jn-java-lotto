package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LottosTest {

    @Test
    void 로또_iterable_테스트() {
        List<Lotto> lottosParams = Arrays.asList(
                new Lotto(new LottoNumbers(Arrays.stream(new int[]{1, 2, 3, 11, 12, 13}).boxed().map(LottoNumber::new).collect(Collectors.toList()))),
                new Lotto(new LottoNumbers(Arrays.stream(new int[]{1, 2, 3, 21, 22, 23}).boxed().map(LottoNumber::new).collect(Collectors.toList())))
        );
        Lottos lottos = new Lottos(lottosParams);
        int i = 0;
        for (Lotto lotto : lottos) {
            assertThat(lotto).isEqualTo(lottosParams.get(i));
            i++;
        }
    }
}
