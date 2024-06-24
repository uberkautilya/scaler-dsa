package low_level_design_two.design_pattterns.structural.adapter.v1;

import java.util.Scanner;

public class Client {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Chose either yesbank / icici");
        String bankAPIName = sc.nextLine();
        BankAPI bankAPI = BankAPIFactory.getBankAPIByName(bankAPIName);
        System.out.println(bankAPI.checkBalance());
        bankAPI.transferMoney(100, 12, 234);
    }
}
