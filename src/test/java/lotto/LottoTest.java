package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NonAsciiCharacters")
public class LottoTest {
    @Test
    void 로또_생성_테스트() {
        new Lotto(new LottoNumbers((Arrays.asList(1, 2, 3, 4, 5, 6))));
    }

    static Stream<Arguments> 로또_당첨_번호() {
        return Stream.of(
                Arguments.of(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)), 6),
                Arguments.of(new LottoNumbers(Arrays.asList(7, 2, 3, 4, 5, 6)), 5),
                Arguments.of(new LottoNumbers(Arrays.asList(7, 8, 3, 4, 5, 6)), 4),
                Arguments.of(new LottoNumbers(Arrays.asList(7, 8, 9, 4, 5, 6)), 3),
                Arguments.of(new LottoNumbers(Arrays.asList(7, 8, 9, 10, 5, 6)), 2),
                Arguments.of(new LottoNumbers(Arrays.asList(7, 8, 9, 10, 11, 6)), 1),
                Arguments.of(new LottoNumbers(Arrays.asList(7, 8, 9, 10, 11, 12)), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("로또_당첨_번호")
    void 로또_맞춘_개수(LottoNumbers lottoNumbers, int matchCount) {
        Lotto lotto = new Lotto(new LottoNumbers((Arrays.asList(1, 2, 3, 4, 5, 6))));
        assertEquals(lotto.matchCount(lottoNumbers), matchCount);
    }
}
