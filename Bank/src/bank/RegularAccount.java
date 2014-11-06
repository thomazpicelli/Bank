package bank;

public class RegularAccount 
    extends BankAccount{

    private double specialBalance;  // limite da conta-corrente
    
    public RegularAccount(int accountNumber, String password, String owner, double balance, double specialBalance) {
        super(accountNumber,password,owner,balance);
        this.specialBalance=specialBalance;
    }
    
    public double getBalance() {
      return balance+specialBalance;   
    }
}