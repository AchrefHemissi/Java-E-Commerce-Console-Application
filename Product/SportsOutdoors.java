package Product;

public class SportsOutdoors extends Product
{
    private static SportsOutdoors instance = null;
    private SportsOutdoors()
    {
        super("SportsOutdoors");
    }

    public static SportsOutdoors getInstance() {
        if (instance == null) {
            instance = new SportsOutdoors();
        }
        return instance;
    }

    @Override
    public void adddefaultarticle() {
        AllArticle.add(new Article(30, "Sport1", 80, "SportsOutdoors", "Description for Sport1 in SportsOutdoors"));
        AllArticle.add(new Article(35, "Sport2", 90, "SportsOutdoors", "Description for Sport2 in SportsOutdoors"));
    }
}
