package Product;

import Authentication.Admin;

public class HomeGarden extends Product
{
    private static HomeGarden instance = null;
    private HomeGarden()
    {
        super("HomeGarden");
    }

    public static HomeGarden getInstance() {
        if (instance == null) {
            instance = new HomeGarden();
        }
        return instance;
    }

    @Override
    public void adddefaultarticle() {
        AllArticle.add(new Article(40, "Home1", 70, "HomeGarden", "Description for Home1 in HomeGarden"));
        AllArticle.add(new Article(45, "Home2", 60, "HomeGarden", "Description for Home2 in HomeGarden"));
    }
}
