package low_level_design_two.design_pattterns.structural.adapter.v1;

public class YesBankAPI {
    int getBalance() {
        return 100;
    }
    void moneyTransfer() {
        System.out.println("Money transferred via YesBankAPI");
    }
}
