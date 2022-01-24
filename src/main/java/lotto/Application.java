package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            Money money = Money.create(InputUtils.inputMoney());
            RandomNumbers randomNumbers = new RandomNumbers();
            LottoMachine lottoMachine = new LottoMachine(money, randomNumbers);
            Lottos lottos = lottoMachine.purchaseLottos();
            OutputUtils.printLottoCount(money.numberOfLottoCanBuy(LottoMachine.LOTTO_PRICE));
            OutputUtils.printLottoNumbers(lottos);
            Lotto winningLotto = new Lotto(new LottoNumbers(InputUtils.inputWinningNumbers()));
            LottoResult lottoResult = new LottoResult(lottos, winningLotto);
            OutputUtils.printLottosResult(lottoResult);
            OutputUtils.printReturnOnLotto(lottoResult.rateOfReturn());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
