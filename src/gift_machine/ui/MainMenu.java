package gift_machine.ui;

import gift_machine.ui.commands.*;
import java.util.ArrayList;
import java.util.List;
public class MainMenu {
    private List<Command> commandList;
    public MainMenu(ConsoleUI consoleUI){
        commandList = new ArrayList<>();
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
