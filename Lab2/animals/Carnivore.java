package animals;

public class Carnivore extends Animal {
    public Carnivore(String name) {
        super(name);
    }

    @Override
    Food calculateFood() {
        return new Food("CARNI", 1000);
    }
}
