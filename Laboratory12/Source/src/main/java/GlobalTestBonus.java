import bonus.annotations.Test;

public class GlobalTestBonus {
    @Test
    public static void test1(int a, int b) {
        System.out.println("[Test1]");
        System.out.println("a = " + a + ", b = " + b + "; a + b = " + (a + b));
    }

    @Test
    public static void test2(int a, int b) {
        System.out.println("[Test2]");
        System.out.println("a =  " + a + ",b = " + b + "; a - b = " + (a - b));
    }

    @Test
    public void test3(int a, int b) {
        System.out.println("[Test3]");
        System.out.println("a =  " + a + ",b = " + b + "; a * b = " + (a * b));
    }

    @Test
    public void test4(String name) {
        System.out.println("[Test4]");
        System.out.println("Hello, " + name);
    }
}
