package low_level_design_two.design_pattterns.structural.adapter.v1;

public class ICICIBankAdapter implements BankAPI {
    ICICIBankAPI iciciAPI = new ICICIBankAPI();

    @Override
    public int checkBalance() {
        return iciciAPI.getBalance();
    }

    @Override
    public boolean transferMoney(int from, int to, int amount) {
        iciciAPI.moneyTransfer(from, to, amount);
        return true;
    }
}
