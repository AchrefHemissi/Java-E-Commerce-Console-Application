package CustomerTools;

import Product.Article;

public class Order
{
    private int IdOrder;
    private static int NbOrders=0;
    private int IdArticle;
    private String ArticleName;
    private int ArticlePrice;
    private int Quantity;
    private String DateOrder;

    public Order(int IdArticle,int ArticlePrice,int Quantity,String DateOrder)
    {
        this.IdOrder=NbOrders;
        NbOrders+=1;
        this.IdArticle=IdArticle;
        this.ArticlePrice=ArticlePrice;
        this.Quantity=Quantity;
        this.DateOrder=DateOrder;
    }

    public  void read()
    {
        System.out.println("Oder's Id: "+IdOrder +" date of the order: "+DateOrder+" Article: "+ArticleName + " Quantity: "+Quantity +" Total price: "+ Quantity* ArticlePrice);
    }



}
