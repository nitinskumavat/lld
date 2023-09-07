package Birds;

import Bird.Bird;

public class Penguin extends Bird {

    public Penguin() {
        super("black-white", "water", false);
    }

    public void walk() {
        System.out.println("Penguin walking");
    }

    public void eat() {
        System.out.println("Penguin eating");
    }

}
