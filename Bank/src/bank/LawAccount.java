package bank;

import java.util.Date;

public abstract class LawAccount 
    extends BankAccount {
    
    String aim;        // objetivo da conta
    Date start,        // data da criação da conta
         end;          // data da liberação da conta
    double admFee;     // taxa de administração (em %)
    
    public LawAccount(int accountNumber, String password, String owner, double balance, 
                      String aim,Date start, Date end, double admFee){
             super(accountNumber, password,owner,balance); 
	     this.aim=aim;
             this.start=start;
             this.end=end;
             this.admFee=admFee;
    }
    
    public LawAccount(int accountNumber, String password, String owner, double balance, 
                      String aim, double admFee){
             super(accountNumber, password,owner,balance); 
	     this.aim=aim;
             this.admFee=admFee;
    }
    
    public double getBalance(){
        return balance*(1-admFee/100);
    }
}
