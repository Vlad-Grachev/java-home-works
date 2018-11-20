package hw4;

import java.util.*;

public class JavaCollectionsTests {
    private TestsTools tools;

    public JavaCollectionsTests(){
        tools = new TestsTools();
    }

    public static String getFastest(String[] classNames, long[] results) {
        String fastest = classNames[0];
        long minTime = results[0];
        for (int i = 1; i < results.length; i++) {
            if (minTime > results[i]) {
                minTime = results[i];
                fastest = classNames[i];
            }
        }
        return fastest;
    }

    public void listTest(int listSize){
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        String[] names = {"LinkedList", "ArrayList"};
        long[] results = {0, 0};

        results[0] = tools.fillList(linkedList, listSize);
        results[1] = tools.fillList(arrayList, listSize);
        System.out.println(getFastest(names, results) + " is faster in adding elements");

        results[0] = tools.randomInserts(linkedList, listSize / 4);
        results[1] = tools.randomInserts(arrayList, listSize / 4);
        System.out.println(getFastest(names, results) + " is faster in inserting elements");

        results[0] = tools.randomRemoves(linkedList, listSize / 4);
        results[1] = tools.randomRemoves(arrayList, listSize / 4);
        System.out.println(getFastest(names, results) + " is faster in removing elements");
    }

    public void setTest(int setSize){
        HashSet<Integer> hashSet = new HashSet<>();
        LinkedHashSet<Integer> linkedSet = new LinkedHashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        String[] names = {"HashSet", "LinkedHashSet", "TreeSet"};
        long[] results = {0, 0, 0};

        results[0] = tools.fillSet(hashSet, setSize);
        results[1] = tools.fillSet(linkedSet, setSize);
        results[2] = tools.fillSet(treeSet, setSize);
        System.out.println(getFastest(names, results) + " is faster in adding elements");

        results[0] = tools.removeCenter(hashSet);
        results[1] = tools.removeCenter(linkedSet);
        results[2] = tools.removeCenter(treeSet);
        System.out.println(getFastest(names, results) + " is faster in removing elements");

        results[0] = tools.insertCenter(hashSet);
        results[1] = Long.MAX_VALUE;
        results[2] = tools.insertCenter(treeSet);
        System.out.println(getFastest(names, results) + " is faster in inserting elements");
    }

    public void mapTest(int mapSize){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        LinkedHashMap<Integer, Integer> linkedMap = new LinkedHashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        String[] names = {"HashMap", "LinkedHashMap", "TreeMap"};
        long[] results = {0, 0, 0};

        results[0] = tools.fillMap(hashMap, mapSize);
        results[1] = tools.fillMap(linkedMap, mapSize);
        results[2] = tools.fillMap(treeMap, mapSize);
        System.out.println(getFastest(names, results) + " is faster in adding elements");

        results[0] = tools.removeCenter(hashMap);
        results[1] = tools.removeCenter(linkedMap);
        results[2] = tools.removeCenter(treeMap);
        System.out.println(getFastest(names, results) + " is faster in removing elements");

        results[0] = tools.insertCenter(hashMap);
        results[1] = Long.MAX_VALUE;
        results[2] = tools.insertCenter(treeMap);
        System.out.println(getFastest(names, results) + " is faster in inserting elements");
    }

    public static void main(String[] args) {
        JavaCollectionsTests tests = new JavaCollectionsTests();
        tests.listTest(100000);
        System.out.println();
        tests.setTest(1000000);
        System.out.println();
        tests.mapTest(1000000);
    }
}
