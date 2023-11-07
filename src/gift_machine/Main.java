package gift_machine;

import gift_machine.ui.BaseUI;
import gift_machine.ui.ConsoleUI;
public class Main {
    public static void main(String[] args) {

        BaseUI baseUI = new ConsoleUI();
        baseUI.start();

    }
}