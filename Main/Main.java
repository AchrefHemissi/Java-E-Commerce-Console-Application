package Main;

import Authentication.*;
import Crud.Crud;
import CustomerTools.*;
import Product.*;
import ProductSearch.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String Date = "12/20/2023";

    public static void main(String[] args) {

        BankCard bankCard1 = new BankCard(123000, "Biat", 345, "12/03/2027", 2000);
        Customer customer1 = new Customer("Achref", "qwerty", bankCard1);
        UserAuthentication.AddCustomer(customer1);
        Admin admin1 = new Admin("omar08", "admin123");
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

    
        for (Product p : products) {
            p.adddefaultarticle();
        }
        UserAuthentication.AddAdmin(admin1);

        int choice;
        int choice2 = -1;

        do {

            try {

                System.out.println("Login");
                System.out.println("Choose your profile");
                System.out.println("1.Login to your Customer account");
                System.out.println("2.Login to your Admin account");
                System.out.println("3.Create a new Customer account");
                System.out.println("4.close the program");
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1: {
                        System.out.println("User name : ");
                        String username = scanner.nextLine();
                        System.out.println("Password :");
                        String password = scanner.nextLine();
                        if (UserAuthentication.LoginCustomer(username, password)) {
                            Customer customer = UserAuthentication.SearchCustomer(username);
                            do {
                                try {
                                    assert customer != null;
                                    customer.Recommendation();
                                    System.out.println();
                                    System.out.println("Choose a function");
                                    System.out.println("1.Search a product by name");
                                    System.out.println("2.Filtering product by category");
                                    System.out.println("3.Visit my account");
                                    System.out.println("4.Complete my orders");
                                    System.out.println("5.Log out");
                                    choice = scanner.nextInt();
                                    switch (choice) {
                                        case 1: {
                                            ProductSearch.FilteringPerNameCustomer(customer);
                                            break;
                                        }
                                        case 2: {
                                            ProductSearch.FilteringPerCategoryCustomer(customer);
                                            break;
                                        }
                                        case 3: {
                                            System.out.println("Choose a function");
                                            System.out.println("1.Manage your Basket");
                                            System.out.println("2.Change my password");
                                            System.out.println("3.Change my Credit Card");
                                            System.out.println("4.Delete your account");
                                            System.out.println("5.Your Previous Orders");
                                            System.out.println("6.Go back");
                                            choice2 = scanner.nextInt();
                                            scanner.nextLine();
                                            switch (choice2) {
                                                case 1: {
                                                    customer.UpdateRemoveBasket();
                                                    break;
                                                }
                                                case 2: {
                                                    System.out.println("Give me your current password");
                                                    String currentpassword = scanner.nextLine();
                                                    System.out.println("Give the new password");
                                                    String newpassword = scanner.nextLine();
                                                    UserAuthentication.ChangePassword(customer, currentpassword, newpassword);
                                                    break;
                                                }
                                                case 3: {
                                                    customer.ChangeCreditCard();
                                                    break;
                                                }
                                                case 4: {
                                                    UserAuthentication.RemoveCustomer(customer);
                                                    break;
                                                }
                                                case 5:
                                                {
                                                    customer.ReadOrders();
                                                }
                                                case 6: {
                                                    break;
                                                }
                                                default: {
                                                    System.out.println("Operation failed");
                                                }
                                            }
                                            break;
                                        }

                                        case 4: {
                                            customer.OrderCompletition();
                                            break;
                                        }
                                        case 5: {
                                            System.out.println("Thank you for your visit, See you next time");
                                            break;
                                        }
                                        default: {
                                            System.out.println("Operation failed");
                                        }
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Oops! It seems there was an error in your input.Please choose a number");
                                    choice = -1;
                                }

                            } while (!((choice == 5) || (choice2 == 4)));

                            choice = 1;
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("User name : ");
                        String username = scanner.nextLine();
                        System.out.println("Password :");
                        String password = scanner.nextLine();
                        if (UserAuthentication.LoginAdmin(username, password)) {
                            Admin admin = UserAuthentication.SearchAdmin(username);
                            do {
                                System.out.println();
                                System.out.println("Choose a function");
                                System.out.println("1.Search a product by name");
                                System.out.println("2.Search a product by Id");
                                System.out.println("3.Filtering product by category");
                                System.out.println("4.Products with limited stock availability");
                                System.out.println("5.Add a new product");
                                System.out.println("6.Log out");
                                choice = scanner.nextInt();
                                switch (choice) {
                                    case 1: {
                                        ProductSearch.FilteringPerNameAdmin();
                                        break;
                                    }
                                    case 2: {
                                        ProductSearch.FiltringPerIdAdmin();
                                        break;
                                    }
                                    case 3: {
                                        ProductSearch.FilteringPerCategoryAdmin();
                                        break;
                                    }
                                    case 4: {
                                        ProductSearch.ReadLackOfStockArticleAdmin();
                                        break;
                                    }
                                    case 5: {
                                        Crud.AddArticleAdmin();
                                        break;
                                    }
                                    case 6: {
                                        System.out.println("Thank you for your visit, See you next time");
                                        break;
                                    }
                                    default: {
                                        System.out.println("Operation failed");
                                    }

                                }
                            } while (choice != 6);
                        }
                        break;
                    }
                    case 3: {
                        String username;
                        String password;
                        int CardNumber;
                        String bank;
                        int code;
                        String DateExpiration;
                        int BankBalance;

                        try {

                            System.out.println("choose a user name: ");
                            username = scanner.nextLine();
                            System.out.println("choose a password: ");
                            password = scanner.nextLine();
                            System.out.println("Enter your credit card information: ");
                            System.out.println("The Credit card number: ");
                            CardNumber = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("The name of your Bank: ");
                            bank = scanner.nextLine();
                            System.out.println("The CVV/CVC: ");
                            code = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("The Expiration Date: ");
                            DateExpiration = scanner.nextLine();
                            System.out.println("The balance: ");
                            BankBalance = scanner.nextInt();
                            scanner.nextLine();
                            BankCard bankCard = new BankCard(CardNumber, bank, code, DateExpiration, BankBalance);
                            while (!UserAuthentication.AddCustomer(new Customer(username, password, bankCard))) {
                                System.out.println("Choose another username: ");
                                username = scanner.nextLine();

                            }
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Oops! It seems there was an error in your input.");
                        }
                        break;
                    }
                    case 4: {
                        System.out.println("Thank you for your visit, I hope that our 9offa.tn find you well");
                        break;
                    }
                    default: {
                        System.out.println("Operation failed");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Oops! It seems there was an error in your input.Please choose a number");
                choice = -1;//to not exit the while
            }
        } while (choice != 4);
    }
}