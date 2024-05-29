package pizza;

public class Tomato implements Pizza {
    private Pizza pizza;
    private final int price = 30;

    public Tomato(Pizza pizza){
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
            return "Tomato Only";
        }
        return "Tomato \n"+pizza.getDescription();
    }

}
