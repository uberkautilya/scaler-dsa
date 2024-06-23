package low_level_design_two.design_pattterns.creational.singleton.assignments.one;

public class Main {
    public static void main(String[] args) {
        FileBasedConfigurationManager fileBasedConfigurationManager = FileBasedConfigurationManagerImpl.getInstance();
        fileBasedConfigurationManager.setConfiguration("a", "2");
        Integer a = fileBasedConfigurationManager.getConfiguration("a", Integer.class);
        System.out.println("a = " + a);
    }
}
