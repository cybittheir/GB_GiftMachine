package gift_machine.ui.commands;

import gift_machine.ui.ConsoleUI;

public class RaffleGifts extends Command{

    public RaffleGifts(ConsoleUI consoleUI){

        super("TODO: A Raffle",consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().raffle();
    }
}
