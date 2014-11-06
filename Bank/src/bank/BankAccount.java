package bank;

import java.util.*;

public abstract class BankAccount{
    private int accountNumber; // numero da conta
    protected double balance; //Saldo da conta
    private String owner; //Nome 
    private String password; //Senha
  

    public BankAccount() {
        this.accountNumber = 0;
        this.balance = 0;
        this.owner = "";  
    }
	
    public BankAccount(int accountNumber, String password, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.owner = owner;
        this.balance = balance;
    }
    
    public BankAccount(double balance, String owner) {
        this.balance = balance;
        this.owner = owner;
    }
    
    
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }
        
    public void setSenha(String senha) {
        this.password = senha;
    }

    public String getOwner() {
        return owner;
    }
    
    public abstract double getBalance();
    
    public void deposit(double amount) {
        // Deposita valor na conta bancária
        balance += amount;
    }

    public void withDraw(double amount) {
        // Retira valor da conta bancária
        balance -= amount;
    }

    public double yield(double balance) {
        double conta = (this.balance * balance / 100 + this.balance);
        this.balance=conta;
        return this.balance;
    }

    public void draw(double amount) {
        balance-=amount;
    }
    
    public boolean validaName (){
       for (int k = 0 ; k < owner.length() ; k ++ ){
            if ( Character.isLetter(owner.charAt(k)) == false ) {
                return false;
            }  
       }
       return true;
    }
    
    public String gerarSenha (){
        String baseNumerica = "013456789";
        int tBN = baseNumerica.length();
        String baseAlfabetica = "qwertyuiopasdfghjklzxcvbnm";
        int tBA = baseAlfabetica.length();
        Random gerador = new Random ();
        for (int w = 0 ; w < 3 ; w ++) {
            char  a = baseAlfabetica.charAt(gerador.nextInt(tBA));
            this.password = this.password + a;
        }
        for (int q = 0 ; q < 4 ; q ++) {
            char  s = baseNumerica.charAt(gerador.nextInt(tBN));
            this.password = this.password + s;
        }
        return this.password;
    }
}
