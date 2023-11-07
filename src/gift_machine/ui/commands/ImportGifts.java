package gift_machine.ui.commands;
import gift_machine.ui.ConsoleUI;
public class ImportGifts extends Command{

    public ImportGifts(ConsoleUI consoleUI){
        super("TODO: Import Gifts (JSON)", consoleUI);
    }
    public void execute(){
        getConsoleUI().importGifts();
    }
}
