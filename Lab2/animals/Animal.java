package animals;

import java.io.Serializable;

public abstract class Animal implements Serializable {
    String uid;
    String name;
    int foodAmount;

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

    @Override
    public String toString() {
        return "UID = " + uid + ", name = " + name + ", type = " + getClass().getSimpleName() + ", food = " + foodAmount;
    }
}
