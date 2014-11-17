package bank;

public class User{
    
    public static void doOperation(BankAccountOperation bao, byte type, int accountNumber, int identificador) throws Exception{
        try{
            if(type == 0){
                double balance = bao.getBalance( accountNumber, identificador);
            }
            throw new IllegalArgumentException("Operação não foi realizada");
        }
        catch (IllegalArgumentException e){
           System.out.println(e.getMessage());   
        }
    }
    
    public static void doOperation(BankAccountOperation bao, byte type, int accountNumber, double value, int identificador) throws Exception{
        try{
            switch(type){
                case 1:
                    bao.deposit( accountNumber, value, identificador);
                    break;
                case 2:
                    bao.withdraw(accountNumber, value, identificador);
                    break;
            }
            throw new IllegalArgumentException("Operação não foi realizada");
        }
        catch (IllegalArgumentException e){
           System.out.println(e.getMessage());   
        }
    }
}
