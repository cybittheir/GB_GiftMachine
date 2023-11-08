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

}
