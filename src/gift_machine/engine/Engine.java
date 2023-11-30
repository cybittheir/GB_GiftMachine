package gift_machine.engine;

import gift_machine.engine.config.BaseInit;
import gift_machine.engine.config.Config;
import gift_machine.engine.config.StockExample;
import gift_machine.engine.stock.ToyStore;
import gift_machine.engine.toy.Toy;
import gift_machine.engine.dump_file.FileHandler;

public class Engine {
    private ToyStore stock;

    private boolean initDone;
    private boolean exampleBase;

    public Engine(){
        initDone = false;
        stock = new ToyStore<>();
    }

    public String getInit(){
        BaseInit init = new Config();
        return init.baseInit();

    }

    public void getBase(){
        if (getInit() == null){
            stock = StockExample.makePreviewList();
            exampleBase = true;
        } else {
            readWorkDump();
            setIDCount();
            exampleBase = false;
        }
        if (stock != null){
            initDone = true;
        }

    }

    private void setIDCount(){
        Toy.setCount(stock.setNextID());
    }
    private void saveWorkDump(){
        FileHandler fileHandler = new FileHandler();
        fileHandler.saveDump(stock, getDump());
    }

    private void readWorkDump(){
        FileHandler fileHandler = new FileHandler();
        stock = (ToyStore) fileHandler.readDump(getInit());
    }

    public String getDump(){
        BaseInit init = new Config();
        return init.dumpFilePath();
    }

    public String getStock() {
        if (!initDone){getBase();}
        return stock.getFullStockInfo();
    }

    public void addObjRecord(String name, String type, int amount, int frequency) {
        if (exampleBase == true){
            stock.clear();
            Toy.nullCount();
            exampleBase = false;
        }
        Toy rec = new Toy(name, type, amount, frequency);
        stock.addToy(rec);
        saveWorkDump();

    }

    public String getToyInfo(long id){
        if (!initDone){getBase();}
        return stock.getUnitStockInfo(id);
    }

    public boolean checkToyID(long id) {
        boolean result = stock.checkUnitID(id);
        return result;
    }

    public String getToyName(long id) {
        String result = stock.getUnitName(id);
        return result;
    }

    public String getToyType(long id) {
        String result = stock.getUnitType(id);
        return result;
    }
    public Integer getToyFrequency(long id) {
        int result = stock.getUnitFrequency(id);
        return result;
    }

    public void updateUnitFrequency(long id,int freq) {
        stock.changeUnitFrequency(id,freq);
    }

    public Integer getAvailableMax(){
        return stock.getAvailableMax();
    }

    public void makeRaffle(){
        stock.makeRaffle();
    }

    public void showRaffleItemsList(){
        stock.showWinTickets();
    }

    public boolean isResult(){
        return stock.isResult();
    }


    public String getExport(){
        BaseInit init = new Config();
        return init.exportFilePath();
    }
    public void saveRaffleResult(){

        System.out.println("Сохранение результатов розыгрыша: ");
        FileHandler fileHandler = new FileHandler();
        if (fileHandler.saveResult(stock.winList(), getExport())){
            stock.resetResult();
        }

    }
}
