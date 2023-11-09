package gift_machine.ui.commands;
import gift_machine.ui.ConsoleUI;
public class ImportToysList extends Command{

    public ImportToysList(ConsoleUI consoleUI){

        super("Import Toys List (DUMP/JSON)", consoleUI);
    }
    public void execute(){

        getConsoleUI().importToysList();
    }
}
