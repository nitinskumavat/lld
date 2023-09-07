
import Birds.Crow;
import Birds.Penguin;
import Birds.Pigeon;
import Birds.Sparrow;
import FylingBehaviur.Flapping;
import FylingBehaviur.Glidding;

public class App {
    public static void main(String[] args) throws Exception {

        // Using dependency injection
        Crow crow = new Crow(new Glidding());
        crow.fly();
        crow.eat();
        System.out.println("Can Crow Fly ? " + crow.isFlyable());

        Penguin penguin = new Penguin();
        penguin.eat();

        Pigeon pigeon = new Pigeon(new Flapping());
        pigeon.fly();

        Sparrow sparrow = new Sparrow(new Flapping());
        sparrow.fly();

    }
}
