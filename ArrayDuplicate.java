import java.util.*;

public class ArrayDuplicate {
    public static void main(String args[]){
        int [] arr = {8,29,4,29,6,2,5,5,1};
        int size = arr.length;
//        Set<Integer> s = new HashSet<>();
//        for(int i=0;i<size;i++) {
//            s.add(arr[i]);
//        }
//       List<Integer> l = new ArrayList<>(s);
//        for(Integer st:s){
//            System.out.print(st + " ");
//        }


        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < size; i++) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }

        // Frequency print
        m.forEach((key, value) -> System.out.println(key + " -> " + value));
        String s = "abacadbc";
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        map.forEach((key,value)->System.out.println(key + "->" + value));
    }
}
