package gift_machine.gate;

import gift_machine.ui.BaseUI;
import gift_machine.engine.Engine;

import java.time.LocalDate;
public class Gate {
    private BaseUI baseUI;
    private Engine engine;

    public Gate(BaseUI baseUI){
        this.baseUI = baseUI;
        engine = new Engine();
    }

    public void initBase(){
        engine.getInit();
        engine.getBase();
    }

    public void getToyStore(){
        baseUI.printAnswer(engine.getStock());
    }

    public void addToy(String name, String type, int amount, int frequency){
        engine.addObjRecord(name, type, amount, frequency);
    }

    public void readToysList(){

    }

    public void saveToysList(){

    }

    public void getToyInfo(long id){
        baseUI.printAnswer(engine.getToyInfo(id));
    }

    public String getToyName(long id){
        return engine.getToyName(id);
    }

    public String getToyType(long id){
        return engine.getToyType(id);
    }

    public Integer getToyFrequency(long id){
        return engine.getToyFrequency(id);
    }


    public void editToyFrequency(long toyID,int raffleFrequency){

    }
    public boolean checkUnitID(long id){
        boolean result = engine.checkToyID(id);
        return result;
    }
}
