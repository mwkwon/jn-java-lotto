package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LottoController {

    private static final String LOTTO_START_QUESTION = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_QUESTION = "개를 구매했습니다.";
    private static final String LOTTO_WINNING_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(LOTTO_START_QUESTION);
        int price = sc.nextInt();

        Money money = new Money(price);

        int count = money.calculate();
        System.out.println(count + LOTTO_COUNT_QUESTION);

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

        System.out.println(LOTTO_WINNING_NUMBER_QUESTION);
        String winningString = sc.nextLine();
        String[] winningStrings = winningString.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String string : winningStrings) {
            winningNumbers.add(Integer.valueOf(string.replace(" ", "")));
        }

        Lotto winningLotto = new Lotto(winningNumbers);

        LottoResult lottoResult = new LottoResult(lottos, winningLotto);


    }
}
