package gift_machine.engine.stock;

import java.time.LocalDate;
import java.util.List;
public interface Stock<T> {
    String getName();
    String getType();
    long getID();
    int getRaffleFreq();
    int getAmount();
}
