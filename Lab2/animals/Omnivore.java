package animals;

public class Omnivore extends Animal {
    public Omnivore(String name) {
        super(name);
    }

    public Omnivore(String name, String uid) {
        super(name, uid);
    }

    @Override
    Food calculateFood() {
        return new Food("OMNI", 500);
    }
}
