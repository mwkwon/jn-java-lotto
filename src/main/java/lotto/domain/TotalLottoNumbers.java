package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TotalLottoNumbers {

    private static final int MIN_SIZE = 0;
    private static final int MAX_SIZE = 6;
    private static final int START_BOUND = 1;
    private static final int END_BOUND = 45;

    public final List<Integer> totalLottoNumbers;

    public TotalLottoNumbers() {
        totalLottoNumbers = new ArrayList<>(makeTotalLottoNumbers());
    }

    public List<Integer> getTotalLottoNumbers() {
        return totalLottoNumbers;
    }

    public List<Integer> makeTotalLottoNumbers() {
        List<Integer> temp = new ArrayList<>();
        for (int i = START_BOUND; i <= END_BOUND; i++) {
            temp.add(i);
        }
        return temp;
    }

    public LottoNumbers createLottoNumbers() {
        lottoShuffle();
        return new LottoNumbers(lottoSort(getLottoSixNumber()));
    }

    public List<Integer> getLottoSixNumber() {
        return totalLottoNumbers.subList(MIN_SIZE, MAX_SIZE);
    }

    private void lottoShuffle() {
        Collections.shuffle(totalLottoNumbers);
    }

    private List<Integer> lottoSort(List<Integer> returnLottoNumber) {
        Collections.sort(returnLottoNumber);
        return new ArrayList<>(returnLottoNumber);
    }
}
