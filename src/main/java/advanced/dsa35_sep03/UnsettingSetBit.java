package advanced.dsa35_sep03;

public class UnsettingSetBit {
    public static void main(String[] args) {
        UnsettingSetBit unsettingSetBit = new UnsettingSetBit();
        //Todo: Think how it would work with negative numbers
        int num = 55;
        System.out.println("Integer.toBinaryString(num) = \n" + Integer.toBinaryString(num));
        int result = unsettingSetBit.unsetBit(num, 5);

        System.out.println("Integer.toBinaryString(result) = \n" + Integer.toBinaryString(result));

    }


    int unsetBit(int num, int index) {
        if ((num & (1 << index)) != 0) {
            num = num ^ (1 << index);
        }
        return num;
    }

}
