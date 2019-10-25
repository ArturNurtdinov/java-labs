package animals;

public class Omnivore extends Animal {
    public Omnivore(String name) {
        super(name);
    }

    @Override
    Food calculateFood() {
        return new Food("OMNI", 500);
    }
}
