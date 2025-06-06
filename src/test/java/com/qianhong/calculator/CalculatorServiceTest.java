package com.qianhong.calculator;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class CalculatorServiceTest {

    @Test
    public void testPing() {
        assertThat(new CalculatorService().ping(), containsString("Welcome to Java Maven Calculator Web App!!!"));
    }

    @Test
    public void testAdd() {
        assertEquals(34, new CalculatorService().add(8, 26).getResult());
    }

    @Test
    public void testSub() {
        assertEquals(4, new CalculatorService().sub(12, 8).getResult());
    }

    @Test
    public void testMul() {
        assertEquals(88, new CalculatorService().mul(11, 8).getResult());
    }

    @Test
    public void testDiv() {
        assertEquals(1, new CalculatorService().div(12, 12).getResult());
    }
  
    @Test
    public void testPow() {
        assertEquals(8, new CalculatorService().pow(2, 3).getResult());
    }

    //Test the calculator that errors when any number divided by zero
    @Test(expected = ArithmeticException.class)  // <- Updated exception type
    public void testDivByZero() {
        (new CalculatorService()).div(12, 0).getResult();
    }

    //Test the result by add a number with zero
    @Test
    public void testAddWithZero() {
        assertEquals(8L, (long)(new CalculatorService()).add(8, 0).getResult());
    }

}
