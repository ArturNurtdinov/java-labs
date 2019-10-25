package animals;

public class Herbivore extends Animal {
    public Herbivore(String name) {
        super(name);
    }

    @Override
    Food calculateFood() {
        return new Food("HERB", 100);
    }
}
