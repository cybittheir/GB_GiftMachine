package gift_machine.ui;

import gift_machine.gate.Gate;
import gift_machine.engine.stock.ToyStore;
import java.util.Scanner;
public class ConsoleUI implements BaseUI{
    private Gate gate;
    private MainMenu menu;
    private boolean workOn;
    private Scanner scanner;

    public ConsoleUI(){
        gate = new Gate(this);
        scanner = new Scanner(System.in);
        menu = new MainMenu(this);
        workOn = true;
    }

    @Override
    public void start() {
        while (workOn){
            System.out.println(menu.menu());
            String choice = scanner.nextLine();
            if (choice.matches("^[0-9]$")){
                int choiceInt = Integer.parseInt(choice);
                menu.execute(choiceInt);
            } else {errorInput();}

        }
    }

    public void finish() {
        System.out.println("----------------\nFinished. Bye");
        workOn = false;
        System.exit(0);
    }

    public void showToys(){
        gate.getToyStore();
    }

    private void errorInput() {
        System.out.println("------------------------\nWrong data. Try again.\n------------------------\n");
    }

    public void exportResult(){
//        gate.saveResult();
    }

    public void exportToysList(){
        gate.saveToysList();
    }
    public void importToysList(){
        gate.readToysList();
    }

    public void editGiftFrequency(){

    }
    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

}
