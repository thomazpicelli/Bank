package bank;
//Thomaz Picelli e Marcelo Oliveira
import java.util.*;

public class SavingsRegularAccount extends BankAccount{
    private double balanceSavings;  //saldo tipo poupança
    private double balanceRegular;  //saldo tipo regular
    private double specialBalance;  // limite da conta-corrente
    private double interestRate;    // taxa de juros
   
    public SavingsRegularAccount(int accountNumber, String password, String owner, double balance, double balanceSavings, double balanceRegular, double specialBalance, double interestRate){
        super(accountNumber, password,owner,balance); 
	this.interestRate=interestRate;
        this.specialBalance=specialBalance;
    }
   
    public double getBalanceSavings(){
        return (balanceSavings/2) * (1 + interestRate);
    }
    
    public double getBalanceRegular(){
        return (balanceRegular/2) + (specialBalance);
    }
        
    public void depoosit(double value){
        balanceRegular = balanceRegular + value/2;
        balanceSavings = balanceSavings + value/2;
    }
}
