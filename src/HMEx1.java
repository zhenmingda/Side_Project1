//package HashMaps;
import java.util.HashMap;

public class HMEx1 {
    public static void main(String[] args){
        HashMap<String, Integer> ageMap = new HashMap<String,Integer>();

        ageMap.put("dog", 15);
        ageMap.put("cat", 20);
        ageMap.put("human", 75);
        ageMap.put("turtle", 100);

        System.out.println(ageMap);

        for(String s: ageMap.keySet()){
            System.out.println(s);
        }
        for(Integer i : ageMap.values()){
            System.out.println(i);
        }

    }
}
