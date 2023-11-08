package gift_machine.engine.stock;

import gift_machine.engine.toy.Toy;

import java.util.Iterator;
import java.util.List;
public class ToyStoreIterator<T extends Toy> implements Iterator<T> {
    private int index;
    private List<T> stock;

    public ToyStoreIterator(List<T> stock){
        this.stock = stock;
    }

    @Override
    public boolean hasNext(){
        return stock.size() > index;
    }

    @Override
    public T next(){
        return stock.get(index++);
    }

}
