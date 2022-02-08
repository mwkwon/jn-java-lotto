package lotto;

import java.util.ArrayList;
import java.util.List;

public class TotalLottoNumbers {

    public static final int BOUND = 45;

    public final List<Integer> lottoNumbers;

    public TotalLottoNumbers() {
        lottoNumbers = new ArrayList<>(makeTotalLottoNumbers());
    }

    public List<Integer> getTotalLottoNumbers() {
        return lottoNumbers;
    }

    public List<Integer> makeTotalLottoNumbers() {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < BOUND; i++) {
            temp.add(i);
        }
        return temp;
    }
}
