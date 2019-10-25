package animals;

public class Carnivore extends Animal {
    public Carnivore(String name) {
        super(name);
    }

    @Override
    int calculateFoodAmount() {
        return 1000;
    }
}
