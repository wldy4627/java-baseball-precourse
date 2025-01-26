package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int scanPickedNumbers() {
        return Integer.parseInt(Console.readLine());
    }

    public int baseballRestartChoice() {
        return Integer.parseInt(Console.readLine());
    }
}
