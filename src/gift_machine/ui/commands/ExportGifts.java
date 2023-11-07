package gift_machine.ui.commands;

import gift_machine.ui.ConsoleUI;

public class ExportGifts extends Command{
    public ExportGifts(ConsoleUI consoleUI){
        super("TODO: Export Gifts (JSON)",consoleUI);
    }
    public void execute (){
        getConsoleUI().exportGifts();
    }
}
