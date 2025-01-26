package baseball.view;

import baseball.Result;

public class Output {

    public void printPickNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public void printBaseballResult(Result result) {
        if (result.getStrike() == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (result.getStrike() == 0 && result.getBall() == 0) {
            System.out.println("낫싱");
        } else {
            if (result.getBall() > 0) {
                System.out.println(result.getBall() + "볼 ");
            }
            if (result.getStrike() > 0) {
                System.out.println(result.getStrike() + "스트라이크");
            }
            System.out.println();
        }
    }
}
