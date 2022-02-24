package lotto;

import java.util.Objects;
import java.util.Scanner;

public class InputUtils {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MONEY_TEXT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final Integer MAX_TRY_COUNT = 5;
    private static final String INPUT_MONEY_MAX_TRY_MESSAGE = "구입금액 입력 가능 횟수를 초과했습니다.";
    private static final String INPUT_WINNING_NUMBERS_MAX_TRY_MESSAGE = "당첨 번호 입력 가능 횟수를 초과했습니다.";
    private static final String INPUT_BONUS_NUMBER_MAX_TRY_MESSAGE = "보너스 볼 번호 입력 가능 횟수를 초과했습니다.";
    private static final String DUPLICATE_BONUS_NUMBER = "로또 당첨 번호와 보너스 번호가 같을 수 없습니다.";

    private InputUtils() {
    }

    public static Money inputMoney() {
        int i = 0;
        Money money = null;

        while (Objects.isNull(money) && i < MAX_TRY_COUNT) {
            money = createMoney();
            i++;
        }
        if (Objects.isNull(money)) {
            throw new IllegalArgumentException(INPUT_MONEY_MAX_TRY_MESSAGE);
        }
        return money;
    }

    public static Lotto inputWinningNumbers() {
        int i = 0;
        LottoNumbers lottoNumbers = null;

        while (Objects.isNull(lottoNumbers) && i < MAX_TRY_COUNT) {
            lottoNumbers = createLottoNumbers();
            i++;
        }
        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalArgumentException(INPUT_WINNING_NUMBERS_MAX_TRY_MESSAGE);
        }
        return new Lotto(lottoNumbers);
    }

    public static LottoNumber inputBonusNumber(Lotto winningLotto) {
        int i = 0;
        LottoNumber lottoNumber = null;

        while (Objects.isNull(lottoNumber) && i < MAX_TRY_COUNT) {
            lottoNumber = createLottoNumber(winningLotto);
            i++;
        }
        if (Objects.isNull(lottoNumber)) {
            throw new IllegalArgumentException(INPUT_BONUS_NUMBER_MAX_TRY_MESSAGE);
        }
        return lottoNumber;
    }

    private static Money createMoney() {
        try {
            return Money.create(inputMoneyRawString());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private static LottoNumbers createLottoNumbers() {
        try {
            return LottoNumbers.create(inputWinningNumbersRawString());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private static LottoNumber createLottoNumber(Lotto winningLotto) {
        try {
            LottoNumber bonusLottoNumber = LottoNumber.createBonusLottoNumber(inputBonusNumberRawString());
            checkBonusLottoNumber(winningLotto, bonusLottoNumber);
            return bonusLottoNumber;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private static String inputMoneyRawString() {
        System.out.println(INPUT_MONEY_TEXT);
        return scanner.nextLine();
    }

    private static String inputWinningNumbersRawString() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS);
        return scanner.nextLine();
    }

    private static String inputBonusNumberRawString() {
        System.out.println(INPUT_BONUS_NUMBER);
        return scanner.nextLine();
    }

    private static void checkBonusLottoNumber(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        if (winningLotto.isMatchBonus(bonusLottoNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER);
        }
    }
}
