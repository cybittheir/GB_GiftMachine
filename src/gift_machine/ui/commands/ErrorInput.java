package gift_machine.ui.commands;
import gift_machine.ui.ConsoleUI;
public class ErrorInput extends Command{

    public ErrorInput(ConsoleUI consoleUI){
        super("Wrong data. Repeat, please",consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}
