package gift_machine.ui.commands;

import gift_machine.ui.ConsoleUI;

public class AddToyTypes extends Command{

    public AddToyTypes(ConsoleUI consoleUI){

        super("TODO: Add Toy Types",consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}
