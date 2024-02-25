package CustomerTools;

public class BankCard
{
    private  int CardNumber;
    private String Bank;
    private int Code;
    private String DateExpiration;
    private int BankBalance;

    public BankCard(int CardNumber,String Bank,int Code,String DateExpiration, int BankBalance)
    {
        this.Bank=Bank;
        this.CardNumber=CardNumber;
        this.Code=Code;
        this.DateExpiration=DateExpiration;
        this.BankBalance=BankBalance;
    }

    public boolean Testcode(int code)
    {
        return code == this.Code;
    }

    public void AddMoney(int amount)
    {
        this.BankBalance+=amount;
    }

    public void ReduceMoney(int amount)
    {
        this.BankBalance-=amount;
    }

    public int getBankBalance() {
        return BankBalance;
    }
}
