package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MONEY_TEXT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String COMMA = ",";

    private InputUtils() {
    }

    public static String inputMoney() {
        System.out.println(INPUT_MONEY_TEXT);
        return scanner.nextLine();
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS);
        ArrayList<Integer> winningNumbers = new ArrayList<>();
        for (String number : scanner.nextLine().split(COMMA)) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        return winningNumbers;
    }
}
