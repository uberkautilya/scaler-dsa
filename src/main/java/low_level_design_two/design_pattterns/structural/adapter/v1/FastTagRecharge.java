package low_level_design_two.design_pattterns.structural.adapter.v1;

public class FastTagRecharge {
    static int recharge(BankAPI bankAPI, int amount) {
        if (bankAPI.checkBalance() > amount) {
            System.out.println("Recharged successfully");
            return 1;
        }
        return -1;
    }
}
