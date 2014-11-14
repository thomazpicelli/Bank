package bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class ATM 
  implements BankAccountOperation {
    
    private ArrayList<BankAccount> banks;
    private Bank b; // banco vinculado ao caixa eletrônico
    private double fee; // taxa cobrada pela uso do caixa eletrônico
    
    public ATM(Bank b, double fee){
        this.b = b;
        this.fee = fee;
    }
    
    public ATM(String filename){
        banks = new ArrayList<BankAccount>();
        try{
            BufferedReader entrada = new BufferedReader(new FileReader(filename));  //leitura

            String numero = entrada.readLine(); 
            int numDeContas = Integer.parseInt(numero);  //conversão de tipo primitivo

            for(int i = 0; i<numDeContas; i++) { 
                String line = entrada.readLine();
                String conta[] = line.split("#");
                banks.add(i,new XXXXX(Integer.parseInt(conta[1]),conta[2]));       
            }    
        }
        catch(IOException e){
            System.exit(-1);
        }
    }

    
    static double doGetBalance(BankAccountOperation bao,int accountNumber){
        return bao.getBalance(accountNumber);
    }

    @Override
    public double getBalance(int accountNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deposit(int accountNumber, double value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void withdraw(int accountNumber, double value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}