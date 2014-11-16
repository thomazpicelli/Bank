package bank;

public interface BankAccountOperation {
   
    
    public double getBalance(int accountNumber, int identificador);          // saldo de uma determinada conta
    public void deposit(int accountNumber,double value, int identificador);  // depósito em uma determinada conta
    public void withdraw(int accountNumber,double value, int identificador); // retirada de uma determinada conta

}
