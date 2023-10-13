package advanced.contest_oct13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SortStringOnLength {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>(Arrays.asList("hi", "hello", "he"));
        strList = new ArrayList<>(Arrays.asList("could", "bat", "cat", "but"));
        strList = new ArrayList<>(Arrays.asList("hscsa", "rowjldmri", "vhwfhtt", "uokfgrhub", "dwtt", "slvhjhzqvd", "gmqp", "ed", "rj", "lbq", "sn", "xr", "xkdq", "vqqy",
                "nllqq", "vvzfqfxo", "ixigsijc", "w", "ksrteu", "itus", "okd", "ql", "mzelci", "wat", "jstsk", "dbmxokbci", "p", "vsvhynydt", "y", "bqkookad", "ie",
                "imqb", "mdqhse", "b", "ajgocaby", "xgxem", "q", "pcughxzm", "kxds", "ujpzfizvs", "un", "z", "wdfxf", "kbkfygto", "qmtlvg", "txqgeo", "kftvudxih",
                "wdwsqbj", "ys", "vaxcz", "beea", "hvagkwux", "yewvbpjlvz", "gcaiwns", "etvghgs", "cedomdx", "xtpwxe", "rqhocxon", "ncteuspdj", "qiwvyhze", "vheoqp",
                "jajni", "u", "iakxvcdjcm", "aa", "ri", "ka", "fffn", "ghgye", "rmmxyrvyyi", "y", "zfxv", "naiukdnf", "flqyjkl", "fnjqxk", "zjqbuchqq", "ip", "z",
                "klfq", "ppkztthig", "oopdczanh", "gsvdjppnlo", "u", "tl", "pb", "zicur", "puu", "wgikirdlkw", "udywnbdfhy", "i"));
        ArrayList<String> solve = new SortStringOnLength().solve(strList);
        System.out.println("solve = " + solve);
    }

    public ArrayList<String> solve(ArrayList<String> A) {

        A.sort(new StringComparator());
        return A;
    }

    public class StringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int l1 = o1.length();
            int l2 = o2.length();
            if (l1 != l2) {
                return l1 - l2;
            }
            return 0;
        }
    }
}
