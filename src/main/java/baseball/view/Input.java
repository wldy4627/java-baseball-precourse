package baseball.view;

import java.util.Scanner;

public class Input {

    Scanner scan = new Scanner(System.in);

    public int scanPickedNumbers() {
        return Integer.parseInt(scan.nextLine());
    }

    public int baseballRestartChoice() {
        return Integer.parseInt(scan.nextLine());
    }
}
