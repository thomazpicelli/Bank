package bank;

public class User{
    
    
    public static void doOperation(BankAccountOperation bao,byte type,double value){
        try{
            switch(type){
                case 0:
                    ((Bank)bao).getBalance(int accountNumber, int identificador);
                    break;
                case 1:
                    ((Bank)bao).deposit(int accountNumber,double value, int identificador);
                    break;
                case 2:
                    ((Bank)bao).withdraw(int accountNumber,double value, int identificador);
                    break;
            }
            throw new IllegalArgumentException("Operação não foi realizada");
        }
        catch (IllegalArgumentException e){
           System.out.println(e.getMessage());   
        }
    }
}
