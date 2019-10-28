package animals;

public class Omnivore extends Animal {
    public Omnivore(String name) {
        super(name);
    }

    public Omnivore(String name, String uid) {
        super(name, uid);
    }

    public Omnivore(String name, String foodType, int foodAmount) {
        super(name, foodType, foodAmount);
    }

    public Omnivore(String name, String uid, String foodType, int foodAmount) {
        super(name, uid, foodType, foodAmount);
    }

    @Override
    Food calculateFood() {
        return new Food("ANY", 500);
    }
}
