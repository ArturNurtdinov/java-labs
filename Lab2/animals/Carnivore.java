package animals;

import java.util.UUID;

public class Carnivore extends Animal {
    public Carnivore(String uid, String name) {
        this.uid = uid;
        this.name = name;
        foodAmount = -1;
    }

    public Carnivore(String name) {
        this.name = name;
        uid = UUID.randomUUID().toString();
        foodAmount = -1;
    }

    @Override
    int calculateFoodAmount() {
        return 1000;
    }
}
