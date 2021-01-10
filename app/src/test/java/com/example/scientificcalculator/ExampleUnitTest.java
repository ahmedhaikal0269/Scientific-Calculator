package com.example.scientificcalculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void myUnitTest(){
        dataQueue qTest = new dataQueue();
        assertTrue(qTest.isEmpty());
        for(int i = 0; i < 10; i++){
            qTest.enqueue(i);
            assertFalse(qTest.isEmpty());
        }
        assertTrue(qTest.isReady());
        for(int i = 0; i < 10; i++){
            assertTrue(qTest.dequeue().equals(i));
        }
        assertTrue(qTest.isEmpty());
    }
    @Test
    public void anotherTest(){
        dataQueue qTest = new dataQueue();
        assertTrue(qTest.isEmpty());
        String name = "Ahmed";
        for (int i = 0; i < 3; i ++){
            qTest.enqueue(name);
            assertFalse(qTest.isEmpty());
        }
        assertTrue(qTest.isReady());
        qTest.makeEmpty();
        assertTrue(qTest.isEmpty());
    }

    @Test
    public void calculationTest(){
        calculation answer = new calculation();
        assertFalse(answer.ready());
        answer.encode("10");
        answer.encode("+");
        answer.encode("2");
        assertTrue(answer.ready());
        assertEquals(0, answer.evaluate(), 0.0000001);
        answer.decode();
        assertTrue(answer.getResult() == 10);
        assertTrue(answer.getOperation() == '+');
        assertTrue(answer.getNum() == 2);
        assertTrue(answer.evaluate() == 12);
        //assertEquals(12, answer.evaluate(), 0.000000001);
    }
}

