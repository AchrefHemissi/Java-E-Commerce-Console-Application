package Product;
import java.util.ArrayList;
import java.util.List;
import ReviewsRatings.Review;

public class Article
{
    private int IdArticle;
    private static int NbArticle=0;
    private int Prix;
    private List<Review> Reviews;
    private String ArticleName;
    private int Stock;
    private String Category;
    private String Description;

    public Article(int Prix,String ArticleName,int Stock,String Category,String Description)
    {
        this.IdArticle=NbArticle;
        NbArticle+=1;
        this.Prix=Prix;
        this.ArticleName =ArticleName;
        this.Stock=Stock;
        this.Category=Category;
        this.Reviews=new ArrayList<>();
        this.Description=Description;
    }

    public String getCategory() {
        return Category;
    }

    public String getArticleName()
    {
        return ArticleName;
    }

    public int getIdArticle() {
        return IdArticle;
    }

    public int getStock() {
        return Stock;
    }

    public int getPrix() {
        return Prix;
    }

    public void setArticleName(String articleName) {
        ArticleName = articleName;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setPrix(int prix) {
        Prix = prix;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public int getProductRating()
    {
        int  rating=0;
        int k=0;
        for (Review review : Reviews) {
            rating += review.getNote();
            k+=1;
        }
        if(k!=0)
        {
            return rating/k ;
        }
        return 0;
    }

    public void ReadArticleCustomer()
    {
        int k=5;//a default number
        System.out.println("Product Information:");
        System.out.println("Name: " + ArticleName);
        System.out.println("Price: $" + Prix);
        System.out.println("Category: " + Category);
        System.out.println("Rating: " + (getProductRating()!= 0 ? getProductRating()+" out of 5" : " Not rated"));
        System.out.println("Description: " + Description);
        for( Review r: Reviews)
        {
            System.out.println("Comments: " + r.getComment()+" Rate:"+r.getNote()+" from "+r.getUserName());
            k-=1;
            if(k==0)
            {
                break;
            }
        }
    }

    public void ReadArticleAdmin()
    {
        int k=5;//a default number
        System.out.println("Product Id: "+IdArticle);
        System.out.println("Number of products in stock: "+Stock);
        ReadArticleCustomer();
    }

    public void AddReview(int IdCustomer,String UserName,String Date, int Rate , String Comment)
    {
        Reviews.add(new Review(IdCustomer,UserName,Date,Comment,Rate));
    }

    public void ReduceStock(int reduce)
    {
        List<Product> products = new ArrayList<>();
        products.add(ToysKids.getInstance());
        products.add(SportsOutdoors.getInstance());
        products.add(HomeGarden.getInstance());
        products.add(HealthBeauty.getInstance());
        products.add(FoodBeverages.getInstance());
        products.add(Fashion.getInstance());
        products.add(Electronics.getInstance());
        products.add(BooksMedia.getInstance());
        products.add(AutomotiveAccessories.getInstance());
        products.add(Appliances.getInstance());
        Stock-=reduce;
        for(Product p : products)
        {
            if(p.getCategory().equals(Category))
            {
                p.TestStock(this);
            }
        }
    }

}
