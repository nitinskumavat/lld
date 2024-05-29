import pizza.BBQChicken;
import pizza.Cheese;
import pizza.Pizza;
import pizza.Tomato;
import pizza.Paneer;

public class App {
    public static void main(String[] args) throws Exception {
        Pizza pizza = new Paneer(new Cheese(new Tomato(new BBQChicken())));
        System.out.println(pizza.getPrice());
        System.out.println(pizza.getDescription());
    }
}
