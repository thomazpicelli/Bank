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
   
    public double getBalance(){
        double aux = (this.balance/2);
        this.balanceSavings = aux * (1 + interestRate);
        this.balanceRegular = aux + specialBalance;
        this.balance = this.balanceSavings + this.balanceRegular;
        return this.balance;
    }
        
    public void depoosit(double value){
        balanceRegular = balanceRegular + value/2;
        balanceSavings = balanceSavings + value/2;
        balance = value;
    }
}
