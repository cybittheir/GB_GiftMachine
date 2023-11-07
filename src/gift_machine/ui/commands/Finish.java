package gift_machine.ui.commands;

import gift_machine.ui.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI){
        super("Exit",consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}
