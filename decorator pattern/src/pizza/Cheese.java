package pizza;

public class Cheese implements Pizza {
    private Pizza pizza;
    private final int price = 80;

    public Cheese(Pizza pizza){
        this.pizza= pizza;
    }

    @Override
    public int getPrice() {
        if(pizza==null){
            return this.price;
        }
        return this.price+pizza.getPrice();
    }

    @Override
    public String getDescription() {
        if(pizza==null){
            return "Cheese Only";
        }
        return "Cheese \n"+pizza.getDescription();
    }

}
