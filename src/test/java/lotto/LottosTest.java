package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NonAsciiCharacters")
public class LottosTest {

    @Test
    void 로또_결과() {
        Lottos lottos = new Lottos(new ArrayList<>(Arrays.asList(
                new Lotto(new LottoNumbers((Arrays.asList(1, 2, 3, 4, 5, 6)))),
                new Lotto(new LottoNumbers((Arrays.asList(11, 12, 13, 14, 15, 16))))
        )));
        LinkedHashMap<LottoPrize, Integer> result = new LinkedHashMap<>();
        result.put(LottoPrize.NOTHING, 1);
        result.put(LottoPrize.FOURTH_PRIZE, 0);
        result.put(LottoPrize.THIRD_PRIZE, 0);
        result.put(LottoPrize.SECOND_PRIZE, 0);
        result.put(LottoPrize.FIRST_PRIZE, 1);
        assertEquals(lottos.lottosResult(new LottoNumbers((Arrays.asList(1, 2, 3, 4, 5, 6)))), result);
    }
}
