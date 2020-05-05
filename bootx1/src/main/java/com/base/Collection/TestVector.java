package com.base.Collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class TestVector {
    public void test01() {
        Vector<String> hs = new Vector<String>();//Vector的方法都是同步的(Synchronized),是
        hs.add("aa");
        hs.add("bb");
        hs.add("aa");
        hs.add("cc");
        hs.add("aa");
        hs.add("dd");
        printSet(hs);
    }

    public void printSet(List hs) {
        Iterator iterator = hs.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void printSet2(Vector<String> hs) {
        Enumeration<String> elements = hs.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }
    }

    public static void main(String[] args) {
        new TestVector().test01();
    }
}