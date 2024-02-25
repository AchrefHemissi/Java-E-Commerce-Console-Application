package Product;

public class Appliances extends Product
{
    private static Appliances instance = null;
    private Appliances()
    {
        super("Appliances");
    }

    public void adddefaultarticle()
    {
        AllArticle.add(new Article(110, "Appliance1", 60, "Appliances", "Description for Appliance1 in Appliances"));
        AllArticle.add(new Article(115, "Appliance2", 55, "Appliances", "Description for Appliance2 in Appliances"));
    }

    public static Appliances getInstance() {
        if (instance == null) {
            instance = new Appliances();
        }
        return instance;
    }
}
