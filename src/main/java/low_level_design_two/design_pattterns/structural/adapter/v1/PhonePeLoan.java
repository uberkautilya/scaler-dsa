package low_level_design_two.design_pattterns.structural.adapter.v1;

public class PhonePeLoan {
    boolean checkEligibility(BankAPI yesBankAPI) {
        return yesBankAPI.checkBalance() > 1000;
    }
}
