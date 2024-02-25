package Product;

public class Electronics extends Product
{
    private static Electronics instance = null;
    private Electronics()
    {
        super("Electronics");
    }

    public static Electronics getInstance() {
        if (instance == null) {
            instance = new Electronics();
        }
        return instance;
    }

    @Override
    public void adddefaultarticle() {
        AllArticle.add(new Article(80, "Electronics1", 95, "Electronics", "Description for Electronics1 in Electronics"));
        AllArticle.add(new Article(85, "Electronics2", 90, "Electronics", "Description for Electronics2 in Electronics"));
    }
}
