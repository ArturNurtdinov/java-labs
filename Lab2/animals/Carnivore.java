package animals;

import java.util.UUID;

public class Carnivore extends Animal {
    public Carnivore(String uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public Carnivore(String name) {
        this.name = name;
        uid = UUID.randomUUID().toString();
    }

    @Override
    int calculateFoodAmount() {
        return 1000;
    }
}
