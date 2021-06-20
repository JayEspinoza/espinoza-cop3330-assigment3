package ex46;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class frequencyMethodsTest {

    @Test
    @DisplayName("Rolling, Rolling, Rolling")
    void findFrequency() {
        // User inputs Rolling Rolling Rolling
        frequencyMethods frequency = new frequencyMethods();
        Map<String, Integer> test = new HashMap<>();
        ArrayList<String> testList = new ArrayList<String>();

        testList.add("Rolling");
        testList.add("Rolling");
        testList.add("Rolling");

        // findFrequency finds the frequency of the words
        test = frequency.findFrequency(testList);

        assertEquals(3, test.get("Rolling"));
    }
}