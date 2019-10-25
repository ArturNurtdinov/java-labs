package animals;

public class Omnivore extends Animal {
    public Omnivore(String name) {
        super(name);
    }

    @Override
    int calculateFoodAmount() {
        return 500;
    }
}
