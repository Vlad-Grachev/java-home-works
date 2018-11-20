package hw4;

import java.util.*;

public class TestsTools {
    private Random random = new Random();;

    public long fillList(List<Integer> list, int size){ // returns elapsed time
        int x;
        long starTime = System.nanoTime();
        for(int i = 0; i < size; i++){
            x = random.nextInt(2 * size) - size;
            list.add(x);
        }
        return System.nanoTime() - starTime;
    }

    public long randomInserts(List<Integer> list, int numInserts){ // returns elapsed time
        int index, x, maxValue = list.size();
        long starTime = System.nanoTime();
        for(int i = 0; i < numInserts; i++){
            x = random.nextInt(2 * maxValue) - maxValue;
            index = random.nextInt(list.size());
            list.add(index, x);
        }
        return System.nanoTime() - starTime;
    }

    public long randomRemoves(List<Integer> list, int numInserts){ // returns elapsed time
        int index;
        long starTime = System.nanoTime();
        for(int i = 0; i < numInserts; i++){
            index = random.nextInt(list.size());
            list.remove(index);
        }
        return System.nanoTime() - starTime;
    }

    public long fillSet(Set<Integer> set, int size){ // returns elapsed time
        long starTime = System.nanoTime();
        for(int i = 0; i < size; i++){
            set.add(i);
            set.add(size - i);
        }
        return System.nanoTime() - starTime;
    }

    public long removeCenter(Set<Integer> set){ // returns elapsed time
        int maxValue = set.size();
        long starTime = System.nanoTime();
        for(int i = maxValue / 4; i < maxValue / 2 + maxValue / 4; i++){
            set.remove(i);
        }
        return System.nanoTime() - starTime;
    }

    public long insertCenter(Set<Integer> set){
        int maxValue = set.size() * 2;
        long starTime = System.nanoTime();
        for(int i = maxValue / 4; i < maxValue / 2 + maxValue / 4; i++){
            set.add(i);
        }
        return System.nanoTime() - starTime;
    }

    public long fillMap(Map<Integer, Integer> map, int size){ // returns elapsed time
        int x;
        long starTime = System.nanoTime();
        for(int i = 0; i < size; i++){
            x = random.nextInt(2 * size) - size;
            map.put(i, x);
        }
        return System.nanoTime() - starTime;
    }

    public long removeCenter(Map<Integer, Integer> map){ // returns elapsed time
        int maxIndex = map.size();
        long starTime = System.nanoTime();
        for(int i = maxIndex / 4; i < maxIndex / 2 + maxIndex / 4; i++){
            map.remove(i);
        }
        return System.nanoTime() - starTime;
    }

    public long insertCenter(Map<Integer, Integer> map){
        int maxIndex = map.size() * 2, x;
        long starTime = System.nanoTime();
        for(int i = maxIndex / 4; i < maxIndex / 2 + maxIndex / 4; i++){
            x = random.nextInt(2 * maxIndex) - maxIndex;
            map.put(i, x);
        }
        return System.nanoTime() - starTime;
    }
}
