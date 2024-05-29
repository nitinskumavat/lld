package pizza;

public class Farmhouse implements Pizza{

    @Override
    public int getPrice(){
        return 150;
    }

    @Override
    public String getDescription() {
        return "Farmhouse Pizza";
    }

}
