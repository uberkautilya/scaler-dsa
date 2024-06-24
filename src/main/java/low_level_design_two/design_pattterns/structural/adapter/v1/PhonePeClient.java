package low_level_design_two.design_pattterns.structural.adapter.v1;

public class PhonePeClient {
    BankAPI yesBankAPI = new YesBankAdapter();
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
