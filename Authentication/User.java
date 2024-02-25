package Authentication;

abstract public class User
{
    protected int IdUser;
    protected static int NbUsers=0;
    protected String Username;
    protected String Password;
    protected String Role;

    public User(String Username,String Password,String Role)
    {
        this.IdUser=NbUsers;
        this.Role=Role;
        this.Password=Password;
        this.Username=Username;
        NbUsers+=1;
    }

    public int getIdUser() {
        return IdUser;
    }

    public String getUsername()
    {
        return Username;
    }

    protected String getPassword()
    {
        return Password;
    }

    protected void setPassword(String password) {
        Password = password;
    }
}
