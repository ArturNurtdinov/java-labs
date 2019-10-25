package animals;

public class Carnivore extends Animal {
    public Carnivore(String name) {
        super(name);
    }

    public Carnivore(String name, String uid) {
        super(name, uid);
    }

    @Override
    Food calculateFood() {
        return new Food("CARNI", 1000);
    }
}
