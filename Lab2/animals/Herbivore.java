package animals;

import java.util.UUID;

public class Herbivore extends Animal {
    public Herbivore(String uid, String name) {
        this.uid = uid;
        this.name = name;
        foodAmount = -1;
    }

    public Herbivore(String name) {
        this.name = name;
        uid = UUID.randomUUID().toString();
        foodAmount = -1;
    }

    @Override
    int calculateFoodAmount() {
        return 100;
    }
}
