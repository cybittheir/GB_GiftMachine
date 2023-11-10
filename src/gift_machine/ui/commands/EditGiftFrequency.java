package gift_machine.ui.commands;

import gift_machine.ui.ConsoleUI;

public class EditGiftFrequency extends Command{

    public EditGiftFrequency(ConsoleUI consoleUI){

        super("Edit Gift Frequency",consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().editGiftFrequency();
    }
}
