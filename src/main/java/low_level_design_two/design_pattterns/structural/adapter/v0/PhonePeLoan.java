package low_level_design_two.design_pattterns.structural.adapter.v0;

public class PhonePeLoan {
    boolean checkEligibility(YesBankAPI yesBankAPI) {
        return yesBankAPI.getBalance() > 1000;
    }
}
