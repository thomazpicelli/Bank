package bank;

import java.util.*;

class BankAccount extends Bank{
    private int accountNumber; // numero da conta
    private double balance; //Saldo da conta
    private String name; //Nome 
    private String password; //Senha
  

    public BankAccount() {
        this.accountNumber = 0;
        this.balance = 0;
        this.name = "";  
    }
	
    public BankAccount(int accountNumber, String password, String name, double balance) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.name = name;
        this.balance = balance;
    }
    
    public BankAccount(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
    public double getBalance() {
        return this.balance;
    }

    public void setSenha(String senha) {
        this.password = senha;
    }

    public double yield(double balance) {
        double conta = (this.balance * balance / 100 + this.balance);
        this.balance=conta;
        return this.balance;
    }

    public void deposit(double amount) {
        balance+=amount;
    }

    public void draw(double amount) {
        balance-=amount;
    }
    
    public boolean validaName (){
       for (int k = 0 ; k < name.length() ; k ++ ){
            if ( Character.isLetter(name.charAt(k)) == false ) {
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
