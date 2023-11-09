package gift_machine.ui.commands;

import gift_machine.ui.ConsoleUI;

public class ExportToysList extends Command{
    public ExportToysList(ConsoleUI consoleUI){

        super("Export Toys List (DUMP/JSON)",consoleUI);
    }
    public void execute (){
        getConsoleUI().exportToysList();
    }
}
