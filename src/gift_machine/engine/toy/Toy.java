package gift_machine.engine.toy;

import gift_machine.engine.stock.Stock;

import java.io.Serializable;

public class Toy implements Serializable, Stock<Toy> {
    static long idc;
    private long id;
    private String toyName;
    private String toyType;
    private int amount;
    private int raffleFreq;

    public Toy(String toyName,String toyType, int amount, int raffleFreq){
        this.id = idc++;
        this.toyName = toyName;
        this.toyType = toyType;
        this.amount = amount;
        this.raffleFreq = raffleFreq;
    }

    public long getID(){return id;}

    public static void setCount(long id){
        idc = id;
    }
    public static void nullCount(){

        setCount(0);
    }

    public String getName(){
        return toyName;
    }

    public String getType(){
        return toyType;
    }

    public int getRaffleFreq(){
        return raffleFreq;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    public String getToyInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(getType());
        sb.append(getAmount());
        sb.append(getRaffleFreq());
        return sb.toString();
    }

    public void setRaffleFreq(int raffleFreq) {
        this.raffleFreq = raffleFreq;
    }

    public void setAmount(int amount){this.amount = amount;}

    @Override
    public String toString(){
        return getToyInfo();
    }

}
