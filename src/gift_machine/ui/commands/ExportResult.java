package gift_machine.ui.commands;

import gift_machine.ui.ConsoleUI;

public class ExportResult extends Command{

    public ExportResult(ConsoleUI consoleUI){

        super("TODO: Export Prizes List",consoleUI);
    }

    @Override
    public void execute() {
        if (getConsoleUI().isResult()){
            getConsoleUI().exportResult();
        } else {
            System.out.println("*****************************************");
            System.out.println("* Start A Raffle first. Nothing to save *");
            System.out.println("*****************************************");
        }
    }
}
