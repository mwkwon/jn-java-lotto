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
            Lotto winningLotto = new Lotto(LottoNumbers.create(InputUtils.inputWinningNumbers()));
            LottoNumber bonusLottoNumber = LottoNumber.createBonusLottoNumber(InputUtils.inputBonusNumber());
            LottoResult lottoResult = new LottoResult(lottos, winningLotto, bonusLottoNumber);
            OutputUtils.printLottosResult(lottoResult);
            OutputUtils.printReturnOnLotto(lottoResult.rateOfReturn());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
