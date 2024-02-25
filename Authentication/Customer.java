package Authentication;
import CustomerTools.*;
import Product.Article;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Main.*;

public class Customer extends User
{
    private List<ArticleQuantity> Basket;
    private List<Article> viewedProducts;
    private BankCard BankCard;
    private List<Order> Orders;

    public Customer(String Username,String Password,BankCard BankCard)
    {
        super(Username,Password,"Customer");
        this.Basket=new ArrayList<>();
        this.viewedProducts=new ArrayList<>();
        this.Orders=new ArrayList<>();
        this.BankCard=BankCard;
    }

    public void AddToBasket(Article article)
    {
        System.out.println("How many "+article.getArticleName()+" do you want to buy");
        Scanner scanner = new Scanner(System.in);
        int quantity = scanner.nextInt();
        if(article.getStock()>=quantity) {
            for (ArticleQuantity aq : Basket)//pour le cas ou le produit est deja dans la panier
            {
                if (aq.getArticle().getIdArticle() == article.getIdArticle()) {
                    aq.addQuantity(quantity);
                    System.out.println("Product added to the basket");
                    return;
                }
            }
            Basket.add(new ArticleQuantity(article, quantity));
            System.out.println("Product added to the basket");
        }
        else
        {
            System.out.println("There isn't much product available.");
        }
    }

    public void UpdateRemoveBasket()
    {
        System.out.println("Your Basket");
        if(! Basket.isEmpty()) {
            for (int  i=0 ; i<Basket.size();i++) {
                System.out.println((i + 1) + ". Product name: " + Basket.get(i).getArticle().getArticleName()+" the quantity "+Basket.get(i).getQuantity()+" the price: "+ Basket.get(i).getQuantity() * Basket.get(i).getArticle().getPrix());
            }
            System.out.println("choose an order to update it  enter its number: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            try {
                ArticleQuantity articleQuantitye = Basket.get(choice - 1);
                System.out.println("choose a function: ");
                System.out.println("1.Update the product quantity. ");
                System.out.println("2.Remove product from your basket. ");
                System.out.println("3.Go back");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("What is the new quantity? ");
                        int quantity = scanner.nextInt();
                        if (articleQuantitye.getArticle().getStock() >= quantity) {
                            articleQuantitye.setQuantity(quantity);
                            System.out.println("Order updated");

                        } else {
                            System.out.println("There isn't much product available.");
                        }
                        break;

                    }
                    case 2: {
                        Basket.remove(articleQuantitye);
                        System.out.println("Order removed from your basket");
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
            catch (IndexOutOfBoundsException e)
            {
                System.out.println("Oops! It seems there was an error in your input. Please choose a number within a specific interval.");
            }
        }
        else {
            System.out.println("Your Busket is empty");
        }
    }

    public void OrderCompletition()
    {
        int total=0;
        boolean test=true;
        Article article=null;
        for(ArticleQuantity aq : Basket)
        {
            if(aq.getQuantity()>aq.getArticle().getStock())
            {
                test=false;
                article=aq.getArticle();
            }
        }
        if(test)
        {
            for (ArticleQuantity aq : Basket) {
                total += aq.getQuantity() * aq.getArticle().getPrix();
            }
            if (!Basket.isEmpty()) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("The Totale is " + total);
                System.out.println("Give me the code of your Credit Card");
                int code = scanner.nextInt();
                scanner.nextLine();
                if ((BankCard.getBankBalance() >= total)&&(BankCard.Testcode(code)))
                {
                    BankCard.ReduceMoney(total);
                    System.out.println("Payment successful. Thank you for your purchase!");
                    for (ArticleQuantity aq : Basket) {
                        Orders.add(new Order(IdUser, aq.getArticle().getPrix(), aq.getQuantity(), Main.Date));
                        aq.getArticle().ReduceStock(aq.getQuantity());
                    }
                    Basket.clear();
                } else if(BankCard.getBankBalance() < total) {
                    System.out.println("Sorry, but there is not enough money in your Card");
                }
                else
                {
                    System.out.println("Your credit card code is wrong");
                }

            } else {
                System.out.println("Your basket is empty");
            }
        }
        else
        {
            System.out.println("There isn't much product available of "+article.getArticleName());
        }
    }

    public void addViewedProduct(Article article) {
        if(!viewedProducts.contains(article)) {
            viewedProducts.add(article);
        }
    }

    public void Recommendation() {
        if(!viewedProducts.isEmpty()) {
            System.out.println("Product recommended  for you");
            for (int i = viewedProducts.size() - 1; i >= 0; i--) {
                Article a = viewedProducts.get(i);
                System.out.println("Product name: " + a.getArticleName() + " Product price: " + a.getPrix() + " Product's rating: " + (a.getProductRating() != 0 ? a.getProductRating() + " out of 5" : " Not rated"));
            }
        }
    }

    public void ChangeCreditCard()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me the number of the new Card");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Give me the name of the bank");
        String Bank = scanner.nextLine();
        System.out.println("Give me the code");
        int code = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Give me the date of expiration");
        String date = scanner.nextLine();
        System.out.println("Give me the bank balance");
        int balance = scanner.nextInt();
        scanner.nextLine();
        BankCard= new BankCard(number,Bank,code,date,balance);
    }

    public void ReadOrders()
    {
        if(!Orders.isEmpty()) {
            for (Order r : Orders) {
                r.read();
            }
        }
        else {
            System.out.println("You don't have previous orders yet");
        }
    }





}
