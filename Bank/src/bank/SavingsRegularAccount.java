package bank;
//Thomaz Picelli e Marcelo Oliveira
import java.util.*;

public class SavingsRegularAccount extends BankAccount{
    private double specialBalance;  // limite da conta-corrente
    private double interestRate;   // taxa de juros
   
    public SavingsRegularAccount(int accountNumber, String password, String owner, double balance, double specialBalance, double interestRate){
        super(accountNumber, password,owner,balance); 
	this.interestRate=interestRate;
        this.specialBalance=specialBalance;
    }
   
    public double BalanceSavings(){
        return (this.balance/2) * (1 + this.interestRate);
    }
    
    public double BalanceRegular(){
        return (this.balance/2) + (this.specialBalance);
    }
    
    public String getBalance(){
        double x = BalanceSavings();
        double y = BalanceRegular();
        return System.out.println("Saldo remunerado:" + x + ". Saldo não remunerado:" + y + ".");
    }
    
}
