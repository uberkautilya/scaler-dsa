package low_level_design_two.design_pattterns.structural.adapter.v1;

import low_level_design_two.design_pattterns.structural.adapter.v0.YesBankAPI;

public class YesBankAdapter implements BankAPI {
    YesBankAPI ybAPI = new YesBankAPI();

    @Override
    public int checkBalance() {
        return ybAPI.getBalance();
    }

    @Override
    public boolean transferMoney(int from, int to, int amount) {
        ybAPI.setFrom(from);
        ybAPI.setTo(to);
        ybAPI.setAmount(amount);
        ybAPI.moneyTransfer();
        return true;
    }
}
