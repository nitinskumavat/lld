package Bird;

public abstract class Bird {
    private String color;
    private String type;
    private boolean canFly;

    public Bird(String color, String type, boolean canFly) {
        this.color = color;
        this.type = type;
        this.canFly = canFly;
    }

    public boolean isFlyable() {
        return this.canFly;
    }

    public String getColor() {
        return this.color;
    }

    public String getType() {
        return this.type;
    }

    public abstract void walk();

    public abstract void eat();
}
