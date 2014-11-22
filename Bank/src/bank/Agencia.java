package bank;

import java.util.*;

public class Agencia extends BankAccount{
    private int numAgencia; //Número da Agencia;
    private String nomeAgencia; //Nome Agencia;
    private ArrayList<Agencia> agencias;
    
    
    public Agencia(){
        agencias = new ArrayList<Agencia>();
    }
    
    public Agencia(int numAgencia, String nomeAgencia){
        this.numAgencia = numAgencia;
        this.nomeAgencia = nomeAgencia;
                
    }
    
    public void inserir(Agencia i){
        boolean flag = false;
        for (Agencia a: agencias){
            if (i.numAgencia == a.numAgencia){
                flag = true;
            }
        }
        if (flag == false){
            agencias = new ArrayList<Agencia>();
            agencias.add(i);
        }
    }
    
    public Agencia busca(Agencia i){
        for (Agencia a: agencias){
            if (i.numAgencia == a.numAgencia){
                return i;
            }
        }
        return null;
    }
    
    public double saldoTotal(Agencia i){
        double saldoTotal;
        for (Agencia a: agencias){
            if (i.numAgencia == a.numAgencia){
                double saldoTotal = saldoTotal + a.getBalance();
            }
        }
        return saldoTotal;
    }
    
}
