package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
public class LottoNumbersTest {

    static Stream<Arguments> 에러_로또_번호_리스트() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }

    static Stream<Arguments> 에러_로또_번호_세트() {
        return Stream.of(
                Arguments.of(new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5))),
                Arguments.of(new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("에러_로또_번호_리스트")
    void 로또_번호_개수_유효성_검사_리스트(List<Integer> lottoNumbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(lottoNumbers));
    }

    @ParameterizedTest
    @NullSource
    @MethodSource("에러_로또_번호_세트")
    void 로또_번호_개수_유효성_검사_세트(TreeSet<Integer> lottoNumbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(lottoNumbers));
    }

    static Stream<Arguments> 정상_로또_번호_리스트() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of(Arrays.asList(12, 21, 33, 41, 44, 45))
        );
    }

    static Stream<Arguments> 정상_로또_번호_세트() {
        return Stream.of(
                Arguments.of(new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Arguments.of(new TreeSet<>(Arrays.asList(12, 21, 33, 41, 44, 45)))
        );
    }

    @ParameterizedTest
    @MethodSource("정상_로또_번호_리스트")
    void 로또_번호_정상_생성_리스트(List<Integer> lottoNumbers) {
        new LottoNumbers(lottoNumbers);
    }

    @ParameterizedTest
    @MethodSource("정상_로또_번호_세트")
    void 로또_번호_정상_생성_세트(TreeSet<Integer> lottoNumbers) {
        new LottoNumbers(lottoNumbers);
    }

    static Stream<Arguments> 로또_번호_범위_에러_리스트() {
        return Stream.of(
                Arguments.of(Arrays.asList(0, 2, 3, 4, 5, 6)),
                Arguments.of(Arrays.asList(12, 21, 33, 41, 44, 46)),
                Arguments.of(Arrays.asList(-1, 20, 33, 41, 44, 46))
        );
    }

    @ParameterizedTest
    @MethodSource("로또_번호_범위_에러_리스트")
    void 로또_번호가_범위를_벗어나는_경우(List<Integer> lottoNumbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(lottoNumbers));
    }
}
