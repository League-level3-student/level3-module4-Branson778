package _01_TestMatchingBrackets;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class TestMatchingBracketsTest {

    @Test
    public void testMatchingBrackets1() {
        assertTrue(TestMatchingBrackets.doBracketsMatch("{}"));
    }
    @Test
    public void testMatchingBrackets2() {
        assertTrue(TestMatchingBrackets.doBracketsMatch("{{}}"));
    }
    @Test
    public void testMatchingBrackets3() {
        assertTrue(TestMatchingBrackets.doBracketsMatch("{}{}{{}}"));
    }
    @Test
    public void testMatchingBrackets4() {
        assertFalse(TestMatchingBrackets.doBracketsMatch("{{}"));
    }
    @Test
    public void testMatchingBrackets5() {
    	assertFalse(TestMatchingBrackets.doBracketsMatch("}{"));
    }
}