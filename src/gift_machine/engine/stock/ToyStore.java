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
            sB.append("шт. / макс. частота выпаданий - ");
            sB.append(toy.getRaffleFreq());
            sB.append("%");
            sB.append("\n------------\n");
        }

        return sB.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ToyStoreIterator(stock);
    }


}
