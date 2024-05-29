package pizza;

public class Olive implements Pizza {
    private Pizza pizza;
    private final int price = 20;

    public Olive(Pizza pizza){
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
            return "Olive Only";
        }
        return "Olive \n"+pizza.getDescription();
    }

}
