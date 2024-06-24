package low_level_design_two.design_pattterns.structural.adapter.v1;

public class BankAPIFactory {
    public static BankAPI getBankAPIByName(String bankAPIName) {
        if (bankAPIName.equalsIgnoreCase("yesbank")) {
            return new YesBankAdapter();
        } else if (bankAPIName.equalsIgnoreCase("icici")) {
            return new ICICIBankAdapter();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
