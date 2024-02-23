package ru.gb.java_third.reflection;

public class SomeClassWithTests {

    public String publicString;
    private int privateInt = 10;

    @Test
    private void privateTestMethod() {
        System.out.println("private test completed (5)");
    }

    @Test(priority = 2)
    public void publicTestMethod() {
        System.out.println("public test completed (2)");
    }

    private void privateMethod() {
        System.out.println("private method completed");
    }

    public void publicMethod() {
        System.out.println("public method completed");
    }

    @Test(priority = 7)
    private void publicTestMethod2() {
        System.out.println("private test completed (7)");
    }

    @BeforeSuite
    private void beforeAllTestMethod() {
        System.out.println("before suite test completed!");
    }

    @AfterSuite
    public void afterAllTestMethod() {
        System.out.println("after suite test completed!");
    }
}
