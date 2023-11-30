package gift_machine.ui.commands;

import gift_machine.ui.ConsoleUI;

public class RaffleGifts extends Command{

    public RaffleGifts(ConsoleUI consoleUI){

        super("A Raffle",consoleUI);


    }

    @Override
    public void execute() {
        if (getConsoleUI().isResult()){
            System.out.println("*******************************************************************");
            System.out.println("* New Raffle is not possible before previous results will be saved *");
            System.out.println("********************************************************************");
        } else {
            getConsoleUI().raffle();
        }
    }
}
