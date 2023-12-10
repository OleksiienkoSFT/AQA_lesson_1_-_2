package Lesson_1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;


public class FirstTestClass {

    @BeforeAll
    static void setupBeforeAll(){
        System.out.println("....BeforeAll setup method....");
    }

    @BeforeEach
    void setupBeforeEach(){
        System.out.println("....BeforeEach setup method....");
    }

    @AfterAll
    static void AfterAllCleanUp(){
        System.out.println("...After All cleanUp method....");
    }

    @AfterEach
    void AfterEachCleanUp(){
        System.out.println("...After Each cleanUp method....");
    }

    @Disabled
    void disabledTest(){
        System.out.println("I disabled something.");
    }

    @Test
    @DisplayName("For WINDOWS")
    @EnabledOnOs(value = OS.WINDOWS, disabledReason = "TEST only for Windows")
    void enabledOnOs (){
        System.out.println("TEST only for Windows");
    }

    @Test
    @DisplayName("My first test.")
    @Order(2)
    void firstMethod(){
        System.out.println("First method!!");
    }

    @Test
    @DisplayName("My second test.")
    @Order(1)
    void secondMethod(){
        System.out.println("Second method!!");
    }
}
