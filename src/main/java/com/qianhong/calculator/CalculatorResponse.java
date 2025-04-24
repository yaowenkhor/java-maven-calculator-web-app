package com.qianhong.calculator;

import java.util.Date;

public class CalculatorResponse {

    int _operand1;
    int _operand2;
    int _result;
    String _time;

    public CalculatorResponse(int x, int y, int result) {
    	_operand1 = x;
    	_operand2 = y;
        _result = result;
        _time = new Date().toString();
    }

    public int getOperand1() {
        return _operand1;
    }

    public int getOperand2() {
        return _operand2;
    }

    public int getResult() {
        return _result;
    }

    public String getTime() {
        return _time;
    }
}
