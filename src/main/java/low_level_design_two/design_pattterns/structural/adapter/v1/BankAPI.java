package low_level_design_two.design_pattterns.structural.adapter.v1;

public interface BankAPI {
    int checkBalance();

    boolean transferMoney(int from, int to, int amount);
}
