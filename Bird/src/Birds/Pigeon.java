package Birds;

import Bird.Bird;
import Bird.Flyable;
import FylingBehaviur.FylingBehaviour;

public class Pigeon extends Bird implements Flyable {
    private FylingBehaviour fb;

    public Pigeon(FylingBehaviour fb) {
        super("black", "caw", true);
        this.fb = fb;
    }

    public void walk() {
        System.out.println("Pigeon walking");
    }

    public void eat() {
        System.out.println("Pigeon eating");
    }

    public void fly() {
        fb.makeFly();
    }
}
