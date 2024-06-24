package low_level_design_two.design_pattterns.structural.adapter.v0;

public class YesBankAPI {
    int from;
    int to;
    int amount;

    public void setFrom(int from) {
        this.from = from;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBalance() {
        return 100;
    }
    public void moneyTransfer() {
        System.out.println("Money transferred via YesBankAPI");
    }
}
