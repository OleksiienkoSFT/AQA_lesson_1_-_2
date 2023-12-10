package Lesson_1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParametrizedTest {
    @AfterEach
    void aftereachTest(){
        System.out.println();
        System.out.println("Next test");
    }

    @ParameterizedTest(name = "Run: {index}, values : {arguments}")
    @ValueSource(ints = {1,4,7})
    void intValues(int theParam){
        System.out.println("Params = " + theParam);
    }

    @ParameterizedTest(name = "Run: {index}, values : {arguments}")
    @ValueSource(strings = {"10","radar","race car"})
    void intValues(String theParam){
        System.out.println("Params = " + theParam);
    }

    @ParameterizedTest(name = "Run: {index}, values : {arguments}")
    @EmptySource
    @ValueSource(strings = {"String 1", "String 2"})
    void stringValues(String param){
        System.out.println("params  = " + param);
    }

    @ParameterizedTest(name = "Run: {index}, values : {arguments}")
    @CsvSource(value = {"captain america, 'Steve Rogers'", "winter solder, 'Bucky, Barnes'"})
    void csv_quotestStringwithComa (String param1, String param2){
        System.out.println("param1  = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve, 33, true", "captain,  21, false", "bucky, 5, true"})
    void csv_SourceStringIntBoolean(String param1, int param2, boolean param3){
        System.out.println("param1 = " + param1 +", param2 = " + param2 +", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"captain?america", "bucky?barnes"}, delimiter = '?')
    void csv_stringWithCustomDelimiter(String param1, String param2 ){
        System.out.println("param1 = " + param1 +", param2 = " + param2);
    }

    @ParameterizedTest(name = "Run: {index}, values : {arguments}")
    @CsvFileSource(files = "src/test/resources/somegoods", numLinesToSkip = 1)
    void csv_fileSource (String name, double price, int quantity, String unit, String provider){
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity + ", unit = " + unit + ",  " + provider);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceStringAsStream")
    void method_source_String(String param1){
        System.out.println("param1 = " + param1);
    }

    List<String> sourceString(){
        return Arrays.asList("tomato", "carrot", "apples", "orange");
    }

    static Stream<String> sourceStringAsStream(){
        return Stream.of("tomato", "carrot", "apples", "orange");
    }
}
