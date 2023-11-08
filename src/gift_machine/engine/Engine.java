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
}
