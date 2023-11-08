package gift_machine.ui.commands;

import gift_machine.ui.ConsoleUI;

public class DeleteToy extends Command{

    public DeleteToy(ConsoleUI consoleUI){

        super("TODO: Delete Toy",consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}
