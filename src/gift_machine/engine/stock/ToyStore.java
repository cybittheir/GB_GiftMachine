package gift_machine.engine.stock;

import java.io.Serializable;
import java.sql.Array;
import java.time.LocalDate;
import java.util.*;

public class ToyStore<T extends Stock<T>> implements Serializable, Iterable<T>{
    private List<T> stock;
    private List<String> ticketsList;
    public List<T> raffleItems;
    public ToyStore(List<T> stock){

        this.stock = stock;
    }
    public ToyStore(){

        this(new ArrayList<T>());
    }
    public void addToy(T toy) {
        stock.add(toy);
    }
    public void clear(){
        stock.clear();
    }

    public long setNextID(){
        long id = 0;
        for (T record: stock){
            if (id < record.getID()){
                id = record.getID();
            }
        }
        return id + 1;
    }

    public String getFullStockInfo(){
        StringBuilder sB = new StringBuilder();
        sB.append("\n============\n");
        sB.append("Full Toys Stock:\n");
        sB.append("============\n");
        for (T toy: stock){
            sB.append(toy.getID());
            sB.append(". ");
            sB.append((toy.getType()));
            sB.append(" ");
            sB.append(toy.getName());
            sB.append(" - ");
            sB.append(toy.getAmount());
            sB.append("шт. / макс. частота выпадений - ");
            sB.append(toy.getRaffleFreq());
            sB.append("%;");
            sB.append("\n------------\n");
        }

        return sB.toString();
    }

    public int getAvailableMax(){
        int result = 10000000;
        int availableMax = 0;
        for (T toy: stock){
            availableMax = (toy.getAmount()*100)/toy.getRaffleFreq();
            if (result > availableMax) {
                result = availableMax;
            }
        }
        return result;
    }

    public List<T> getRaffleItems(){
        raffleItems = new ArrayList<>();
        int fullListCount = getAvailableMax();
        int useItems;
        for (T toy: stock){
            useItems = toy.getRaffleFreq()*fullListCount/100;
            for (int i =0; i<useItems;i++){
                raffleItems.add(toy);
            }
        }
        return raffleItems;
    }

    public void makeRaffle(){
        raffleItems= getRaffleItems();
        int tickets = getAvailableMax() + 1;
        ArrayList<String> ticketsList = new ArrayList<String>();
        this.ticketsList = ticketsList;
        for (int i = 0; i < tickets; i++){
            this.ticketsList.add("");
        }
        String ticket = "0";
        Random rand = new Random();
        ArrayList<String> winners = new ArrayList<String>();
        boolean ticketOK = false;
        for (T toy: raffleItems) {
            while (!ticketOK){
                ticket = Integer.toString(rand.nextInt(tickets));
                if (!ticket.equals("0") && !winners.contains(ticket)) {
                    ticketOK = true;
                }
                if (ticketOK){
                    winners.add(ticket);
                    int winTicket = Integer.parseInt(ticket);
                    this.ticketsList.set(winTicket,Long.valueOf(toy.getID()).toString());
                }
            }
            ticketOK = false;
        }

    }


    public void showWinTickets(){
        if (isResult()) {
            System.out.println("=======================");
            System.out.println("Winners:");
            System.out.println("=======================");

            String winTicketList = winList();
            if (winTicketList.equals("")){
                System.out.println("Wrong Frequency and Amount parameters for a successfull Raffle.\nCorrect them and try again.");
                resetResult();
            } else {
                System.out.println(winTicketList);

                System.out.println("=======================");
                System.out.println("Win/Total");
                String[] winCount = winTicketList.split("\n");

                System.out.println(winCount.length + "/" + this.ticketsList.size());
            }
            System.out.println("=======================");
        } else {
            System.out.println("=======================");
            System.out.println("No Results. make Raffle first");
            System.out.println("=======================");
        }

    }

    public boolean isResult(){
        if (this.ticketsList == null || this.ticketsList.isEmpty()){
            return false;
        } else {return true;}
    }

    public void resetResult(){
        this.ticketsList.clear();
    }

    public void removeGifts(){
        if (isResult()) {
            for (T toy: raffleItems) {
                toy.setAmount(toy.getAmount()-1);
                if (toy.getAmount() == 0){
                    stock.remove(toy);
                }
            }


        }
    }

    public String winList (){
        StringBuilder sB = new StringBuilder();
        if (isResult()) {
            for (int ind = 0; ind < this.ticketsList.size(); ind++) {
                if (this.ticketsList.get(ind) != "") {
                    sB.append("Билет №" + ind + ": " + getUnitinfo(Integer.valueOf(this.ticketsList.get(ind))) + "(" + this.ticketsList.get(ind) + ")\n");

                }
            }
        } else {
            sB.append("No result");
        }
        return sB.toString();
    }
    public String getUnitName(long id) {
        String result = "";
        for (T toy: stock){
            if (toy.getID() == id) {
                result = toy.getName();
            }
        }
        return result;
    }
    public String getUnitType(long id) {
        String result = "";
        for (T toy: stock){
            if (toy.getID() == id) {
                result = toy.getType();
            }
        }
        return result;
    }

    public Integer getUnitAmount(long id) {
        int result = -1;
        for (T toy: stock){
            if (toy.getID() == id) {
                result = toy.getAmount();
            }
        }
        return result;
    }

    public String getUnitinfo(long id){
        String result = "";
        for (T toy: stock){
            if (toy.getID() == id) {
                result = toy.getName() + ", " + toy.getType();
            }
        }
        return result;

    }
    public Integer getUnitFrequency(long id) {
        int result = 0;
        for (T toy: stock){
            if (toy.getID() == id) {
                result = toy.getRaffleFreq();
            }
        }
        return result;
    }

    public void changeUnitFrequency(long id, int freq){
        for (T toy: stock){
            if (toy.getID() == id) {
                toy.setRaffleFreq(freq);
            }
        }
    }

    public boolean checkUnitID(long id) {
        boolean result = false;
        for (T toy: stock){
            if (toy.getID() == id) {
                result  = true;
            }
        }
        return result;
    }

    public String getUnitStockInfo(long id){
        StringBuilder sB = new StringBuilder();
        sB.append("\n============\n");
        sB.append("Toy ");
        sB.append(id);
        sB.append(" Info:\n");
        sB.append("============\n");
        int count = 0;
        for (T toy: stock){
            if (toy.getID() == id) {
                sB.append(toy.getID());
                sB.append(". ");
                sB.append((toy.getType()));
                sB.append(" ");
                sB.append(toy.getName());
                sB.append(" - ");
                sB.append(toy.getAmount());
                sB.append("шт. / макс. частота выпадений - ");
                sB.append(toy.getRaffleFreq());
                sB.append("%");
                sB.append("\n------------\n");
                count++;
            }
        }
        if (count > 0) {
            return sB.toString();
        } else {
            return "";
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ToyStoreIterator(stock);
    }


}
