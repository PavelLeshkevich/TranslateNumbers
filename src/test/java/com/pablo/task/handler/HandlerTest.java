package com.pablo.task.handler;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HandlerTest {

    String convert(ArrayList<String> result) {
        String string = "";
        for(int it = 0; it < result.size() - 1; it++) {
            string += result.get(it) + " ";
        }
        return string + result.get(result.size() - 1);
    }

    @Test
    public void testOne() throws Exception {
        Handler handler = new Handler("111111111111");
        String answer = convert(handler.run());
        String correctAnwer = "сто одиннадцать миллиардов сто одиннадцать миллионов сто одиннадцать тысяч сто одиннадцать";
        if(answer.equals(correctAnwer)) {
            System.out.println("OK, TestOne");
        }
        else {
            System.out.println("Wrong, TestOne");
        }
    }

    @Test
    public void testTwo() throws Exception {
        Handler handler = new Handler("123456789");
        String answer = convert(handler.run());
        String correctAnwer = "сто двадцать три миллиона четыреста пятьдесят шесть тысяч семьсот восемьдесят девять";
        if(answer.equals(correctAnwer)) {
            System.out.println("OK, TestTwo");
        }
        else {
            System.out.println("Wrong, TestTwo");
        }
    }

    @Test
    public void testThree() throws Exception {
        Handler handler = new Handler("98721561874600000000");
        String answer = convert(handler.run());
        String correctAnwer = "девяноста восемь квинтильонов семьсот двадцать один квадрильон пятьсот шестьдесят один триллион восемьсот семьдесят четыре миллиарда шестьсот миллионов";
        if(answer.equals(correctAnwer)) {
            System.out.println("OK, TestThree");
        }
        else {
            System.out.println("Wrong, TestThree");
        }
    }

    @Test
    public void testFour() throws Exception {
        Handler handler = new Handler("1");
        String answer = convert(handler.run());
        String correctAnwer = "один";
        if(answer.equals(correctAnwer)) {
            System.out.println("OK, TestFour");
        }
        else {
            System.out.println("Wrong, TestFour");
        }
    }

    @Test
    public void testFive() throws Exception {
        Handler handler = new Handler("0");
        String answer = convert(handler.run());
        String correctAnwer = "ноль";
        if(answer.equals(correctAnwer)) {
            System.out.println("OK, TestFive");
        }
        else {
            System.out.println("Wrong, TestFive");
        }
    }
    @Test
    public void testSix() throws Exception {
        Handler handler = new Handler("1001");
        String answer = convert(handler.run());
        String correctAnwer = "одна тысяча один";
        if(answer.equals(correctAnwer)) {
            System.out.println("OK, TestSix");
        }
        else {
            System.out.println("Wrong, TestSix");
        }
    }
}