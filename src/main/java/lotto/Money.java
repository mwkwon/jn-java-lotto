package lotto;

import java.util.Objects;
import java.util.regex.Pattern;

public class Money {

    private static final String MIN_MONEY_EXCEPTION_MESSAGE = "구매금액은 천원 이상이여야 합니다.";
    private static final String INVALID_MONEY_EXCEPTION_MESSAGE = "구매금액은 숫자만 가능합니다.";
    private static final String INTEGER_REGEX = "[0-9]+";
    private final int money;

    public Money(int money) {
        checkMoneyValidation(money);
        this.money = money;
    }

    public static Money create(String money) {
        if (!Pattern.matches(INTEGER_REGEX, money)) {
            throw new IllegalArgumentException(INVALID_MONEY_EXCEPTION_MESSAGE);
        }
        return new Money(Integer.parseInt(money));
    }

    private void checkMoneyValidation(int money) {
        if (money < LottoMachine.LOTTO_PRICE) {
            throw new IllegalArgumentException(MIN_MONEY_EXCEPTION_MESSAGE);
        }
    }

    public int numberOfLottoCanBuy(int lottoPrice) {
        return money / lottoPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
