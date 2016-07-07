package com.pablo.task.handler;

import com.pablo.task.parserXML.Parser;
import com.pablo.task.record.Record;

import java.util.ArrayList;

public class Handler implements HandlerInteface {

    private static String path = "src/main/java/com/pablo/task/data/table.xml";

    private String number;

    private ArrayList <Record> listRecord = new ArrayList<Record>();

    private ArrayList <String> listNumber = new ArrayList<String>();

    public Handler (String number) {
        this.number = number;
    }

    public ArrayList<String> run() {
        try {
            if(checkZero(number)) {
                return listNumber;
            }
            Parser parser = new Parser(path);
            listRecord = parser.parse();
            makeListNumber();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNumber;
    }

    private Boolean checkZero(String number) {
        if(number.equals("0")) {
            listNumber.add("ноль");
            return true;
        }
        return false;
    }

    private void makeListNumber() {
        ArrayList<String> partNumber = new ArrayList<String>();
        StringBuilder tmpNumber = new StringBuilder("");
        for(int it = number.length() - 1; it >= 0; it--) {
            tmpNumber.append(number.charAt(it));
            if (tmpNumber.length() == 3) {
                partNumber.add(tmpNumber.reverse().toString());
                tmpNumber.delete(0, tmpNumber.length());
            }
        }
        if(tmpNumber.length() != 0) {
            partNumber.add(tmpNumber.reverse().toString());
        }
        for(int it = partNumber.size() - 1; it >= 0; it--) {
            if(!containAllZero(partNumber.get(it))) {
                addNumber(partNumber.get(it), it);
            }
        }
    }

    private Boolean containAllZero(String string) {
        for(int it = 0; it < string.length(); it++) {
            if(string.charAt(it) != '0') {
                return false;
            }
        }
        return  true;
    }

    private void addNumber(String tmpNumber, int iterator) {
        if(tmpNumber.length() == 3) {
            addDigit(tmpNumber.charAt(0) + "00", First);
            tmpNumber = tmpNumber.substring(1, tmpNumber.length());
        }
        if(tmpNumber.length() == 2) {
            if (addDigit(tmpNumber.toString(), First) == false) {
                addDigit(tmpNumber.charAt(0) + "0", First);
                tmpNumber = tmpNumber.substring(1, tmpNumber.length());
            }
        }
        if (tmpNumber.length() == 1) {
            if (iterator == 1) {
                addDigit(tmpNumber.charAt(0) + "", Second);
            } else {
                addDigit(tmpNumber.charAt(0) + "", First);
            }
        }
        if(iterator > 0) {
            addBasis(iterator, tmpNumber.toString());
        }
    }

    private Boolean addDigit(String digit, String whatNumber) {
        if(containAllZero(digit)) {
            return false;
        }
        String string = find(digit, whatNumber);
        if(string.equals(fail)) {
            return false;
        }
        listNumber.add(string);
        return true;
    }

    private void addBasis(int iterator, String other){
        StringBuilder tmp = new StringBuilder("1");
        while(iterator > 0) {
            tmp.append("000");
            iterator--;
        }
        if(other.equals("1")) {
            listNumber.add(find(tmp.toString(), First));
        }
        else if (other.equals("2") || other.equals("3") || other.equals("4")) {
            listNumber.add(find(tmp.toString(), Second));
        }
        else {
            listNumber.add(find(tmp.toString(), Third));
        }
    }

    private String find(String number, String whatNumber) {
        for(int it = 0; it < listRecord.size(); it++) {
            if(listRecord.get(it).getNumerical().equals(number) == true) {
                if(whatNumber.equals(Third) == true && listRecord.get(it).getTagThird() != null) {
                    return listRecord.get(it).getTagThird();
                }
                else if(whatNumber.equals(Second) == true && listRecord.get(it).getTagSecond() != null) {
                    return listRecord.get(it).getTagSecond();
                }
                else {
                    return listRecord.get(it).getTagFirst();
                }
            }
        }
        return fail;
    }

}
