package baseball.service;

import baseball.Result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    public int validatePickedNum(int pickedNumber) {
        baseballValidator.isThreeDigitNumber(pickedNumber);
        baseballValidator.hasDuplicateDigits(pickedNumber);

        return pickedNumber;
    }

    public Result getNumberResult(Set<Integer> targetNumSet, List<Integer> pickedNumSet) {
        int strike = 0;
        int ball = 0;

        List<Integer> targetNumList = new ArrayList<>(targetNumSet);

        for (int i = 0; i < pickedNumSet.size(); i++) {
            if (pickedNumSet.get(i).equals(targetNumList.get(i))) {
                strike++;
            } else if (targetNumList.contains(pickedNumSet.get(i))) {
                ball++;
            }
        }

        return new Result(strike, ball);
    }


}
