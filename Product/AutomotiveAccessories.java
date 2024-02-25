package Product;

public class AutomotiveAccessories extends Product
{
    private static AutomotiveAccessories instance = null;
    private AutomotiveAccessories()
    {
        super("AutomotiveAccessories");
    }

    public static AutomotiveAccessories getInstance() {
        if (instance == null) {
            instance = new AutomotiveAccessories();
        }
        return instance;
    }

    public void adddefaultarticle()
    {
        AllArticle.add(new Article(100, "Auto1", 70, "AutomotiveAccessories", "Description for Auto1 in AutomotiveAccessories"));
        AllArticle.add(new Article(105, "Auto2", 65, "AutomotiveAccessories", "Description for Auto2 in AutomotiveAccessories"));
    }
}
