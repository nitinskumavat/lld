package Birds;

import Bird.Bird;
import Bird.Flyable;
import FylingBehaviur.FylingBehaviour;

public class Crow extends Bird implements Flyable {
    private FylingBehaviour fb;

    public Crow(FylingBehaviour fb) {
        super("black", "caw", true);
        this.fb = fb;
    }

    public void walk() {
        System.out.println("Crow walking");
    }

    public void eat() {
        System.out.println("Crow eating");
    }

    public void fly() {
        fb.makeFly();
    }
}
