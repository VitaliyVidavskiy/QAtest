package tests;

import org.junit.jupiter.api.*;

public class FirstJUnitTest {
    @BeforeAll
    static void beforeall() {
        System.out.println("This test will do before all test");
    }

    @BeforeEach
    void before() {
        System.out.println("    This test will do before test");
    }

    @AfterEach
    void after() {
        System.out.println("    This test will do after test");
    }

    @AfterAll
    static void afterall() {
        System.out.println("This test will do after all test");
    }

    @Test
    void textTest() {
        System.out.println("        The first one");
    }

    @Test
    void videoTest() {
        System.out.println("        The second one");
    }
}


