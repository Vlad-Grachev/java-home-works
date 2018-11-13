package hw4;

import hw1.MyPoint;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainClass {
    public static void basicFunctionalityTest(){
        ILinkedList<MyPoint> listPoints = new MyLinkedList<>();
        MyPoint[] arrPoints = new MyPoint[4];
        for (int i = 2; i < 6; i++){
            arrPoints[i - 2] = new MyPoint(i, 2 * i);
            listPoints.add(new MyPoint(i, 2 * i));
        }
        System.out.println("toString(): " + listPoints);

        System.out.println("size(): " + listPoints.size());

        if(arrPoints[2].equals(listPoints.get(2)))
            System.out.println("Can add and get elements");

        if(listPoints.indexOf(arrPoints[3]) == 3)
            System.out.println("Can find index of element");

        listPoints.remove(2);
        if(listPoints.indexOf(arrPoints[2]) == -1)
            System.out.println("Can remove element");

        listPoints.set(2, arrPoints[2]);
        listPoints.add(arrPoints[3]);
        if(Arrays.equals(arrPoints, listPoints.toArray()))
            System.out.println("Can convert to array");

        for(MyPoint p: listPoints){
            System.out.println("For-Each loop testing: " + p);
        }

        listPoints.clear();
        if(listPoints.size() == 0)
            System.out.println("Can clear list");
    }

    public static void perfomanceTest(){
        ILinkedList<Integer> myList = new MyLinkedList<>();
        List<Integer> list = new LinkedList<>();
        int elemNum = 20000;

        long startTime = System.nanoTime();
        for(int i = 0; i < elemNum; i++){
            myList.add(i);
        }
        long myListTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for(int i = 0; i < elemNum; i++){
            list.add(i);
        }
        long listTime = System.nanoTime() - startTime;

        if(myListTime > listTime)
            System.out.println("MyLinkedList is faster in adding elements");
        else
            System.out.println("LinkedList is faster in adding elements");

        startTime = System.nanoTime();
        myList.get(elemNum / 10);
        myList.get(elemNum / 2);
        myList.get(elemNum - 2);
        myListTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        list.get(elemNum / 10);
        list.get(elemNum / 2);
        list.get(elemNum - 2);
        listTime = System.nanoTime() - startTime;

        if(myListTime > listTime)
            System.out.println("MyLinkedList is faster in searching elements");
        else
            System.out.println("LinkedList is faster in searching elements");

        startTime = System.nanoTime();
        myList.remove(elemNum / 10);
        myList.remove(elemNum / 2);
        myList.remove(elemNum - 4);
        myListTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        list.remove(elemNum / 10);
        list.remove(elemNum / 2);
        list.remove(elemNum - 4);
        listTime = System.nanoTime() - startTime;

        if(myListTime > listTime)
            System.out.println("MyLinkedList is faster in removing elements");
        else
            System.out.println("LinkedList is faster in removing elements");

        elemNum -= 3;
        boolean equalityOfResults = true;
        int i = 0;
        while (i < elemNum && equalityOfResults){
            equalityOfResults = (myList.get(i).intValue() == list.get(i).intValue());
            i++;
        }
        if(equalityOfResults)
            System.out.println("Results of work are identical");
        else
            System.out.println("Results of work are not identical");

    }

    public static void main(String[] args) {
        basicFunctionalityTest();
        System.out.println();
        perfomanceTest();
    }
}
