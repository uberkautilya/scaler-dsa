package low_level_design_two.design_pattterns.structural.adapter.v1;

public class ICICIBankAPI {
    public int getBalance() {
        return 1000;
    }

    public void moneyTransfer(int from, int to, int amount) {
        System.out.println("Money transferred via ICICI bank API");
    }
}
