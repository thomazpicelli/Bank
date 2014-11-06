import java.io.*;
import java.util.ArrayList;

public class Bank {
    
    private ArrayList<BankAccount> accounts;
    private ArrayList<SavingsAccount> SavingsAccounts;

    public Bank(){
        accounts = new ArrayList<BankAccount>();
        SavingsAccounts = new ArrayList<SavingsAccount>();
    }

    public Bank(String filename){
        accounts = new ArrayList<BankAccount>();
        SavingsAccounts = new ArrayList<SavingsAccount>();

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(filename));  //leitura

            String numero = entrada.readLine(); 
            int numDeContas = Integer.parseInt(numero);  //conversão de tipo primitivo

            for(int i = 0; i<numDeContas; i++) { 
                String line = entrada.readLine();
                String conta[] = line.split("#");
                if (conta[4] == "#"){
                    BankAccount a = new BankAccount (Integer.parseInt(conta[0]), conta[1], conta[2], Double.parseDouble(conta[3]));
                    accounts.set(i, a);
                }
                else{
                    SavingsAccount b = new SavingsAccount (Integer.parseInt(conta[0]), conta[1], conta[2], Double.parseDouble(conta[3]), Double.parseDouble(conta[4]));
                    SavingsAccounts.set(i, b);
            }
        }
        catch(IOException e) {
            System.exit(-1);
        }
    }

    public void dump(String filename) {
        try {
            BufferedWriter saida = new BufferedWriter(new FileWriter(filename));
            saida.write(accounts.size() + "\n");

            for (BankAccount b : accounts) {
                saida.write(b.getAccountNumber() + "#" + b.getPassword() + "#" + b.getName() + "#" + b.getBalance() + "\n");
            }
            saida.flush();
            saida.close();
        }
        catch(IOException | NumberFormatException e) {
            System.exit(-1);
        }
    }
	     
    public void sort(){ //ordenação crescente do saldo
        for (Bank b : accounts) {
            Bank a = accounts.get(0);
            if(b.getBalance() <= a.getBalance()) {
                int aux = accounts.get(a);
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
}

public class TestaBank{
    public static void main(String args[]){
        
        Bank listaConta = new Bank();
        listaConta.Bank("entrada.txt");
        listaConta.dump("saida.txt");
    }
}
