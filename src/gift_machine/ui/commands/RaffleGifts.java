package gift_machine.ui.commands;

import gift_machine.ui.ConsoleUI;

public class RaffleGifts extends Command{

    public RaffleGifts(ConsoleUI consoleUI){

        super("TODO: Raffle Gifts",consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}
