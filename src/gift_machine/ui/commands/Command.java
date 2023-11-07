package gift_machine.ui.commands;
import gift_machine.ui.ConsoleUI;

public abstract class Command implements MCommand{
    private String description;
    private ConsoleUI consoleUI;

    public Command (String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    ConsoleUI getConsoleUI() {
        return consoleUI;
    }
    public String getDescription() {
        return description;
    }
}
