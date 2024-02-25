package Authentication;
import java.util.ArrayList;
import java.util.List;


abstract public class UserAuthentication
{
    private static List<Customer> Customers = new ArrayList<>();
    private static List<Admin> Admins = new ArrayList<>();

    public static boolean AddCustomer(Customer customer)
    {
        for(Customer c : Customers)
        {
            if(c.getUsername().equals(customer.getUsername()))
            {
                System.out.println("Username '" + customer.getUsername() + "' is already taken. Please choose a different username.");
                return false;
            }
        }

        Customers.add(customer);
        return true;
    }

    public static void AddAdmin(Admin admin)
    {
        for(Admin a : Admins)
        {
            if(a.getUsername().equals(admin.getUsername()))
            {
                System.out.println("Username '" + admin.getUsername() + "' is already taken. Please choose a different username.");
                return;
            }
        }

        Admins.add(admin);
    }

    public static void RemoveCustomer(Customer customer)
    {
        boolean removalSuccessful = Customers.remove(customer);

        if (removalSuccessful) 
        {
            System.out.println("We regret to inform you that your account with 9offa.tn has been deleted as per your request.\n" +
            "Please note that all your account information, including order history, preferences, and saved data, has been permanently removed from our system.\n" +
            "If you have any further inquiries or wish to re-establish your account, feel free to reach out to our customer support team.\n" +
            "Thank you for being a part of our community. We appreciate your past support and hope to serve you again in the future should you decide to join us once more.\n" +
            "\n" +
            "Best regards,\n" +
            "9offa.tn");

        } else {
            System.out.println("The deletion request for the account " + customer.getUsername() + " could not be processed.");
        }
    }

    public static void RemoveAdmin(Admin admin)
    {
        boolean removalSuccessful = Admins.remove(admin);

        if (removalSuccessful) {
            System.out.println("The account for username " + admin.getUsername() + " has been successfully deleted.");
        } else {
            System.out.println("The deletion request for the account " + admin.getUsername() + " could not be processed.");
        }
    }

    public static boolean LoginCustomer(String Username,String password)
    {
        for(Customer c : Customers)
        {
            if((c.getUsername().equals(Username)) && (c.getPassword().equals(password)))
            {
                System.out.println("Welcome, "+ c.getUsername() + " ! You have successfully logged in.");
                return true;
            }
        }
        System.out.println("Login failed for username " + Username + " Please check your credentials and try again.");
        return false;
    }

    public static void ChangePassword(Customer customer,String password,String newpassword)
    {
        if(customer.getPassword().equals(password))
        {
           customer.setPassword(newpassword);
           System.out.println("Your password is successfully changed");
        }
        else
        {
            System.out.println("operation failed");
        }
    }

    public static boolean LoginAdmin(String Username , String password)
    {
        for(Admin a : Admins)
        {
            if((a.getUsername().equals(Username)) && (a.getPassword().equals(password)))
            {
                System.out.println("Welcome, "+ Username + " ! You have successfully logged in.");
                return true;
            }
        }
        System.out.println("Login failed for username " + Username + " Please check your credentials and try again.");
        return false;

    }

    public static Customer SearchCustomer(String Username)
    {
        for(Customer c  : Customers)
        {
            if(c.getUsername().equals(Username))
            {
                return c;
            }
        }
        return null ;
    }

    public static Admin SearchAdmin(String Username)
    {
        for(Admin a  : Admins)
        {
            if(a.getUsername().equals(Username))
            {
                return a;
            }
        }
        return null ;
    }

}
