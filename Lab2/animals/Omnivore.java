package animals;

public class Omnivore extends Animal {
    public Omnivore(String name) {
        super(name);
    }

    @Override
    Food calculateFoodAmount() {
        return new Food("OMNI", 500);
    }
}
