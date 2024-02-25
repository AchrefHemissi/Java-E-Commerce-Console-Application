package Product;

public class HealthBeauty extends Product
{
    private static HealthBeauty instance = null;
    private HealthBeauty()
    {
        super("HealthBeauty");
    }

    public static HealthBeauty getInstance() {
        if (instance == null) {
            instance = new HealthBeauty();
        }
        return instance;
    }

    @Override
    public void adddefaultarticle() {
        AllArticle.add(new Article(50, "Health1", 110, "HealthBeauty", "Description for Health1 in HealthBeauty"));
        AllArticle.add(new Article(55, "Health2", 95, "HealthBeauty", "Description for Health2 in HealthBeauty"));
    }
}
