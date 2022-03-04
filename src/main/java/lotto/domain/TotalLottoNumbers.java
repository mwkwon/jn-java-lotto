package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TotalLottoNumbers {

    private static final int MIN_SIZE = 0;
    private static final int MAX_SIZE = 6;
    private static final int START_BOUND = 1;
    private static final int END_BOUND = 45;

    public final List<LottoNumber> totalNumbers;

    public TotalLottoNumbers() {
        totalNumbers = new ArrayList<>(makeTotalLottoNumbers());
    }

    public List<LottoNumber> getTotalNumbers() {
        return totalNumbers;
    }

    public int getTotalLottoSize() {
        return totalNumbers.size();
    }

    public Lotto createLottoNumbers() {
        Collections.shuffle(totalNumbers);
        return new Lotto(lottoSort(getLottoSixNumber()));
    }

    private List<LottoNumber> getLottoSixNumber() {
        return totalNumbers.subList(MIN_SIZE, MAX_SIZE);
    }

    private List<LottoNumber> makeTotalLottoNumbers() {
        List<LottoNumber> temp = new ArrayList<>();
        for (int i = START_BOUND; i <= END_BOUND; i++) {
            temp.add(new LottoNumber(i));
        }
        return temp;
    }

    private List<LottoNumber> lottoSort(List<LottoNumber> returnLottoNumber) {
        Collections.sort(returnLottoNumber);
        return new ArrayList<>(returnLottoNumber);
    }
}
