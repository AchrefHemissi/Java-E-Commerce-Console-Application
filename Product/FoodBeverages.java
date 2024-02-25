package Product;

public class FoodBeverages extends Product
{
    private static FoodBeverages instance = null;
    private FoodBeverages()
    {
        super("FoodBeverages");
    }

    public static FoodBeverages getInstance() {
        if (instance == null) {
            instance = new FoodBeverages();
        }
        return instance;
    }

    @Override
    public void adddefaultarticle() {
        AllArticle.add(new Article(60, "Food1", 85, "FoodBeverages", "Description for Food1 in FoodBeverages"));
        AllArticle.add(new Article(65, "Food2", 75, "FoodBeverages", "Description for Food2 in FoodBeverages"));
    }
}
