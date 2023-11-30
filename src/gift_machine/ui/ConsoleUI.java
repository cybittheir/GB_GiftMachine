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
        gate.initBase();
        System.out.println("\n --=== ToyStock loaded === -- \n");
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

    public void addToy(){
        String type = getType();
        String name = getName();
        int amount = getAmount();
        int frequency = getFrequency();
        gate.addToy(name,type,amount,frequency);
        StringBuilder sB = new StringBuilder();
        sB.append("NEW Toy - ");
        sB.append(type);
        sB.append(" ");
        sB.append(name);
        sB.append(" (");
        sB.append(amount);
        sB.append(" шт.; raffle frequency - ");
        sB.append(frequency);
        sB.append("%) ADDED\n");
        inputSuccess(sB.toString());
    }

    public void showToys(){
        gate.getToyStore();
    }

    private void errorInput() {
        System.out.println("------------------------\nWrong data. Try again.\n------------------------\n");
    }

    public void exportToysList(){
        gate.saveToysList();
    }
    public void importToysList(){
        gate.readToysList();
    }

    public void editGiftFrequency(){
        long tid = getToyID();
        if (gate.checkUnitID(tid)){
            gate.getToyInfo(tid);
            int frequency = getFrequency();
            gate.editToyFrequency(tid,frequency);
            StringBuilder sB = new StringBuilder();
            sB.append("Toy - ");
            sB.append(gate.getToyType(tid));
            sB.append(" ");
            sB.append(gate.getToyName(tid));
            sB.append(", ");
            sB.append(gate.getToyFrequency(tid));
            sB.append("% - raffle frequency CHANGED\n");

            inputSuccess(sB.toString());
        } else {errorInput();}
    }

    public void exportResult(){
        gate.saveRaffleResult();
    }

    public void raffle(){
        gate.getRaffleItemsList();
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    private String getName(){
        String result = "";
        while (result =="") {
            System.out.println("Название игрушки: ");
            result =scanner.nextLine();
            if (result ==""){errorInput();}
        }

        return result;
    }

    private String getType(){
        String result = "";
        while (result =="") {
            System.out.println("Категория игрушки: ");
            result =scanner.nextLine();
            if (result ==""){errorInput();}
        }

        return result;
    }

    private int getToyID(){
        int result = -1;
        while (result < 0) {
            System.out.println("Введите ID игрушки: ");
            String tmp=scanner.nextLine();
            if (tmp!="" && tmp.matches("^[0-9]*$")){
                result = Integer.parseInt(tmp);
            } else {errorInput();}
        }
        return result;
    }

    public boolean isResult(){
        return gate.isResult();
    }

    private int getAmount(){
        int result = 0;
        while (result <= 0) {
            System.out.println("Количество (шт.): ");
            String tmp=scanner.nextLine();
            if (tmp != "" && tmp.matches("^[0-9]*$")){
                result = Integer.parseInt(tmp);
            } else {errorInput();}
        }
        return result;
    }

    private int getFrequency(){
        int result = 0;
        while (result <= 0 || result > 9) {
            System.out.println("Частота выпадений (%, <10%): ");
            String tmp=scanner.nextLine();
            if (tmp.matches("^[0-9]$")){
                result = Integer.parseInt(tmp);
            } else {errorInput();}
        }
        return result;
    }

    private void inputSuccess(String info){
        System.out.println("*---------------");
        System.out.printf("* %s", info);
        System.out.println("* Database Dump saved");
        System.out.println("*----------------");

    }

}
