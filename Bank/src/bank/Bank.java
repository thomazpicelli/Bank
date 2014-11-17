package bank;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Bank 
         implements BankAccountOperation{
    
    private ArrayList<BankAccount> accounts;
    int identificador;
    String nomeBanco;

    public Bank(){
        accounts = new ArrayList<BankAccount>();
        this.identificador = 000;
        this.nomeBanco = "";
    }
    
    public Bank(int identificador, String nomeBanco){
        this.identificador = identificador;
        this.nomeBanco = nomeBanco;
    }

    public Bank(String filename){
        accounts = new ArrayList<BankAccount>();
        try{
            BufferedReader entrada = new BufferedReader(new FileReader(filename));  //leitura

            String numero = entrada.readLine(); 
            int numDeContas = Integer.parseInt(numero);  //conversão de tipo primitivo

            for(int i = 0; i<numDeContas; i++) { 
                String line = entrada.readLine();
                String conta[] = line.split("#");
                switch (conta[0]){
                    case "RA": 
                        accounts.add(i,new RegularAccount(Integer.parseInt(conta[1]),conta[2],conta[3],Double.parseDouble(conta[4]), Double.parseDouble(conta[5])));
                        break;
                    case "SA":
                        accounts.add(i,new SavingsAccount(Integer.parseInt(conta[1]), conta[2], conta[3], Double.parseDouble(conta[4]), Double.parseDouble(conta[5])));
                        break; 
                    case "CLA":
                        accounts.add(i, new CityLawAccount(Integer.parseInt(conta[1]),conta[2], conta[3], Double.parseDouble(conta[4]),conta[5],Double.parseDouble(conta[6]),conta[7]));
                        break;
                    case "SLA":
                        accounts.add(i, new StateLawAccount(Integer.parseInt(conta[1]),conta[2], conta[3], Double.parseDouble(conta[4]),(conta[5]),Double.parseDouble(conta[6]),conta[7]));
                        break;
                    case "FLA":
                        accounts.add(i, new FederationLawAccount(Integer.parseInt(conta[1]),conta[2], conta[3],Double.parseDouble(conta[4]), (conta[5]),Double.parseDouble(conta[6]),Integer.parseInt(conta[7])));
                        break;
                }
            }    
        }
        catch(IOException e){
            System.exit(-1);
        }
    }

    public void dump(String filename){
        try {
            BufferedWriter saida = new BufferedWriter(new FileWriter(filename));
            saida.write(accounts.size() + "\n");

            for (BankAccount b : accounts) {
                saida.write(b.getAccountNumber() + "#" + b.getPassword() + "#" + b.getOwner() + "#" + b.getBalance() + "\n");
            }
            saida.flush();
            saida.close();
        }
        catch(IOException | NumberFormatException e) {
            System.exit(-1);
        }
    }
	     
    public void sort(){ //ordenação por ordem CRESCENTE de saldo
        for(int i=0; i<accounts.size()-1; i++){
            for(int j=i; j<accounts.size(); j++){
                if(accounts.get(j).getBalance() > accounts.get(i).getBalance()){
                    BankAccount aux = accounts.get(j);
                    accounts.set(j,accounts.get(i));
                    accounts.set(i,aux);
                }
            }
        }
    }
    
    public ArrayList<RegularAccount> regularAccount(){
        ArrayList<RegularAccount> RegularAccount = new ArrayList<>();
        for (int i=0; i<accounts.size(); i++){  //seleciona todas contas regulares
            if(accounts.get(i) instanceof RegularAccount ){
                RegularAccount.add((RegularAccount)accounts.get(i));
            }
        }
        for(int i=0; i<RegularAccount.size()-1; i++){  //ordenação DECRESCENTE
            for(int j=i; j<RegularAccount.size(); j++){
                if(RegularAccount.get(j).getBalance() < RegularAccount.get(i).getBalance()){
                    RegularAccount aux=(RegularAccount)RegularAccount.get(j);
                    RegularAccount.set(j,RegularAccount.get(i));
                    RegularAccount.set(i,aux);
                }
            }
        }
        return RegularAccount;
    }
    
        public ArrayList<SavingsAccount> savingsAccount(){
        ArrayList<SavingsAccount> SavingsAccount = new ArrayList<>();
        for (int i=0; i<accounts.size(); i++){  //seleciona todas SavingsAccount
            if(accounts.get(i) instanceof SavingsAccount ){
                SavingsAccount.add((SavingsAccount)accounts.get(i));
            }
        }
        for(int i=0; i<SavingsAccount.size()-1; i++){  //ordenação DECRESCENTE
            for(int j=i; j<SavingsAccount.size(); j++){
                if(SavingsAccount.get(j).getBalance() < SavingsAccount.get(i).getBalance()){
                    SavingsAccount aux=(SavingsAccount)SavingsAccount.get(j);
                    SavingsAccount.set(j,SavingsAccount.get(i));
                    SavingsAccount.set(i,aux);
                }
            }
        }
        return SavingsAccount;
    }
        
    public ArrayList<LawAccount> lawAccount(){
               
        ArrayList<CityLawAccount> CityLawAccount = new ArrayList<>(); //seleciona todas as CityLawAccount
        for (int i=0; i<accounts.size(); i++){
            if(accounts.get(i) instanceof CityLawAccount ){
                CityLawAccount.add((CityLawAccount)accounts.get(i));
            }
        }
        for(int i=0; i<CityLawAccount.size()-1; i++){ //ordenaçao CRESCENTE
            for(int j=i; j<CityLawAccount.size(); j++){
                if(CityLawAccount.get(j).getBalance()<CityLawAccount.get(i).getBalance()){
                    CityLawAccount aux = (CityLawAccount)CityLawAccount.get(j);
                    CityLawAccount.set(j,CityLawAccount.get(i));
                    CityLawAccount.set(i,aux);
                }
            }
        }
        
        ArrayList<StateLawAccount> StateLawAccount = new ArrayList<>();
        for (int i=0; i<accounts.size(); i++){  //seleciona todas as StateLawAccount
            if(accounts.get(i) instanceof StateLawAccount ){
                StateLawAccount.add((StateLawAccount)accounts.get(i));
            }
        }
        for(int i=0; i<StateLawAccount.size()-1; i++){ //ordenação CRESCENTE
            for(int j=i; j<StateLawAccount.size(); j++){
                if(StateLawAccount.get(j).getBalance() < StateLawAccount.get(i).getBalance()){
                    StateLawAccount aux = (StateLawAccount)StateLawAccount.get(j);
                    StateLawAccount.set(j,StateLawAccount.get(i));
                    StateLawAccount.set(i,aux);
                }
            }
        }
        
        ArrayList<FederationLawAccount> FederationLawAccount = new ArrayList<>();
        for (int i=0; i<accounts.size(); i++){ // seleciona todas as contas FederationLawAccount
            if(accounts.get(i) instanceof FederationLawAccount ){
                FederationLawAccount.add((FederationLawAccount)accounts.get(i));
            }
        }
        for(int i=0; i<FederationLawAccount.size()-1; i++){ //ordenação CRESCENTE
            for(int j=i; j<FederationLawAccount.size(); j++){
                if(FederationLawAccount.get(j).getBalance() < FederationLawAccount.get(i).getBalance()){
                    FederationLawAccount aux = (FederationLawAccount)FederationLawAccount.get(j);
                    FederationLawAccount.set(j,FederationLawAccount.get(i));
                    FederationLawAccount.set(i,aux);
                }
            }
        }
        //devolução de todos ordenados
        ArrayList<LawAccount> LawAccount = new ArrayList<>();
        for(int i =0; i<CityLawAccount.size();i++){
            LawAccount.add(CityLawAccount.get(i));
        }
        for(int i =0; i<StateLawAccount.size();i++){
            LawAccount.add(StateLawAccount.get(i));
        }
        for(int i =0; i<FederationLawAccount.size();i++){
            LawAccount.add(FederationLawAccount.get(i));
        }
        return LawAccount;
    }
    
    public String getAccount(BankAccount b){
        if(b instanceof RegularAccount){
            return "RA";
        }
        else if(b instanceof SavingsAccount){
            return "SA";
        }
        else if(b instanceof CityLawAccount){
            return "CLA";
        }
        else if(b instanceof StateLawAccount){
            return "SLA";
        }
        else if(b instanceof FederationLawAccount){
		return "FLA";
        }
        else 
            return null;
    }

    @Override
    public double getBalance(int accountNumber, int identificador) {
        try{
            for (int i=0 ; i<accounts.size()-1 ; i++){
                if(accounts.get(i).getAccountNumber()== accountNumber)
                   return accounts.get(i).getBalance();
            }
            throw new IllegalArgumentException("Conta não encontrada");
        } 
        catch (IllegalArgumentException e){
           System.out.println(e.getMessage());   
        }
        return -1;
    }

    @Override
    public void deposit(int accountNumber, double value, int identificador) {
        try{
            for (int i=0 ; i<accounts.size()-1 ; i++){
                if(accounts.get(i).getAccountNumber()== accountNumber)
                    accounts.get(i).deposit(value);
            }
            throw new IllegalArgumentException ("Conta não encontrada");
        } 
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void withdraw(int accountNumber, double value, int identificador) {
        try{
            if (value>this.getBalance(accountNumber,identificador))
                throw new IllegalArgumentException ("Saldo insuficiente");
            else {
                for (int i=0; i<accounts.size()-1;i++){
                    if (accounts.get(i).getAccountNumber()==accountNumber)
                        accounts.get(i).withDraw(value);
                }
            }
            throw new IllegalArgumentException ("Conta não encontrada");
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }    
    }
}