package bank;

import java.util.Date;

public class FederationLawAccount
  extends LawAccount {
    
    private int instance;  // instância do processo
    
    public FederationLawAccount(int accountNumber, String password, String owner, double balance, 
                      String aim,Date start, Date end, double admFee, int instance){
        super(accountNumber, password,owner,balance,aim,start,end,admFee);
        if (instance >3 || instance<1)
            System.exit(-1);
        this.instance=instance;   
    }
    
    public int getInstance(){
        return instance;
    }
}
