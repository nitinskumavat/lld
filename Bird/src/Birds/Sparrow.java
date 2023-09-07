package Birds;

import Bird.Bird;
import Bird.Flyable;
import FylingBehaviur.FylingBehaviour;

public class Sparrow extends Bird implements Flyable {
    private FylingBehaviour fb;

    public Sparrow(FylingBehaviour fb) {
        super("black", "caw", true);
        this.fb = fb;
    }

    public void walk() {
        System.out.println("Sparrow walking");
    }

    public void eat() {
        System.out.println("Sparrow eating");
    }

    public void fly() {
        fb.makeFly();
    }

}
