package low_level_design_two.design_pattterns.structural.adapter.v0;

public class PhonePe {
    YesBankAPI yesBankAPI = new YesBankAPI();
    FastTagRecharge fastTagRecharge = new FastTagRecharge();
    PhonePeLoan phonePeLoan = new PhonePeLoan();

    boolean doFastTagRecharge(int amount) {
        return (fastTagRecharge.recharge(yesBankAPI, 50) > 1);
    }

    boolean availLoan() {
        if (!phonePeLoan.checkEligibility(yesBankAPI)) {
            System.out.println("Not eligible for loan");
        } else {
            System.out.println("Loan granted");
        }
        return true;
    }

}
