package baseball.service;

import java.util.HashSet;
import java.util.Set;

public class BaseballValidator {

    public void isThreeDigitNumber(int pickedNumber) {
        if (pickedNumber < 100 || pickedNumber > 999) {
            throw new IllegalArgumentException("[ERROR] 숫자는 반드시 세자리여야 합니다.");
        }
    }

    public void hasDuplicateDigits(int pickedNumber) {
        String numStr = String.valueOf(pickedNumber);
        Set<Character> digits = new HashSet<>();

        for (char digit : numStr.toCharArray()) {
            if (!digits.add(digit)) {
                throw new IllegalArgumentException("[ERROR] 세자리 숫자는 중복되지 않아야 합니다.");
            }
        }
    }

}
