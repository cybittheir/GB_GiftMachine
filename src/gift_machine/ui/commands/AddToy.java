package gift_machine.ui.commands;

import gift_machine.ui.ConsoleUI;

public class AddToy extends Command{

    public AddToy(ConsoleUI consoleUI){

        super("Add Toy",consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addToy();
    }
}
