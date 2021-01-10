package com.example.scientificcalculator;

public class calculation {
    private double result;
    private double num;
    private char operation;
    private dataQueue calculate;

    public calculation(){
        result = 0;
        num = 0;
        operation = ' ';
        calculate = new dataQueue();
    }

    public void encode(String input){
        calculate.enqueue(input);
    }

    public void decode(){
        result = Double.parseDouble(calculate.dequeue().toString());
        operation = calculate.dequeue().toString().charAt(0);
        num = Double.parseDouble(calculate.dequeue().toString());
    }
    public boolean ready(){
        return (calculate.isReady());
    }
    public double evaluate(){
        if('+' == operation)
            result += num;
        else if('-' == operation)
            result -= num;
        else if('*' == operation)
            result *= num;
        else if('/' == operation && 0 != num)
            result /= num;
        else if('R' == operation)
            result = Math.pow(result, 1/num);
        else if('P' == operation)
            result = Math.pow(result, num);
        Math.round(result);
        return result;
    }
    public void clear(){
        result = 0;
        operation = ' ';
        num = 0;
    }
    public void emptyQueue(){
        calculate.makeEmpty();
    }
    public double getResult(){
        return result;
    }
    public char getOperation(){
        return operation;
    }
    public double getNum(){
        return num;
    }
}
