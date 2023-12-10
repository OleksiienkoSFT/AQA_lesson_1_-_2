package Lesson_1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionTestClass {

    @Test
    void assertionEquals(){
        assertEquals("Black", "White", "The string values are not equals!");
    }

    @Test
    void assertList(){
        List<String> expected = Arrays.asList("black", "white", "grey");
        List<String> actual = Arrays.asList("black", "white", "grey");
        assertEquals(expected, actual, "Lists values are not equals!");
    }

    @Test
    void assertTrueTest(){
        assertTrue(true);
    }
    @Test
    void assertThrowTest(){
        assertThrows(NullPointerException.class, null);
    }
    @Test
    void assertAllTest(){
        assertAll(
                () -> assertEquals("Black", "White", "The string values are not equals!"),
                () -> assertTrue(true),
                () -> assertEquals("Rad", "White", "The string values are not equals!")
        );
    }


}
