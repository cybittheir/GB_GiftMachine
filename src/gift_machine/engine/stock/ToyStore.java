package gift_machine.engine.stock;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class ToyStore<T extends Stock<T>> implements Serializable, Iterable<T>{
    private List<T> stock;
    private int availableMax;
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

    public List<String> getRaffleItemsList(){
        raffleItems= getRaffleItems();
        int tickets = getAvailableMax() + 1;
        ArrayList<String> items = new ArrayList<String>();
        for (int i = 0; i < tickets; i++){
            items.add("");
        }
        String ticket = "0";
        Random rand = new Random();
        ArrayList<String> winners = new ArrayList<String>();
        System.out.println("=======================");
        System.out.println("Winners:");
        System.out.println("=======================");
        for (T toy: raffleItems) {
            while (ticket == "0" || ticket.equals(winners)){
                ticket = Integer.toString(rand.nextInt(tickets));
            }
            winners.add(ticket);
            int winTicket =Integer.parseInt(ticket);
            int giftId = Long.valueOf(toy.getID()).intValue();
            items.set(winTicket,Long.valueOf(toy.getID()).toString());
            ticket = "0";
        }
        String gift ="";

        for (int ind = 0; ind < items.size(); ind++){
            if (items.get(ind) !="") {
                System.out.println("Билет №" + ind + ": " + getUnitName(Integer.valueOf(items.get(ind))) + ", " + getUnitType(Integer.valueOf(items.get(ind))) + "(" +  items.get(ind) + ")");

            }
        }
        System.out.println("=======================");
        System.out.println("win/total");
        System.out.println(winners.size() + "/" + tickets);
        System.out.println("=======================");

        return items;
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

    private void RaffleGifts(){

    }

    @Override
    public Iterator<T> iterator() {
        return new ToyStoreIterator(stock);
    }


}
