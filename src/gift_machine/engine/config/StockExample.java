package gift_machine.engine.config;

import gift_machine.engine.stock.ToyStore;
import gift_machine.engine.toy.Toy;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class StockExample {
    private ToyStore<Toy> toyStore;

    public StockExample(){
        toyStore = new ToyStore<>();
    }

    public static ToyStore<Toy> makePreviewList(){
        ToyStore<Toy> toyStore = new ToyStore<>();

        Toy pos1 = new Toy("Маша", "кукла",12,4);
        Toy pos2 = new Toy("Lego MainCraft", "конструктор",6,2);
        Toy pos3 = new Toy("Lego StarWars", "конструктор",5,2);
        Toy pos4 = new Toy("Monopoly", "настольная игра",8,3);
        Toy pos5 = new Toy("Набор для выжигания", "наборы для творчества",5,3);
        Toy pos6 = new Toy("Porsche", "масштабные модели",10,3);
        Toy pos7 = new Toy("Toyota Celica", "масштабные модели",15,4);

        toyStore.addToy(pos1);
        toyStore.addToy(pos2);
        toyStore.addToy(pos3);
        toyStore.addToy(pos4);
        toyStore.addToy(pos5);
        toyStore.addToy(pos6);
        toyStore.addToy(pos7);

        return toyStore;
    }
}
