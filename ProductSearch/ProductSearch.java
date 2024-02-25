package ProductSearch;
import Authentication.Customer;
import Product.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import Main.*;

public abstract class ProductSearch
{
    private static final List<Product> products = new ArrayList<>();
    static 
    {
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
            

    };

    private static void InteractionCustomer(Customer customer, Article article)
    {
        article.ReadArticleCustomer();
        customer.addViewedProduct(article);
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Choose a function");
        System.out.println("1.Add the product to my basket");
        System.out.println("2.Add a review");
        System.out.println("3.Go back");
        int choice=scanner.nextInt();
        try {
            switch (choice) {
                case 1: {
                    customer.AddToBasket(article);
                    break;
                }
                case 2: {

                    int rate = 0;
                    String comment;
                    do {
                        System.out.println("Give your Rate to the product from 1 to 5: ");
                        rate = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Give your comment: ");
                        comment = scanner.nextLine();
                    } while ((rate > 5) || (rate <= 0));
                    article.AddReview(customer.getIdUser(), customer.getUsername(), Main.Date, rate, comment);
                    break;
                }
                case 3: {
                    break;
                }
                default: {
                    System.out.println("Operation failed");
                }
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Oops! It seems there was an error in your input.Please choose a number");
        }

    }

    private static void  InteractionAdmin(Article article,Product product)
    {
        Scanner scanner = new Scanner(System.in);
        article.ReadArticleAdmin();
        System.out.println();
        System.out.println("Choose a function");
        System.out.println("1.Update the product information");
        System.out.println("2.Remove product");
        System.out.println("3.Go back");
        int choice=scanner.nextInt();
        try {
            switch (choice) {
                case 1: {
                    product.UpdateArticle(article.getIdArticle());
                    break;
                }
                case 2: {
                    product.DeleteArticle(article);
                    break;
                }
                case 3: {
                    break;
                }
                default: {
                    System.out.println("Operation failed");
                }
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println("Oops! It seems there was an error in your input.Please choose a number");
        }
    }
    public  static void FilteringPerCategoryCustomer(Customer customer)
    {
        System.out.println("Available category:");
        for(int i =0 ; i<products.size();i++)
        {
            System.out.println((i+1)+". "+products.get(i).getCategory());
        }
        try {
            System.out.println("Choose a category enter its number: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            Article article = products.get(choice - 1).CategoryFilteringCustomer();
            InteractionCustomer(customer, article);
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("Oops! It seems there was an error in your input. Please choose a number within a specific interval.");
        }
    }

    public static void FilteringPerCategoryAdmin()
    {
        System.out.println("Available category:");
        for(int i =0 ; i<products.size();i++)
        {
            System.out.println((i+1)+". "+products.get(i).getCategory());
        }
        System.out.println("Choose a category enter its number: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        try {
            Product product = products.get(choice - 1);
            scanner.nextLine();
            Article article = product.CategoryFilteringAdmin();
            InteractionAdmin(article, product);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Oops! It seems there was an error in your input. Please choose a number within a specific interval.");
        }
    }

    public static void FilteringPerNameCustomer(Customer customer)
    {
        System.out.println("What is the name of the product: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        List<Article> articles= new ArrayList<>();
        for(Product p : products)
        {
            articles.addAll(p.findByName(name));
        }
        if(articles.isEmpty())
        {
            System.out.println("No product has this name");
        }
        else {
            for(int i=0;i<articles.size();i++)
            {
                System.out.println((i + 1) + ". Product name: " + articles.get(i).getArticleName()+" Product price: "+articles.get(i).getPrix()+" Product's rating: "+(articles.get(i).getProductRating()!= 0 ? articles.get(i).getProductRating()+" out of 5" : " Not rated"));
            }
            System.out.println("Choose a product enter its number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            try
            {
                Article article = articles.get(choice - 1);
                InteractionCustomer(customer, article);
            }
            catch (IndexOutOfBoundsException e)
            {
                System.out.println("Oops! It seems there was an error in your input. Please choose a number within a specific interval.");
            }
        }
    }

    public static void FilteringPerNameAdmin()
    {
        System.out.println("What is the name of the product: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        List<Article> articles= new ArrayList<>();
        for(Product p : products)
        {
            articles.addAll(p.findByName(name));
        }
        if(articles.isEmpty())
        {
            System.out.println("No product has this name");
        }
        else
        {
            for (int i = 0; i < articles.size(); i++) {
                System.out.println((i + 1) + ". Product Id: "+articles.get(i).getIdArticle()+" Product name: " + articles.get(i).getArticleName()+" Product price: "+articles.get(i).getPrix()+" Product's rating: "+(articles.get(i).getProductRating()!= 0 ? articles.get(i).getProductRating()+" out of 5" : " Not rated"));
            }
            System.out.println("Choose a product enter its number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            try {
                Article article = articles.get(choice - 1);
                Product product = null;
                for (Product p : products) {
                    if (article.getCategory().equals(p.getCategory())) {
                        product = p;
                    }
                }
                InteractionAdmin(article, product);
            }
            catch (IndexOutOfBoundsException e)
            {
                System.out.println("Oops! It seems there was an error in your input. Please choose a number within a specific interval.");
            }
        }
    }

    public static void  FiltringPerIdAdmin()
    {
        System.out.println("What is the id of the product: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        scanner.nextLine();
        List<Article> articles= new ArrayList<>();
        for(Product p : products)
        {
            articles.addAll(p.findById(id));
        }
        if(articles.isEmpty())
        {
            System.out.println("No product has this id");
        }
        else
        {
            for (int i = 0; i < articles.size(); i++) {
                System.out.println((i + 1) + ". Product Id: "+articles.get(i).getIdArticle()+" Product name: " + articles.get(i).getArticleName()+" Product price: "+articles.get(i).getPrix()+" Product's rating: "+(articles.get(i).getProductRating()!= 0 ? articles.get(i).getProductRating()+" out of 5" : " Not rated"));
            }
            System.out.println("Choose a product enter its number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            try {
                Article article = articles.get(choice - 1);
                Product product = null;
                for (Product p : products) {
                    if (article.getCategory().equals(p.getCategory())) {
                        product = p;
                    }
                }
                InteractionAdmin(article, product);
            }
            catch (IndexOutOfBoundsException e)
            {
                System.out.println("Oops! It seems there was an error in your input. Please choose a number within a specific interval.");
            }
        }
    }

    public static void ReadLackOfStockArticleAdmin()
    {
        for(Product p : products)
        {
            System.out.println("Category "+p.getCategory());
            p.LackOfStockArticleAdmin();
            System.out.println();
        }
    }
}
