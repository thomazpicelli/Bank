
package bank;

class ATM implements BankAccountOperation {
    private Bank b; // banco vinculado ao caixa eletrônico
    private double fee; // taxa cobrada pela uso do caixa eletrônico
    
    public ATM(Bank b, double fee){
        this.b = b;
        this.fee = fee;
    }
    
    static double doGetBalance(BankAccountOperation bao,int accountNumber){
        return bao.getBalance(accountNumber);
    }

    @Override
    public double getBalance(int accountNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deposit(int accountNumber, double value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void withdraw(int accountNumber, double value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}