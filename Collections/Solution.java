package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Solution {
    public static void main(String args[]){
       Map<String,Integer> map = new ConcurrentHashMap<>();
       map.put("Om",1);
       map.put("david",2);
       map.put("Beckham",3);
       map.put("John",4);

       map.forEach((key,value)->{
           map.put("Bilal",6);
       });
        map.forEach((key,value)->{
            System.out.println(key + "->" + value);
        });
    }
}
