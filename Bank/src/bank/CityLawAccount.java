package bank;

import java.util.Date;

public class CityLawAccount
  extends LawAccount {
    
    private String city;  // comarca da conta vinculada
    
    public CityLawAccount(int accountNumber, String password, String owner, double balance, 
                      String aim,Date start, Date end, double admFee, String city){
        super(accountNumber, password,owner,balance,aim,start,end,admFee);
        this.city=city;   
    }
    
    public String getCity(){
        return city;
    }
}
