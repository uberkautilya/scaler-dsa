package low_level_design.oops.oops4.interfaces.phonepe;

public class PhonePe {
    BankAPI b = new YesBankAPI();
    void display(){
        System.out.println("b.getBalance() = " + b.getBalance());
    }
    void deposit(){
        b.getDeposit();
    }
}
