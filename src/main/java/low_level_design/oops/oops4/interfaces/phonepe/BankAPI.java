package low_level_design.oops.oops4.interfaces.phonepe;

public interface BankAPI {
    int getBalance();

    void getDeposit();

    default void common() {
        System.out.println("BankAPI text");
    }
}
