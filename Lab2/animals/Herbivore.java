package animals;

public class Herbivore extends Animal {
    public Herbivore(String name) {
        super(name);
    }

    public Herbivore(String name, String uid) {
        super(name, uid);
    }

    @Override
    Food calculateFood() {
        return new Food("HERB", 100);
    }
}
