package intermediate.dsa27_aug09;

/**
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 * <p>
 * Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).
 * Problem Constraints
 * 1 <= A <= 100_000
 * 0 <= B <= min(2^(A - 1) - 1 , 10^18)
 */
public class KthElementLarge {
    public static void main(String[] args) {
        KthElementLarge kthElementLarge = new KthElementLarge();
//        int result = kthElementLarge.elementAtIndex(3, 3L);
//        int result = kthElementLarge.elementAtIndex(59701, 14634972693719732L); //Stack Overflow. Why?
//        int result = kthElementLarge.elementAtIndex(4, 6L);
//        int result = kthElementLarge.elementAtIndex(3, 2L);
        int result = kthElementLarge.elementAtIndex(277, 887L);
        System.out.println("result = " + result);
    }


    public Integer elementAtIndex(Integer row, Long index) {

        //Ultimately the parent for any element in ancestry is 0 in the first row. This is the base condition
        if (row == 1) return 0;

        //Parent is the value in the row-1 th row, index at index/2.
        //For instance, 10's parent is 1 in the previous row:
        //1-> 10: Child's Even index 0 -> parent value(1). Child's Odd index 1 -> Parent value's complement
        if (index % 2 == 0)
            return elementAtIndex(--row, index / 2); //Index being odd, simply the parent element's value

            //Complement of value of parent element, since index is odd.
            //For instance, 0 -> 01:
            //Child's Even index 0 -> parent value(0). Child's Odd index 1-> Complement of parent value(0's being 1)
        else return 1 - elementAtIndex(--row, index / 2);  //Index being even, complement of parent element's value
    }
}

    /*
    Explanation:

    0
    01
    01 10
    01 10 10 01
    01 10 10 01 10 01 01 10
    01 10 10 01 10 01 01 10 | 10 01 01 10 01 10 10 01

    5,5(odd) -> 4,2(even) -> 3,1(odd) -> 2,0(even)
    1-1(comp)<- 1(same)   <- 1-0(comp)  <- 0(same)
    */