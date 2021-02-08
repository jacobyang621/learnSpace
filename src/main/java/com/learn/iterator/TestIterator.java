package com.learn.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class TestIterator {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
            it.remove();
        }
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
