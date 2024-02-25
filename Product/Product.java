package Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


abstract public  class Product
{
    protected int IdProduct;//this is the id of the category not of the article
    protected static int NbProduct=0;
    protected String Category;
    protected List<Article> AllArticle;
    protected List<Article> LackOfStockArticle;

    public Product(String Category)
    {
        this.IdProduct=NbProduct;
        this.Category= Category;
        this.AllArticle=new ArrayList<>();
        this.LackOfStockArticle=new ArrayList<>();
        NbProduct+=1;
    }

    public abstract void adddefaultarticle();

    public String getCategory() {
        return Category;
    }

    public void AddArticle(Article article)
    {
        for(Article a:AllArticle)
        {
            if(a.getArticleName().equals(article.getArticleName()))
            {
                System.out.println("This product name already exists in category "+Category);
                return;
            }
        }

        System.out.println("The product has been added successfully in category "+Category);
        AllArticle.add(article);
        TestStock(article);
    }

    public void DeleteArticle(Article article)
    {

        boolean removalSuccessful = AllArticle.remove(article);

        if (removalSuccessful) {
            System.out.println("The product " + article.getArticleName() + " has been successfully deleted from "+Category+" category.");
        } else {
            System.out.println("The deletion request for the product " + article.getArticleName() +"from "+Category +" category could not be processed.");
        }
    }

    public void UpdateArticle(int IdArticle)
    {
        for(Article a:AllArticle)
        {
            if(a.getIdArticle()==IdArticle)
            {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Select what you want to update\n " +
                        "1.The price\n" +
                        "2.The name of the product\n" +
                        "3.The description of the product\n" +
                        "4.The stock level\n");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice)
                {
                    case 1: {
                        System.out.println("What is the new price of the the product "+a.getArticleName()+": ");
                        int newprix = scanner.nextInt();
                        scanner.nextLine();
                        a.setPrix(newprix);
                        break;
                    }
                    case 2:
                    {
                        System.out.println("What is the new name of the the product "+a.getArticleName()+": ");
                        String inputString = scanner.nextLine();
                        a.setArticleName(inputString);
                        break;
                    }
                    case 3:
                    {
                        System.out.println("What is the new description of the the product "+a.getArticleName()+": ");
                        String inputString = scanner.nextLine();
                        a.setDescription(inputString);
                        break;
                    }
                    case 4:
                    {
                        System.out.println("What is the new stock level of the the product "+a.getArticleName()+": ");
                        int newstock = scanner.nextInt();
                        scanner.nextLine();
                        a.setStock(newstock);
                        TestStock(a);
                        break;
                    }
                    default:
                    {
                        System.out.println("The update request for the product of Id " + IdArticle +" could not be processed.");
                    }
                }

            }
        }
    }

    public void TestStock(Article article)
    {
        if(article.getStock()<=5)
        {
            for(Article a : LackOfStockArticle)
            {
                if(a.getIdArticle()==article.getIdArticle())
                {
                    return;
                }
            }
            LackOfStockArticle.add(article);
        }
        else
        {
            LackOfStockArticle.remove(article);
        }
    }

    public Article  CategoryFilteringCustomer()
    {
        System.out.println("Available Products:");
        for (int i = 0; i < AllArticle.size(); i++) {
            System.out.println((i + 1) + ".  Product name: " + AllArticle.get(i).getArticleName()+" Product price: "+AllArticle.get(i).getPrix()+" Product's rating: "+(AllArticle.get(i).getProductRating()!= 0 ? AllArticle.get(i).getProductRating()+" out of 5" : " Not rated"));
        }
        System.out.println("Choose a product enter its number: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        return AllArticle.get(choice-1);
    }

    public Article  CategoryFilteringAdmin()
    {
        System.out.println("Available Products:");
        for (int i = 0; i < AllArticle.size(); i++) {
            System.out.println((i + 1) + ". Product Id: "+AllArticle.get(i).getIdArticle()+" Product name: " + AllArticle.get(i).getArticleName()+" Product price: "+AllArticle.get(i).getPrix()+" Product's rating: "+(AllArticle.get(i).getProductRating()!= 0 ? AllArticle.get(i).getProductRating()+" out of 5" : " Not rated"));
        }
        System.out.println("Choose a product enter its number: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        return AllArticle.get(choice-1);
    }

    public List<Article> findByName(String Name) {
        List<Article> output = new ArrayList<>();
        for (Article a : AllArticle) {
            if(a.getArticleName().contains(Name))
            {
                output.add(a);
            }
        }
        return output;
    }

    public List<Article> findById(int Id) {
    List<Article> output = new ArrayList<>();
    for (Article a : AllArticle) {
        if(a.getIdArticle()==Id)
        {
            output.add(a);
        }
    }
    return output;
}



    public void LackOfStockArticleAdmin()
    {
        System.out.println("The product out or lack of stock");
        if(!LackOfStockArticle.isEmpty()) {
            for (Article article : LackOfStockArticle) {
                System.out.println(". Product Id: " + article.getIdArticle() + " Product name: " + article.getArticleName() + " Product price: " + article.getPrix() + " Product's rating: " + (article.getProductRating() != 0 ? article.getProductRating() + " out of 5" : " Not rated") + " Quantity in stock " + article.getStock());
            }
        }
        else
        {
            System.out.println("No product found out or lack of stock in this category");
        }
    }
}


