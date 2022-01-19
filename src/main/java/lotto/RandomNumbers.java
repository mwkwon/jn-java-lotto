package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers {
    private final int MIN_NUM = 1;
    private final int MAX_NUM = 45;
    private final int ZERO = 0;
    private final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> randomNumbers;

    public RandomNumbers() {
        int[] range = IntStream.rangeClosed(MIN_NUM, MAX_NUM).toArray();
        randomNumbers = Arrays.stream(range).boxed().map(LottoNumber::new).collect(Collectors.toList());
    }

    public RandomNumbers(RandomNumbers randomNumbers) {
        this.randomNumbers = new ArrayList<>(randomNumbers.randomNumbers);
    }

    public List<LottoNumber> lottoNumbers() {
        Collections.shuffle(randomNumbers);
        List<LottoNumber> lottoNumbers = randomNumbers.subList(ZERO, LOTTO_NUMBER_COUNT);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
