package Product;

public class Fashion extends Product
{
    private static Fashion instance = null;
    private Fashion()
    {
        super("Fashion");
    }

    public static Fashion getInstance() {
        if (instance == null) {
            instance = new Fashion();
        }
        return instance;
    }

    @Override
    public void adddefaultarticle() {
        AllArticle.add( new Article(70, "Fashion1", 120, "Fashion", "Description for Fashion1 in Fashion"));
        AllArticle.add(new Article(75, "Fashion2", 105, "Fashion", "Description for Fashion2 in Fashion"));
    }
}
