package ru.gb.java_third.reflection;

public class AnotherClassWithTests {

    @Test
    private void privateTestMethod() {
        System.out.println("private test completed (5)");
    }

    @Test
    public void publicTestMethod() {
        System.out.println("public test completed (5)");
    }

    private void privateMethod() {
        System.out.println("private method completed");
    }

    @BeforeSuite
    public void publicMethod() {
        System.out.println("public method completed");
    }

    @Test(priority = 4)
    private void publicTestMethod2() {
        System.out.println("private test completed (4)");
    }

    @BeforeSuite
    private void beforeAllTestMethod() {
        System.out.println("before suite test completed!");
    }

    @AfterSuite
    private void afterAllTestMethod() {
        System.out.println("after suite test completed!");
    }
}
