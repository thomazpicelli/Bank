package bank;

public interface BankAccountOperation {
   
    public double getBalance(int accountNumber, int identificador)throws Exception;          // saldo de uma determinada conta
    public void deposit(int accountNumber,double value, int identificador)throws Exception;  // depósito em uma determinada conta
    public void withdraw(int accountNumber,double value, int identificador)throws Exception; // retirada de uma determinada conta

}
