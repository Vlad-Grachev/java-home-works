package hw4;

import java.util.*;

public class JavaCollectionsTests {
    public static void listTest(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int numElems = 100000;

        long starTime = System.nanoTime();
        for(int i = 0; i < numElems; i++){
            linkedList.add(i);
        }
        long lListTime = System.nanoTime() - starTime;

        starTime = System.nanoTime();
        for(int i = 0; i < numElems; i++){
            arrayList.add(i);
        }
        long aListTime = System.nanoTime() - starTime;

        if(lListTime > aListTime)
            System.out.println("ArrayList is faster in adding elements");
        else
            System.out.println("LinkedList is faster in adding elements");

        starTime = System.nanoTime();
        for(int i = 0; i < 10000; i++){
            linkedList.addFirst(i);
        }
        for (int i = numElems / 2; i < numElems / 2 + 10000; i++) {
            linkedList.add(i, i);
        }
        for(int i = 0; i < 10000; i++){
            linkedList.addLast(i);
        }
        lListTime = System.nanoTime() - starTime;

        starTime = System.nanoTime();
        for(int i = 0; i < 10000; i++){
            arrayList.add(0, i);
        }
        for (int i = numElems / 2; i < numElems / 2 + 10000; i++) {
            arrayList.add(i, i);
        }
        for(int i = numElems - 10000; i < numElems; i++){
            arrayList.add(numElems - 1, i);
        }
        aListTime = System.nanoTime() - starTime;

        if(lListTime > aListTime)
            System.out.println("ArrayList is faster in inserting elements");
        else
            System.out.println("LinkedList is faster in inserting elements");

        starTime = System.nanoTime();
        for(int i = 0; i < 10000; i++){
            linkedList.removeFirst();
        }
        for (int i = numElems / 2; i < numElems / 2 + 1000; i++) {
            linkedList.remove(i);
        }
        for(int i = 0; i < 10000; i++){
            linkedList.removeLast();
        }
        lListTime = System.nanoTime() - starTime;

        starTime = System.nanoTime();
        for(int i = 0; i < 10000; i++){
            arrayList.remove(0);
        }
        for (int i = numElems / 2; i < numElems / 2 + 10000; i++) {
            arrayList.remove(i);
        }
        for(int i = 0; i < 10000; i++){
            arrayList.remove(numElems - 1);
        }
        aListTime = System.nanoTime() - starTime;

        if(lListTime > aListTime)
            System.out.println("ArrayList is faster in removing elements");
        else
            System.out.println("LinkedList is faster in removing elements");
    }

    public static void setTest(){
        HashSet<Integer> hashSet = new HashSet<>();
        LinkedHashSet<Integer> linkedSet = new LinkedHashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        int numElems = 1000000;

        long starTime = System.nanoTime();
        for(int i = 0; i < numElems; i++){
            hashSet.add(i);
            hashSet.add(numElems - i);
        }
        long hSetTime = System.nanoTime() - starTime;

        starTime = System.nanoTime();
        for(int i = 0; i < numElems; i++){
            linkedSet.add(i);
            linkedSet.add(numElems - i);
        }
        long lSetTime = System.nanoTime() - starTime;

        starTime = System.nanoTime();
        for(int i = 0; i < numElems; i++){
            treeSet.add(i);
            treeSet.add(numElems - i);
        }
        long tSetTime = System.nanoTime() - starTime;

        if(hSetTime < lSetTime) {
            if (hSetTime < tSetTime)
                System.out.println("HashSet is faster in adding elements");
            else
                System.out.println("TreeSet is faster in adding elements");
        }
        else {
            if (lSetTime < tSetTime)
                System.out.println("LinkedHashSet is faster in adding elements");
            else
                System.out.println("TreeSet is faster in adding elements");
        }
        starTime = System.nanoTime();
        for(int i = numElems / 4; i < numElems / 2; i++){
            hashSet.remove(i);
        }
        hSetTime = System.nanoTime() - starTime;

        starTime = System.nanoTime();
        for(int i = numElems / 4; i < numElems / 2; i++){
            linkedSet.remove(i);
        }
        lSetTime = System.nanoTime() - starTime;

        starTime = System.nanoTime();
        for(int i = numElems / 4; i < numElems / 2; i++){
            treeSet.remove(i);
        }
        tSetTime = System.nanoTime() - starTime;

        if(hSetTime < lSetTime) {
            if (hSetTime < tSetTime)
                System.out.println("HashSet is faster in removing elements");
            else
                System.out.println("TreeSet is faster in removing elements");
        }
        else {
            if (lSetTime < tSetTime)
                System.out.println("LinkedHashSet is faster in removing elements");
            else
                System.out.println("TreeSet is faster in removing elements");
        }

        starTime = System.nanoTime();
        for(int i = numElems / 4; i < numElems / 2; i++){
            hashSet.add(i);
        }
        hSetTime = System.nanoTime() - starTime;

        starTime = System.nanoTime();
        for(int i = numElems / 4; i < numElems / 2; i++){
            treeSet.add(i);
        }
        tSetTime = System.nanoTime() - starTime;

        if(hSetTime < tSetTime)
            System.out.println("HashSet is faster in inserting elements");
        else
            System.out.println("TreeSet is faster in inserting elements");
    }

    public static void mapTest(){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        LinkedHashMap<Integer, Integer> linkedMap = new LinkedHashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int numElems = 1000000;

        long starTime = System.nanoTime();
        for(int i = 0; i < numElems; i++){
            hashMap.put(i, numElems - i);
        }
        long hMapTime = System.nanoTime() - starTime;

        starTime = System.nanoTime();
        for(int i = 0; i < numElems; i++){
            linkedMap.put(i, numElems - i);
        }
        long lMapTime = System.nanoTime() - starTime;

        starTime = System.nanoTime();
        for(int i = 0; i < numElems; i++){
            treeMap.put(i, numElems - i);
        }
        long tMapTime = System.nanoTime() - starTime;

        if(hMapTime < lMapTime) {
            if (hMapTime < tMapTime)
                System.out.println("HashMap is faster in adding elements");
            else
                System.out.println("TreeMap is faster in adding elements");
        }
        else {
            if (lMapTime < tMapTime)
                System.out.println("LinkedHashMap is faster in adding elements");
            else
                System.out.println("TreeMap is faster in adding elements");
        }
        starTime = System.nanoTime();
        for(int i = numElems / 4; i < numElems / 2; i++){
            hashMap.remove(i);
        }
        hMapTime = System.nanoTime() - starTime;

        starTime = System.nanoTime();
        for(int i = numElems / 4; i < numElems / 2; i++){
            linkedMap.remove(i);
        }
        lMapTime = System.nanoTime() - starTime;

        starTime = System.nanoTime();
        for(int i = numElems / 4; i < numElems / 2; i++){
            treeMap.remove(i);
        }
        tMapTime = System.nanoTime() - starTime;

        if(hMapTime < lMapTime) {
            if (hMapTime < tMapTime)
                System.out.println("HashMap is faster in removing elements");
            else
                System.out.println("TreeMap is faster in removing elements");
        }
        else {
            if (lMapTime < tMapTime)
                System.out.println("LinkedHashMap is faster in removing elements");
            else
                System.out.println("TreeMap is faster in removing elements");
        }

        starTime = System.nanoTime();
        for(int i = numElems / 4; i < numElems / 2; i++){
            hashMap.put(i, numElems - i);
        }
        hMapTime = System.nanoTime() - starTime;

        starTime = System.nanoTime();
        for(int i = numElems / 4; i < numElems / 2; i++){
            treeMap.put(i, numElems - i);
        }
        tMapTime = System.nanoTime() - starTime;

        if(lMapTime < tMapTime)
            System.out.println("HashMap is faster in inserting elements");
        else
            System.out.println("TreeMap is faster in inserting elements");
    }

    public static void main(String[] args) {
        //listTest();
        //setTest();
        mapTest();
    }
}
