package gift_machine.ui;

import java.time.LocalDate;
import java.util.Scanner;
public class ConsoleUI implements BaseUI{
    private MainMenu menu;
    private boolean workOn;
    private Scanner scanner;

    public ConsoleUI(){
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

    private void errorInput() {
        System.out.println("------------------------\nWrong data. Try again.\n------------------------\n");
    }

    public void exportGifts(){
//        presenter.getGifts();
    }
    public void importGifts(){
//        presenter.getGifts();
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

}
