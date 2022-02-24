package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            Money money = InputUtils.inputMoney();
            RandomNumbers randomNumbers = new RandomNumbers();
            LottoMachine lottoMachine = new LottoMachine(money, randomNumbers);
            Lottos lottos = lottoMachine.purchaseLottos();
            OutputUtils.printLottoCount(money.numberOfLottoCanBuy(LottoMachine.LOTTO_PRICE));
            OutputUtils.printLottoNumbers(lottos);
            Lotto winningLotto = InputUtils.inputWinningNumbers();
            LottoNumber bonusLottoNumber = InputUtils.inputBonusNumber(winningLotto);
            LottoResult lottoResult = new LottoResult(lottos, winningLotto, bonusLottoNumber);
            OutputUtils.printLottosResult(lottoResult);
            OutputUtils.printReturnOnLotto(lottoResult.rateOfReturn());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
