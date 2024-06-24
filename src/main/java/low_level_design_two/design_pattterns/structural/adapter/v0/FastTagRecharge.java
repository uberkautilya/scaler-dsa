package low_level_design_two.design_pattterns.structural.adapter.v0;

public class FastTagRecharge {
    int recharge(YesBankAPI yesBankAPI, int amount) {
        if (yesBankAPI.getBalance() > amount) {
            System.out.println("Recharged successfully");
            return 1;
        }
        return -1;
    }
}
