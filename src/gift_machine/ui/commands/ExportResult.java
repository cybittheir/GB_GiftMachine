package gift_machine.ui.commands;

import gift_machine.ui.ConsoleUI;

public class ExportResult extends Command{

    public ExportResult(ConsoleUI consoleUI){

        super("TODO: Export Result",consoleUI);
    }

    @Override
    public void execute() {

        getConsoleUI().exportResult();
    }
}
