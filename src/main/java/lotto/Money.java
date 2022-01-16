package lotto;

public class Money {
    private static final String MIN_MONEY_EXCEPTION_MESSAGE = "구매금액은 천원 이상이여야 합니다.";
    private static final String INVALID_MONEY_EXCEPTION_MESSAGE = "구매금액은 숫자만 가능합니다.";
    private int money;

    public Money(int money) {
        checkMoneyValidation(money);
        this.money = money;
    }

    public Money(String money) {
        this(moneyStrToInt(money));
    }

    private static int moneyStrToInt(String money) {
        int intMoney;
        try {
            intMoney = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_MONEY_EXCEPTION_MESSAGE);
        }
        return intMoney;
    }

    private void checkMoneyValidation(int money) {
        if (money < LottoMachine.LOTTO_PRICE) {
            throw new IllegalArgumentException(MIN_MONEY_EXCEPTION_MESSAGE);
        }
    }

    public int numberOfLottoCanBuy(int lottoPrice) {
        return money / lottoPrice;
    }
}
