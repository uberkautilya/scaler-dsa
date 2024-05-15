package low_level_design.oops.oops4.interfaces.phonepe;

public class ICICIBankAPI implements BankAPI, BankAPI2{
    @Override
    public int getBalance() {
        return 1000;
    }

    @Override
    public void getDeposit() {
        System.out.println("ICICI deposits");
    }

    @Override
    public void common() {
        BankAPI.super.common();
    }
}
