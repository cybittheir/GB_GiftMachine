package gift_machine.ui.commands;

import gift_machine.ui.ConsoleUI;

public class ShowToyTypes extends Command{

    public ShowToyTypes(ConsoleUI consoleUI){

        super("TODO: Show Toy Types",consoleUI);
    }

    @Override
    public void execute() {

        getConsoleUI().finish();
    }
}
