package gift_machine.engine.stock;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;

public class ToyStore<T extends Stock<T>> implements Serializable, Iterable<T>{
    private List<T> stock;

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
            sB.append("%");
            sB.append("\n------------\n");
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
