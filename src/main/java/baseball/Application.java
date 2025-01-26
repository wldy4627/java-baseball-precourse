package baseball;

import baseball.controller.BaseballController;
import baseball.service.BaseballService;
import baseball.view.Input;
import baseball.view.Output;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        BaseballService baseballService = new BaseballService();
        Output output = new Output();
        Input input = new Input();

        BaseballController baseballController = new BaseballController(baseballService, output, input);

        baseballController.run();
    }
}
