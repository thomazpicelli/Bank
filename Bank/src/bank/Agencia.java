package bank;
//Thomaz Picelli e Marcelo Oliveira
import java.util.*;

public class Agencia{
    private int numAgencia; //Número da Agencia;
    private String nomeAgencia; //Nome Agencia;
    private BankAccount conta; //conta vinculada a agencia (Savings, Regular ou Law);
    private ArrayList<Agencia> agencias;
    
    public Agencia(){
        agencias = new ArrayList<Agencia>();
    }
    
    public Agencia(int numAgencia, String nomeAgencia, BankAccount conta){
        this.numAgencia = numAgencia;
        this.nomeAgencia = nomeAgencia;
        this.conta = conta;            
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
        double saldoTotal = 0.0;
        for (Agencia a: agencias){
            if (i.numAgencia == a.numAgencia){
                double saldoTotal = saldoTotal + a.conta.getBalance();
            }
        }
        return saldoTotal;
    }
}
