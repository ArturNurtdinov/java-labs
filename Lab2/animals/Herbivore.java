package animals;

public class Herbivore extends Animal {
    public Herbivore(String name) {
        super(name);
    }

    public Herbivore(String name, String foodType, int foodAmount) {
        super(name, foodType, foodAmount);
    }

    public Herbivore(String name, String uid) {
        super(name, uid);
    }

    public Herbivore(String name, String uid, String foodType, int foodAmount) {
        super(name, uid, foodType, foodAmount);
    }

    @Override
    Food calculateFood() {
        return new Food("HERBS", 100);
    }
}
