package gift_machine.engine.stock;

public class Ticket {

    private String number;

    private String giftId;

    public Ticket(String number,String giftId){
        this.number = number;
        this.giftId = giftId;
    }

    public void setWinner(String number,String giftId){

    }

    public String getNumber(){return number;}
    public String getGiftId(){return giftId;}
}
