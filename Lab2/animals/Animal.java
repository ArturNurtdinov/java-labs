package animals;

import java.io.Serializable;
import java.util.UUID;

public abstract class Animal implements Serializable {
    private String uid;
    private String name;
    private int foodAmount;

    Animal(String name) {
        this.name = name;
        uid = UUID.randomUUID().toString();
        foodAmount = -1;
    }

    @Override
    public String toString() {
        return "UID = " + uid + ", name = " + name + ", type = " + getClass().getSimpleName() + ", food = " + foodAmount;
    }

    abstract int calculateFoodAmount();

    public String getName() {
        return name;
    }

    public int getFoodAmount() {
        return foodAmount == -1 ? foodAmount = calculateFoodAmount() : foodAmount;
    }

    public String getUid() {
        return uid;
    }
}
