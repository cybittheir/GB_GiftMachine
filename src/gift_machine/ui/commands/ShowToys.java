package gift_machine.ui.commands;

import gift_machine.ui.ConsoleUI;

public class ShowToys extends Command{
    public ShowToys(ConsoleUI consoleUI){

        super("Show Toys",consoleUI);
    }

    @Override
    public void execute() {

        getConsoleUI().showToys();
    }
}
