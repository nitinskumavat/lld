package pizza;

public class Paneer implements Pizza {
    private Pizza pizza;
    private final int price = 60;

    public Paneer(Pizza pizza){
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
            return "Paneer Only";
        }
        return "Paneer \n"+pizza.getDescription();
    }

}
