package com.pablo.task.parserXML;


import javax.xml.parsers.*;
import java.io.File;
import java.util.ArrayList;

import com.pablo.task.record.Record;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Parser implements ParserInterface {

    private Document doc;

    private ArrayList <Record> recordList = new ArrayList <Record>();

    public Parser(String name) throws Exception {
        File inputFile = new File(name);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        this.doc = dBuilder.parse(inputFile);
    }

    public ArrayList<Record> parse() {
        try {
            doc.getDocumentElement().normalize();
            NodeList list = doc.getElementsByTagName(mainTag);
            for (int it = 0; it < list.getLength(); it++) {
                Node node = list.item(it);
                Element element = (Element) node;
                addTag(element);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return recordList;
    }

    private void addTag(Element element) {
        String tmpTagFirst = null;
        String tmpTagSecond = null;
        String tmpTagThird = null;
        String tmpTagFourth = null;
        try {
            tmpTagFirst = element.getElementsByTagName(tagFirst).item(0).getTextContent();
            tmpTagSecond = element.getElementsByTagName(tagSecond).item(0).getTextContent();
            tmpTagThird = element.getElementsByTagName(tagThird).item(0).getTextContent();
            tmpTagFourth = element.getElementsByTagName(tagFourth).item(0).getTextContent();
        } catch (NullPointerException e) {}
        Record record = new Record(tmpTagFirst, tmpTagSecond, tmpTagThird, tmpTagFourth);
        recordList.add(record);
    }
}
