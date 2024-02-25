package CustomerTools;
import Product.Article;

public class ArticleQuantity
{
    private Article article;
    private int Quantity;

    public ArticleQuantity(Article article,int Quantity)
    {
        this.article=article;
        this.Quantity=Quantity;
    }

    public void updating(int Quantity)
    {
        this.Quantity=Quantity;
    }

    public Article getArticle() {
        return article;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public void addQuantity(int quantity) {
        Quantity += quantity;
    }
}
