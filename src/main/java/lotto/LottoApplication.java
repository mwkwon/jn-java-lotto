package lotto;

import lotto.domain.*;
import lotto.utils.InputUtils;
import lotto.utils.OutputUtils;

import java.util.*;

public class LottoApplication {

    public static void main(String[] args) {

        Money money = new Money(InputUtils.lottoStartInput());

        int count = money.calculate();
        OutputUtils.lottoCountOutput(count);

        // 1 ~ 45 로또 총 번호
        TotalLottoNumbers totalLottoNumbers = new TotalLottoNumbers();

        LottoNumbers lottoNumbers = new LottoNumbers(totalLottoNumbers.getTotalLottoNumbers());

        List<Lotto> tempLottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            // 로또 한줄 추출
            Lotto lotto = new Lotto(lottoNumbers.getLottoNumbers());
            tempLottos.add(lotto);

            System.out.println(Arrays.toString(lotto.getLotto().toArray()));
        }

        Lottos lottos = new Lottos(tempLottos);


        String winningString = InputUtils.lottoWinningNumberInput();
        String[] winningStrings = winningString.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String string : winningStrings) {
            winningNumbers.add(Integer.valueOf(string.replace(" ", "")));
        }

        Lotto winningLotto = new Lotto(winningNumbers);

        LottoResult lottoResult = new LottoResult();


        for (int i = 0; i < lottos.getLottos().size(); i++) {
            lottoResult.winningCheck(lottos.getLottos().get(i).getLotto(), winningLotto.getLotto());
        }

        Map<Integer, Integer> winningResult = lottoResult.getWinningResult();

        System.out.println(String.format("%d개 일치 (%d원)- %d개", 3, 5000, winningResult.get(3) == null ? 0 : winningResult.get(3)));
        System.out.println(String.format("%d개 일치 (%d원)- %d개", 4, 50000, winningResult.get(4) == null ? 0 : winningResult.get(4)));
        System.out.println(String.format("%d개 일치 (%d원)- %d개", 5, 1500000, winningResult.get(5) == null ? 0 : winningResult.get(5)));
        System.out.println(String.format("%d개 일치 (%d원)- %d개", 6, 2000000000, winningResult.get(6) == null ? 0 : winningResult.get(6)));

        double sum = 0;
        double a = (winningResult.get(3) == null ? 0 : winningResult.get(3)) * 5000.0;
        double b = (winningResult.get(4) == null ? 0 : winningResult.get(4)) * 50000.0;
        double c = (winningResult.get(5) == null ? 0 : winningResult.get(5)) * 1500000.0;
        double d = (winningResult.get(6) == null ? 0 : winningResult.get(6)) * 2000000000.0;
        sum = a + b + c + d;
        System.out.println(sum);
        System.out.println(money.getMoney());
        double revenue = sum / money.getMoney();

        System.out.printf("총 수익률은 %.2f%n입니다.", revenue);


    }
}
