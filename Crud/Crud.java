package Crud;
import Product.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Crud
{
    private static final List<Product> products = new ArrayList<>();
    static{
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

    }


    public static void AddArticleAdmin()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me the name of the product");
        String name = scanner.nextLine();
        System.out.println("Give me the price of the product");
        int price = scanner.nextInt();
        System.out.println("Give me the stock level of this product");
        int stock = scanner.nextInt();
        System.out.println("Give me the description of the product");
        String description = scanner.nextLine();
        System.out.println("Select the category that you want to add the new article to");
        for(int i =0 ;i<products.size();i++)
        {
            System.out.println((1+i)+". "+products.get(i).getCategory());
        }

        int choice = scanner.nextInt();
        products.get(choice-1).AddArticle(new Article(price,name,stock,products.get(choice-1).getCategory(),description));
    }

}
