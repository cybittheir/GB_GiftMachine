package gift_machine.engine.stock;

import java.util.List;
public interface Stock<T> {
    String getName();
    String getType();
    long getID();
    int getRaffleFreq();

    void setRaffleFreq(int freg);
    int getAmount();

    void setAmount(int amount);

}
