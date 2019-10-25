package animals;

public class Herbivore extends Animal {
    public Herbivore(String name) {
        super(name);
    }

    @Override
    int calculateFoodAmount() {
        return 100;
    }
}
