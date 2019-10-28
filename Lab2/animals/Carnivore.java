package animals;

public class Carnivore extends Animal {
    public Carnivore(String name) {
        super(name);
    }

    public Carnivore(String name, String uid) {
        super(name, uid);
    }

    public Carnivore(String name, String foodType, int foodAmount) {
        super(name, foodType, foodAmount);
    }

    public Carnivore(String name, String uid, String foodType, int foodAmount) {
        super(name, uid, foodType, foodAmount);
    }

    @Override
    Food calculateFood() {
        return new Food("MEAT", 1000);
    }
}
