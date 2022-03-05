package lotto.utils;

import java.util.Scanner;

public class InputUtils {
    private static final String LOTTO_START_INPUT = "구입금액을 입력해 주세요.";
    private static final String LOTTO_WINNING_NUMBER_INPUT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner sc = new Scanner(System.in);

    public static int lottoStartInput() {
        System.out.println(LOTTO_START_INPUT);
        return sc.nextInt();
    }

    public static String lottoWinningNumberInput() {
        System.out.println(LOTTO_WINNING_NUMBER_INPUT);
        sc.nextLine();
        return sc.nextLine();
    }
}
