package com.example.scientificcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView screenView;
    private Button dot, zero, one, two, three, four, five, six, seven, eight, nine,
            reset, exit, memoryPlus, memoryDelete, memory, backSpace,
            sin, cos, tan, arcsin, arccos, arctan, radian, degree, pi, log, radical, power,
            plus, minus, multiply, divide, plusORMinus, equal, square, squareRoot, reciprocal;

    private boolean isRad = true, isDeg = false, isNumSet, isDecimal;
    /** isRad => switch to radian mode/ isDeg => switch to degree mode*/
    private double result, mem, resultRad, resultDeg;
    private String screenText;

    private calculation answer;
    public TextView getScreenView() {
        return screenView;
    }

    DecimalFormat df = new DecimalFormat("#.########");
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer = new calculation();

        screenView = (TextView) findViewById(R.id.main_screen);

        //===========create numbers==============

        plusORMinus = (Button) findViewById(R.id.plusMinus);
        dot = (Button) findViewById(R.id.dot);
        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);

        //============create operators==============

        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
        equal = (Button) findViewById(R.id.equal);

        //-----------------top row==================

        memoryPlus = (Button) findViewById(R.id.memoryPlus);
        memoryDelete = (Button) findViewById(R.id.memoryDelete);
        memory = (Button) findViewById(R.id.memory);
        radian = (Button) findViewById(R.id.radian);
        degree = (Button) findViewById(R.id.degree);
        backSpace = (Button) findViewById(R.id.backSpace);
        exit = (Button) findViewById(R.id.OFF);

        //==============second row=================

        pi = (Button) findViewById(R.id.pi);
        sin = (Button) findViewById(R.id.sin);
        cos = (Button) findViewById(R.id.cos);
        tan = (Button) findViewById(R.id.tan);
        arcsin = (Button) findViewById(R.id.arcsin);
        arccos = (Button) findViewById(R.id.arccos);
        arctan = (Button) findViewById(R.id.arctan);

        //============ right column =====================

        log = (Button) findViewById(R.id.log);
        squareRoot = (Button) findViewById(R.id.square_root);
        radical = (Button) findViewById(R.id.y_root);
        square = (Button) findViewById(R.id.square);
        power = (Button) findViewById(R.id.powerOF);
        reciprocal = (Button) findViewById(R.id.reciprocal);
        reset = (Button) findViewById(R.id.reset);

        radian.setTextColor(Color.BLUE);

        /*==================================================
        this section is to set the listeners for all buttons
        ==================================================*/

        //================function buttons===================
        radian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDeg = false;
                isRad = true;
                degree.setTextColor(Color.BLACK);
                radian.setTextColor(Color.BLUE);
                screenView.setText(Double.toString(resultRad));
            }
        });

        degree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRad = false;
                isDeg = true;
                degree.setTextColor(Color.BLUE);
                radian.setTextColor(Color.BLACK);
                screenView.setText(Double.toString(resultDeg));
            }
        });

        memory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mem == 0)
                    screenView.setText(screenView.getText().toString());
                else
                    screenView.setText(Double.toString(mem));
            }
        });

        memoryDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mem = 0;
            }
        });

        memoryPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mem = Double.parseDouble(screenView.getText().toString());
            }
        });

        backSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newScreen = "";
                screenText = screenView.getText().toString();
                if(screenText.length() == 1)
                    screenView.setText("0");
                else{
                    for(int i = 0; i < screenText.length() - 1; i++)
                        newScreen += screenText.charAt(i);
                    screenView.setText(newScreen);
                }
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenView.setText(Double.toString(3.141519265));
                isNumSet = true;
            }
        });

        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenText = screenView.getText().toString();
                resultRad = Math.sin(Double.parseDouble(screenText));
                double getDeg = Double.parseDouble(screenText)*Math.PI/180;
                resultDeg = Math.sin(getDeg);
                if (isRad){
                    result = resultRad;
                    displayResult();
                    //screenView.setText(Double.toString(resultRad));
                }
                else if (isDeg) {
                    result = resultDeg;
                    displayResult();
                    //screenView.setText(Double.toString(resultDeg));
                }
            }
        });

        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenText = screenView.getText().toString();
                resultRad = Math.cos(Double.parseDouble(screenText));
                double getDeg = Double.parseDouble(screenText)*Math.PI/180;
                resultDeg = Math.cos(getDeg);
                if (isRad){
                    result = resultRad;
                    displayResult();
                    //screenView.setText(Double.toString(resultRad));
                }
                else if (isDeg) {
                    result = resultDeg;
                    displayResult();
                    //screenView.setText(Double.toString(resultDeg));
                }
            }
        });

        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenText = screenView.getText().toString();
                resultRad = Math.tan(Double.parseDouble(screenText));
                double getDeg = Double.parseDouble(screenText)*Math.PI/180;
                resultDeg = Math.tan(getDeg);
                if (isRad){
                    result = resultRad;
                    displayResult();
                    //screenView.setText(Double.toString(resultRad));
                }
                else if (isDeg) {
                    result = resultDeg;
                    displayResult();
                    //screenView.setText(Double.toString(resultDeg));
                }
            }
        });

        arcsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenText = screenView.getText().toString();
                resultRad = Math.asin(Double.parseDouble(screenText));
                double getDeg = Double.parseDouble(screenText)*Math.PI/180;
                resultDeg = Math.asin(getDeg);
                if (isRad){
                    result = resultRad;
                    displayResult();
                    //screenView.setText(Double.toString(resultRad));
                }
                else if (isDeg) {
                    result = resultDeg;
                    displayResult();
                    //screenView.setText(Double.toString(resultDeg));
                }
            }
        });

        arccos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenText = screenView.getText().toString();
                resultRad = Math.acos(Double.parseDouble(screenText));
                double getDeg = Double.parseDouble(screenText)*Math.PI/180;
                resultDeg = Math.acos(getDeg);
                if (isRad){
                    result = resultRad;
                    displayResult();
                    //screenView.setText(Double.toString(resultRad));
                }
                else if (isDeg) {
                    result = resultDeg;
                    displayResult();
                    //screenView.setText(Double.toString(resultDeg));
                }
            }
        });

        arctan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenText = screenView.getText().toString();
                resultRad = Math.atan(Double.parseDouble(screenText));
                double getDeg = Double.parseDouble(screenText)*Math.PI/180;
                resultDeg = Math.atan(getDeg);
                if (isRad){
                    result = resultRad;
                    displayResult();
                    //screenView.setText(Double.toString(resultRad));
                }
                else if (isDeg) {
                    result = resultDeg;
                    displayResult();
                    //screenView.setText(Double.toString(resultDeg));
                }
            }
        });

        //===============left Column ======================
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenText = screenView.getText().toString();
                result = Math.log10(Double.parseDouble(screenText));
                displayResult();
                isNumSet = true;
            }
        });

        squareRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenText = screenView.getText().toString();
                result = Math.sqrt(Double.parseDouble(screenText));
                displayResult();
                isNumSet = true;
            }
        });

        radical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenText = screenView.getText().toString();
                answer.encode(screenText);
                answer.encode("R");
                radical.setPressed(true);
                isNumSet = true;
            }
        });

        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenText = screenView.getText().toString();
                double sq = Double.parseDouble(screenText);
                result =  sq * sq;
                displayResult();
                isNumSet = true;
            }
        });

        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenText = screenView.getText().toString();
                answer.encode(screenText);
                answer.encode("P");
                isNumSet = true;
            }
        });

        reciprocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenText = screenView.getText().toString();
                double recip = Double.parseDouble(screenText);
                result = 1/recip;
                displayResult();
                isNumSet = true;
            }
        });

        plusORMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenText = screenView.getText().toString();
                result = Double.parseDouble(screenText);
                result *= -1;
                displayResult();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = 0;
                resultDeg = 0;
                resultRad = 0;
                isDecimal = false;
                screenView.setText("0");
                answer.clear();
                answer.emptyQueue();
            }
        });

        //================number buttons===================

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isDecimal){
                    screenView.setText(screenView.getText() + ".");
                    isDecimal = true;
                }
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screenView.getText().equals("0")||isNumSet) {
                    screenView.setText("0");
                    isNumSet = false;
                }
                else
                    screenView.setText(screenView.getText() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screenView.getText().equals("0")||isNumSet){
                    screenView.setText("1");
                    isNumSet = false;
                }
                else
                    screenView.setText(screenView.getText() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screenView.getText().equals("0")||isNumSet){
                    screenView.setText("2");
                    isNumSet = false;
                }
                else
                    screenView.setText(screenView.getText() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screenView.getText().equals("0")||isNumSet){
                    screenView.setText("3");
                    isNumSet = false;
                }
                else
                    screenView.setText(screenView.getText() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screenView.getText().equals("0")||isNumSet){
                    screenView.setText("4");
                    isNumSet = false;
                }
                else
                    screenView.setText(screenView.getText() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screenView.getText().equals("0")||isNumSet){
                    screenView.setText("5");
                    isNumSet = false;
                }
                else
                    screenView.setText(screenView.getText() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screenView.getText().equals("0")||isNumSet){
                    screenView.setText("6");
                    isNumSet = false;
                }
                else
                    screenView.setText(screenView.getText() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screenView.getText().equals("0")||isNumSet){
                    screenView.setText("7");
                    isNumSet = false;
                }
                else
                    screenView.setText(screenView.getText() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screenView.getText().equals("0")||isNumSet){
                    screenView.setText("8");
                    isNumSet = false;
                }
                else
                    screenView.setText(screenView.getText() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screenView.getText().equals("0")||isNumSet){
                    screenView.setText("9");
                    isNumSet = false;
                }
                else
                    screenView.setText(screenView.getText() + "9");
            }
        });
        //================operator buttons===================

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenText = screenView.getText().toString();
                answer.encode(screenText);
                if(answer.ready()){
                    answer.decode();
                    result = answer.evaluate();
                    answer.encode(Double.toString(result));
                    answer.clear();
                    //screenView.setText(Double.toString(result));
                    displayResult();
                    result = 0;
                }
                answer.encode("+");
                isNumSet = true;
                isDecimal = false;
            }

        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenText = screenView.getText().toString();
                answer.encode(screenText);
                if(answer.ready()){
                    answer.decode();
                    result = answer.evaluate();
                    answer.encode(Double.toString(result));
                    answer.clear();
                    //screenView.setText(Double.toString(result));
                    displayResult();
                    result = 0;
                }
                answer.encode("-");
                isNumSet = true;
                isDecimal = false;
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenText = screenView.getText().toString();
                answer.encode(screenText);
                if(answer.ready()){
                    answer.decode();
                    result = answer.evaluate();
                    answer.encode(Double.toString(result));
                    answer.clear();
                    //screenView.setText(Double.toString(result));
                    displayResult();
                    result = 0;
                }
                answer.encode("*");
                isNumSet = true;
                isDecimal = false;
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenText = screenView.getText().toString();
                answer.encode(screenText);
                if(answer.ready()){
                    answer.decode();
                    result = answer.evaluate();
                    answer.encode(Double.toString(result));
                    answer.clear();
                    //screenView.setText(Double.toString(result));
                    displayResult();
                    result = 0;
                }
                answer.encode("/");
                isNumSet = true;
                isDecimal = false;
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenText = screenView.getText().toString();
                answer.encode(screenText);
                if(answer.ready()){
                    answer.decode();
                    result = answer.evaluate();
                    //answer.encode(Double.toString(result));
                    answer.clear();
                    //screenView.setText(Double.toString(result));
                    displayResult();
                    result = 0;
                }
                isNumSet = true;
                isDecimal = false;
            }
        });
    }

    public void displayResult(){
        String initResult;
        String finalResult = "";
        char character;
        if(result % 1 != 0) {
            initResult = Double.toString(result);
            if(initResult.length() < 11)
                screenView.setText(initResult);
            else {
                for (int i = 0; i < 11; i++) {
                    character = initResult.charAt(i);
                    finalResult += character;
                }
                result = Double.parseDouble(finalResult);
                screenView.setText(Double.toString(result));
            }
        }
        else{
            int resultINT = (int)result;
            screenView.setText(Integer.toString(resultINT));
        }
    }
}
