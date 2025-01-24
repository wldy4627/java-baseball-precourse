package baseball;

import baseball.controller.BaseballController;
import baseball.service.BaseballService;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        BaseballService baseballService = new BaseballService();

        BaseballController baseballController = new BaseballController(baseballService);

        baseballController.run();
    }
}
