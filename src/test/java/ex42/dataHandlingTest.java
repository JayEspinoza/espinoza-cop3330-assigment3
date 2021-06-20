package ex42;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class dataHandlingTest {

    @Test
    @DisplayName("A,B,C")
    void parseData() {
        // User inputs A,B,C
        ArrayList<String> testList = new ArrayList<String>();
        dataHandling handler = new dataHandling();

        testList.add("A,B,C");

        // Data is parsed
        testList = handler.parseData(testList);

        assertEquals("A", testList.get(0));
    }
}