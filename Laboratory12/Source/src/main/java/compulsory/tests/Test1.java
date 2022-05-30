package compulsory.tests;

import compulsory.annotations.Test;

public class Test1 {
    @Test
    public static void test1() {
        System.out.println("Hello world! I'm test1.");
    }

    @Test
    public static void test2() {
        System.out.println("Hello world! I'm test2.");
    }

    @Test
    public static void test3(int a) {
        System.out.println("Hello world!");
    }
}
