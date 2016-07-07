package com.pablo.task.parserXML;


import com.pablo.task.record.Record;

import java.util.ArrayList;

public interface ParserInterface {

    String mainTag = "number";
    String tagFirst = "numerical";
    String tagSecond = "first";
    String tagThird = "second";
    String tagFourth = "third";

    ArrayList<Record> parse();

}
