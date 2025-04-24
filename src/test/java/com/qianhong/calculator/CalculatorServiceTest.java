package com.qianhong.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

public class CalculatorServiceTest {

    @Test
    public void testPing() {
        assertThat(new CalculatorService().ping(), containsString("Welcome to Java Maven Calculator Web App!!!"));
    }

    @Test
    public void testAdd() {
        assertEquals(34, new CalculatorService().Add(8, 26).getResult());
    }

    @Test
    public void testSub() {
        assertEquals(4, new CalculatorService().Sub(12, 8).getResult());
    }

    @Test
    public void testMul() {
        assertEquals(88, new CalculatorService().Mul(11, 8).getResult());
    }

    @Test
    public void testDiv() {
        assertEquals(1, new CalculatorService().Div(12, 12).getResult());
    }
    
    //Test the calculator that errors when any number divided by zero
    @Test
    (expected = ArithmeticException.class)
    public void testDivByZero() {
        (new CalculatorService()).Div(12, 0).getResult();
    }
    //Test the result by add a number with zero
    @Test
    public void testAddWithZero() {
        assertEquals(8L, (long)(new CalculatorService()).Add(8, 0).getResult());
    }
}
