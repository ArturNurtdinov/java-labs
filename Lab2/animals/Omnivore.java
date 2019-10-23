package animals;

import java.util.UUID;

public class Omnivore extends Animal {
    public Omnivore(String uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public Omnivore(String name) {
        this.name = name;
        uid = UUID.randomUUID().toString();
    }

    @Override
    int calculateFoodAmount() {
        return 500;
    }
}
