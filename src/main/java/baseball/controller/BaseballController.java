package baseball.controller;

import baseball.service.BaseballService;

import java.util.Set;

public class BaseballController {

    private final BaseballService baseballService;

    public BaseballController(BaseballService baseballService) {
        this.baseballService = baseballService;
    }

    public void run() {
        Set<Integer> targetNumSet = baseballService.setTargetNum(1, 9, 3);

    }
}
