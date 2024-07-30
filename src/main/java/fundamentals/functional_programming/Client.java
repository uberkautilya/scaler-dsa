package fundamentals.functional_programming;

import java.util.function.Supplier;

public class Client {
    public static void main(String[] args) {
        Test test = new Test(101, "Name 101");
        Supplier<String> stringSupplier = test::getName;

        System.out.println(stringSupplier.get());

        test.setName("New Name");
        System.out.println(stringSupplier.get());

    }
    public static class Test{
        int id;
        String name;

        public Test(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
