package ex45;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class wordMethodsTest {

    @Test
    @DisplayName("utilize")
    void replaceWord() {
        // User inputs utilize
        ArrayList<String> testList = new ArrayList<String>();
        wordMethods wordHelper = new wordMethods();

        testList.add("utilize");

        // Replace word replaces utilize
        testList = wordHelper.replaceWord(testList);

        assertEquals("use", testList.get(0));
    }
}