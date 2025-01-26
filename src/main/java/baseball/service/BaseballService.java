package baseball.service;

import baseball.Result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballService {

    private final BaseballValidator baseballValidator = new BaseballValidator();

    public List<Integer> setTargetNum(int min, int max, int count) {
        Set<Integer> targetNumSet = new HashSet<>();

        while (targetNumSet.size() < count) {
            int randomNum = pickNumberInRange(min, max);
            targetNumSet.add(randomNum); // 중복되지 않도록 HashSet에 추가
        }

        List<Integer> targetNumList = new ArrayList<>(targetNumSet);
        return targetNumList;
    }

    public int validatePickedNum(int pickedNumber) {
        baseballValidator.isThreeDigitNumber(pickedNumber);
        baseballValidator.hasDuplicateDigits(pickedNumber);

        return pickedNumber;
    }

    public List<Integer> convertToList(int pickedNumber) {
        List<Integer> numberList = new ArrayList<>();

        while (pickedNumber > 0) {
            numberList.add(0, pickedNumber % 10);
            pickedNumber /= 10;
        }

        return numberList;
    }

    public Result getNumberResult(List<Integer> targetNumList, List<Integer> pickedNumList) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < pickedNumList.size(); i++) {
            if (pickedNumList.get(i).equals(targetNumList.get(i))) {
                strike++;
            } else if (targetNumList.contains(pickedNumList.get(i))) {
                ball++;
            }
        }

        return new Result(strike, ball);
    }

    public void baseballRestart(int num) {
        if (num == 2) {
            System.exit(0);
        }
    }

}
