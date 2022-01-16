package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NonAsciiCharacters")
public class RandomNumbersTest {

    @Test
    void 로또_번호_생성() {
        RandomNumbers randomNumbers = new RandomNumbers();
        List<Integer> lottoNumbers = randomNumbers.lottoNumbers();
        assertEquals(lottoNumbers.size(), 6);
        System.out.println(lottoNumbers);
    }

    @Test
    void 로또_번호_정렬_확인() {
        RandomNumbers randomNumbers = new RandomNumbers();
        List<Integer> lottoNumbers = randomNumbers.lottoNumbers();
        List<Integer> sortedList = new ArrayList<>(lottoNumbers);
        Collections.sort(sortedList);
        assertEquals(lottoNumbers, sortedList);
    }
}
