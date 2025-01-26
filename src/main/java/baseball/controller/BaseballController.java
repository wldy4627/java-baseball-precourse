package baseball.controller;

import baseball.Result;
import baseball.service.BaseballService;
import baseball.view.Input;
import baseball.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BaseballController {

    private final BaseballService baseballService;
    private final Output output;
    private final Input input;

    public BaseballController(BaseballService baseballService, Output output, Input input) {
        this.baseballService = baseballService;
        this.output = output;
        this.input = input;
    }

    public void run() {

        while (true) {
            // targetNum 설정
            Set<Integer> targetNumSet = baseballService.setTargetNum(1, 9, 3);

            // 시도 숫자 입력받기
            output.printPickNumbers();
            int pickedNumber = baseballService.validatePickedNum(input.scanPickedNumbers());
            List<Integer> pickedNumList = new ArrayList<>(pickedNumber);

            // 입력 숫자 결과 출력
            Result result = baseballService.getNumberResult(targetNumSet, pickedNumList);
            output.printBaseballResult(result);

            output.printBaseballRestart();
            baseballService.baseballRestart(input.baseballRestartChoice());
        }
    }
}
