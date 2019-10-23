package animals;

import java.util.UUID;

public class Herbivore extends Animal {
    public Herbivore(String uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public Herbivore(String name) {
        this.name = name;
        uid = UUID.randomUUID().toString();
    }

    @Override
    int calculateFoodAmount() {
        return 100;
    }
}
