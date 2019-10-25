package animals;

import java.io.Serializable;
import java.util.UUID;

public abstract class Animal implements Serializable {
    private String uid;
    private String name;
    private Food food;

    Animal(String name) {
        this.name = name;
        uid = UUID.randomUUID().toString();
    }

    Animal(String name, String uid) {
        this.name = name;
        this.uid = uid;
    }

    Animal(String name, String foodType, int foodAmount) {
        this.name = name;
        uid = UUID.randomUUID().toString();
        food = new Food(foodType, foodAmount);
    }

    Animal(String name, String uid, String foodType, int foodAmount) {
        this.name = name;
        this.uid = uid;
        food = new Food(foodType, foodAmount);
    }

    @Override
    public String toString() {
        return "UID = " + uid + ", name = " + name + ", type = " + getClass().getSimpleName() + ", food : " + food;
    }

    abstract Food calculateFood();

    public String getName() {
        return name;
    }

    public Food getFood() {
        return food == null ? food = calculateFood() : food;
    }

    public String getUid() {
        return uid;
    }


    public static class Food implements Serializable {
        private String type;
        private int amount;

        Food(String type, int amount) {
            this.amount = amount;
            this.type = type;
        }

        @Override
        public String toString() {
            return "Type of food = " + type + ", amount = " + amount;
        }

        public int getAmount() {
            return amount;
        }

        public String getType() {
            return type;
        }
    }
}
