package ch15_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExample {
    public static void main(String[] args){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("blue",96);
        map.put("hong",86);
        map.put("white",92);

        String name = null;
        int maxScore = 0;
        int totlaScore = 0;

        int count = 0;
        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while(keyIterator.hasNext()){
            String key = keyIterator.next();
            if(maxScore < map.get(key)){
                maxScore = map.get(key);
                name = key;
            }
            totlaScore += map.get(key);
            count++;
        }
        int avgScore = totlaScore/count;

        System.out.println("평균점수: " + avgScore);
        System.out.println("최고점수: " + maxScore);
        System.out.println("최고점수를 받은 아이디: " + name);
    }
}
