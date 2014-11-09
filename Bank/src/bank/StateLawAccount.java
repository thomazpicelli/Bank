package bank;

import java.util.Date;

public class StateLawAccount
  extends LawAccount {
    
    private String state;  // estado da conta vinculada
    
    public StateLawAccount(int accountNumber, String password, String owner, double balance, 
                      String aim,Date start, Date end, double admFee, String state){
        super(accountNumber, password,owner,balance,aim,start,end,admFee);
        if (state.length()!=2)
            System.exit(-1);
        this.state=state;   
    }
    
    public StateLawAccount(int accountNumber, String password, String owner, double balance, 
                      String aim,double admFee, String state){
        super(accountNumber, password,owner,balance,aim,admFee);
        if (state.length()!=2)
            System.exit(-1);
        this.state=state;   
    }
    
    public String getState(){
        return state;
    }
}
