package Product;

public class BooksMedia extends Product
{
    private static BooksMedia instance = null;
    private BooksMedia()
    {
        super("BooksMedia");
    }

    public static BooksMedia getInstance() {
        if (instance == null) {
            instance = new BooksMedia();
        }
        return instance;
    }


    @Override
    public void adddefaultarticle() {
        AllArticle.add(new Article(90, "Book1", 80, "BooksMedia", "Description for Book1 in BooksMedia"));
        AllArticle.add(new Article(95, "Book2", 85, "BooksMedia", "Description for Book2 in BooksMedia"));
    }
}
