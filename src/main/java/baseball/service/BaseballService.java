package baseball.service;

import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballService {

    private final BaseballValidator baseballValidator = new BaseballValidator();


    public Set<Integer> setTargetNum(int min, int max, int count) {
        Set<Integer> targetNumSet = new HashSet<>();

        while (targetNumSet.size() < count) {
            int randomNum = pickNumberInRange(min, max);
            targetNumSet.add(randomNum); // 중복되지 않도록 HashSet에 추가
        }

        return targetNumSet;
    }

    public void validatePickedNum(int pickedNumber) {
        baseballValidator.isThreeDigitNumber(pickedNumber);
        baseballValidator.hasDuplicateDigits(pickedNumber);
    }
}
