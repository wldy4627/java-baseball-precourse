package baseball.controller;

import baseball.service.BaseballService;
import baseball.view.Input;
import baseball.view.Output;

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
        Set<Integer> targetNumSet = baseballService.setTargetNum(1, 9, 3);

        output.printPickNumbers();
        baseballService.validatePickedNum(input.scanPickedNumbers());
    }
}
