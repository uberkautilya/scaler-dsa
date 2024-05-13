package lld.oops4.interfaces.phonepe;

public class YesBankAPI implements BankAPI{
    @Override
    public int getBalance() {
        return 2000;
    }

    @Override
    public void getDeposit() {
        System.out.println("Deposits in Yes");
    }

}
