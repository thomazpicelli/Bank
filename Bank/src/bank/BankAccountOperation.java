package bank;

public interface BankAccountOperation {
   public double getBalance(int accountNumber);          // saldo de uma determinada conta
   public void deposit(int accountNumber,double value);  // depósito em uma determinada conta
   public void withdraw(int accountNumber,double value); // retirada de uma determinada conta
}
