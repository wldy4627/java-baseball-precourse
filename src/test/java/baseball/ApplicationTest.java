package baseball;

import baseball.controller.BaseballController;
import baseball.service.BaseballService;
import baseball.view.Input;
import baseball.view.Output;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 스트라이크_테스트() {
        List<Integer> targetNumList = List.of(1, 2, 3);
        List<Integer> pickedNumList = List.of(1, 5, 6);

        BaseballService baseballService = new BaseballService();

        Result result = baseballService.getNumberResult(targetNumList, pickedNumList);

        assertEquals(1, result.getStrike());
        assertEquals(0, result.getBall());
    }

    @Test
    void 볼_테스트() {
        List<Integer> targetNumList = List.of(1, 2, 3);
        List<Integer> pickedNumList = List.of(3, 1, 6);

        BaseballService baseballService = new BaseballService();

        Result result = baseballService.getNumberResult(targetNumList, pickedNumList);

        assertEquals(0, result.getStrike());
        assertEquals(2, result.getBall());
    }

    @Test
    void 스크라이크_볼_테스트() {
        List<Integer> targetNumList = List.of(1, 2, 3);
        List<Integer> pickedNumList = List.of(1, 3, 2);

        BaseballService baseballService = new BaseballService();

        Result result = baseballService.getNumberResult(targetNumList, pickedNumList);

        assertEquals(1, result.getStrike());
        assertEquals(2, result.getBall());
    }

    @Test
    void 낫싱_테스트() {
        List<Integer> targetNumList = List.of(1, 2, 3);
        List<Integer> pickedNumList = List.of(5, 7, 6);

        BaseballService baseballService = new BaseballService();

        Result result = baseballService.getNumberResult(targetNumList, pickedNumList);

        assertEquals(0, result.getStrike());
        assertEquals(0, result.getBall());
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
