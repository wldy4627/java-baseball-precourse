package baseball.controller;

import baseball.Result;
import baseball.service.BaseballService;
import baseball.view.Input;
import baseball.view.Output;

import java.util.List;

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
        // targetNum 설정
        List<Integer> targetNumList = baseballService.setTargetNum(1, 9, 3);

        while (true) {
            // 시도 숫자 입력받기
            output.printPickNumbers();
            int pickedNumber = baseballService.validatePickedNum(input.scanPickedNumbers());
            List<Integer> pickedNumList = baseballService.convertToList(pickedNumber);

            // 입력 숫자 결과 출력
            Result result = baseballService.getNumberResult(targetNumList, pickedNumList);
            output.printBaseballResult(result);

            // 게임 재시작 물어보기
            if (result.getStrike() == 3) {
                output.printBaseballRestart();
                baseballService.baseballRestart(input.baseballRestartChoice());

                targetNumList = baseballService.setTargetNum(1, 9, 3);
            }
        }
    }
}
