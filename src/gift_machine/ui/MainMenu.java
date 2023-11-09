package gift_machine.ui;

import gift_machine.ui.commands.*;
import java.util.ArrayList;
import java.util.List;
public class MainMenu {
    private List<Command> commandList;
    public MainMenu(ConsoleUI consoleUI){
        commandList = new ArrayList<>();
        commandList.add(new AddToy(consoleUI));
        commandList.add(new ShowToys(consoleUI));
//        commandList.add(new AddToyTypes(consoleUI));
//        commandList.add(new ShowToyTypes(consoleUI));
//        commandList.add(new EditToyTypes(consoleUI));
        commandList.add(new EditGiftFrequency(consoleUI));
//        commandList.add(new DeleteToy(consoleUI));
        commandList.add(new RaffleGifts(consoleUI));
        commandList.add(new ExportResult(consoleUI));
/** TODO: next time - import and export to JSON
        commandList.add(new ImportToysList(consoleUI));
        commandList.add(new ExportToysList(consoleUI));
 */
        commandList.add(new Finish(consoleUI));
    }

    public int getMenuSize(){
        return commandList.size();
    }
    public String menu(){
        StringBuilder sB = new StringBuilder();
        for (int i = 1; i < commandList.size();i++){
            sB.append(i);
            sB.append(". ");
            sB.append(commandList.get(i-1).getDescription());
            sB.append("\n");
        }
        sB.append("0. Exit\n");
        sB.append("========\n");
        sB.append("Your choice: ");
        return sB.toString();
    }

    public void execute(int choice){
        if (choice < getMenuSize() && choice > 0){
            Command command = commandList.get(choice - 1);
            command.execute();
        } else if(choice == 0){
            Command command = commandList.get(getMenuSize()-1);
            command.execute();
        }
    }

}
