package animals;

import java.util.UUID;

public class Omnivore extends Animal {
    public Omnivore(String uid, String name) {
        this.uid = uid;
        this.name = name;
        foodAmount = -1;
    }

    public Omnivore(String name) {
        this.name = name;
        uid = UUID.randomUUID().toString();
        foodAmount = -1;
    }

    @Override
    int calculateFoodAmount() {
        return 500;
    }
}
