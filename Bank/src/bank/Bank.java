package bank;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Bank {
    
    private ArrayList<BankAccount> accounts;
    private ArrayList<SavingsAccount> SavingsAccounts;
    private ArrayList<RegularAccount> RegularAccounts;
    private ArrayList<LawAccount> LawAccounts;
    private ArrayList<CityLawAccount> CityLawAccounts;
    private ArrayList<FederationLawAccount> FederationLawAccounts;
    private ArrayList<StateLawAccount> StateLawAccounts;

    public Bank(){
        accounts = new ArrayList<BankAccount>();
        SavingsAccounts = new ArrayList<SavingsAccount>();
        RegularAccounts = new ArrayList<RegularAccount>();
        LawAccounts = new ArrayList<LawAccount>();
        CityLawAccounts = new ArrayList<CityLawAccount>();
        FederationLawAccounts = new ArrayList<FederationLawAccount>();
        StateLawAccounts = new ArrayList<StateLawAccount>();
    }

    public Bank(String filename){
        accounts = new ArrayList<BankAccount>();
        SavingsAccounts = new ArrayList<SavingsAccount>();
        RegularAccounts = new ArrayList<RegularAccount>();
        LawAccounts = new ArrayList<LawAccount>();
        CityLawAccounts = new ArrayList<CityLawAccount>();
        FederationLawAccounts = new ArrayList<FederationLawAccount>();
        StateLawAccounts = new ArrayList<StateLawAccount>();
    
        try{
            BufferedReader entrada = new BufferedReader(new FileReader(filename));  //leitura

            String numero = entrada.readLine(); 
            int numDeContas = Integer.parseInt(numero);  //conversão de tipo primitivo

            for(int i = 0; i<numDeContas; i++) { 
                String line = entrada.readLine();
                String conta[] = line.split("#");
                switch (conta[0]){
                    case "RA": 
                        RegularAccounts.add(i,new RegularAccount(Integer.parseInt(conta[1]),conta[2],conta[3],Double.parseDouble(conta[4]), Double.parseDouble(conta[5])));
                        break;
                    case "SA":
                        SavingsAccounts.add(i,new SavingsAccount(Integer.parseInt(conta[1]), conta[2], conta[3], Double.parseDouble(conta[4]), Double.parseDouble(conta[5])));
                        break; 
                    case "CLA":
                        CityLawAccounts.add(i, new CityLawAccount(Integer.parseInt(conta[1]),conta[2], conta[3], Double.parseDouble(conta[4]),conta[5],Date.parse(conta[6]),Date.parse(conta[7]),Double.parseDouble(conta[8]),conta[9]));
                        break;
                    case "SLA":
                        StateLawAccounts.add(i, new StateLawAccount(Integer.parseInt(conta[1]),conta[2], conta[3], Double.parseDouble(conta[4]),(conta[5]),Date.parse(conta[6]),Date.parse(conta[7]),Double.parseDouble(conta[8]),conta[9]));
                        break;
                    case "FLA":
                        FederationLawAccounts.add(i, new FederationLawAccount(Integer.parseInt(conta[1]),conta[2], conta[3],Double.parseDouble(conta[4]), (conta[5]),Date.parse(conta[6]),Date.parse(conta[7]),Double.parseDouble(conta[8]),Integer.parseInt(conta[9])));
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
	     
    public void sort(){ //ordenação crescente do saldo
        for (BankAccount b : accounts) {
            BankAccount a = accounts.get(0);
            if(b.getBalance() <= a.getBalance()) {
                BankAccount aux = accounts.get(a);
                accounts.set(a, accounts.get(b));
                accounts.set(b, aux);
            }
        }
    }
   
    public ArrayList<BankAccount> accounts(){
        return accounts;
    }
    
    public ArrayList<SavingsAccount> SavingsAccounts(){
        return SavingsAccounts;  
    }
    
    public void addAccount(BankAccount a){
         //Insere conta na classe Bank
            accounts.add(a);
    }
    
    public double getTotalBalance(){
         //Calcula o saldo total de todas as contas inseridas no Banco
      double s=0.0;
      for(int i=0;i<accounts.size();i++)
          s+=accounts.get(i).getBalance();
      return s;    
    }
    
    public BankAccount find(int accountNumber){
         //Devolve a conta vinculada a um número de conta
        for(int i=0;i<accounts.size();i++)
            if (accounts.get(i).getAccountNumber() == accountNumber)
                return accounts.get(i);
        return null;
    }
    
    public BankAccount getMaximum(){
         //Devolve a conta com o maior saldo possível
        BankAccount max = accounts.get(0);
        for(int i=1;i<accounts.size();i++)
            if (accounts.get(i).getBalance()>max.getBalance())
                accounts.set(i, accounts.get(i));
            return max;
    }
    
    public double count(double limit){
         //Calcula o número de contas com saldo superior ou igual a um limite
        double q=0;
        for (int i=0;i<accounts.size();i++)
            if (accounts.get(i).getBalance() >= limit)
                q++;
        return q;
    }
    
    public String getAccount(BankAccount b){
        if(b instanceof RegularAccount){
            return "ra";
        }
        else if(b instanceof SavingsAccount){
            return "sa";
        }
        else if(b instanceof CityLawAccount){
            return "cla";
        }
        else if(b instanceof StateLawAccount){
            return "sla";
        }
        else if(b instanceof FederationLawAccount){
		    return "fla";
        }
        else 
            return null;
    }
}