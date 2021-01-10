import MyArrayList.MyArrayList;
import MyHashMap.MyHashMap;
import MyLinkedList.MyLinkedList;

import java.util.*;

public class Test {
    public static void main(String[] args) {


//        MyArrayList<Integer> mylist = new MyArrayList<Integer>(7);
//        for (int i =0 ;i<10;i++)
//        {
//            mylist.add(i);
//        }
//        mylist.show();

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
LinkedList<Integer> list = new LinkedList<>();

        myLinkedList.remove(2);
        myLinkedList.show();
        myLinkedList.add(6);
        myLinkedList.add(7);
        myLinkedList.add(8);
        myLinkedList.show();
        myLinkedList.remove(2);
        myLinkedList.show();
        System.out.println(myLinkedList.size());




//        map.put("один","One");
//        map.put("два","Two");
//        map.put("три","Three");
//        map.put("четыре","Four");
//        map.put("четыре","Five");
//        map.put("выа","Two");
//        map.put("аывпрва","Three");
//        map.put("ывавапаврсм","Four");
//        map.put("ыва","Five");
//        map.put("апфвап","Five");
//        map.put("ываывфа","Two");
//        map.put("ывапрывар","Three");
//        map.put("ывафварке","Four");
//        map.put("выаыфпрарапо","Five");
//        map.put("ВЫаыара","Five");
//        map.put("авыфварпаыр","Two");
//        map.put("чпывнек235у","Three");
//        map.put("1456нав","Four");
//        map.put("123676","Five");
//        map.put("пять","Five");

//        map.put(1,"One");
//        map.put(2,"Two");
//        map.put(3,"Three");
//        map.put(4,"Four");
//        map.put(4,"Five");
//        map.put(5,"Five");




//        System.out.println(map.get("один"));
//        System.out.println(map.get("два"));
//        System.out.println(map.get("три"));
//        System.out.println(map.get("четыре"));
//        System.out.println(map.get("пять"));

//        System.out.println(map.get(1));
//        System.out.println(map.get(2));
//        System.out.println(map.get(3));
//        System.out.println(map.get(4));
//        System.out.println(map.get(5));



    }
}
