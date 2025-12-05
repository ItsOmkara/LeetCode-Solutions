import java.util.HashMap;
import java.util.Map;

public class PracticeMaps {
    public static void main(String args[]){
        Map<Integer,String> m = new HashMap<>();
        m.put(1,"Omi");
        m.put(2,"Muni");
        m.put(3,"Buji");
        m.put(4,"Nalli");

//        m.forEach((Key,value)->{System.out.println(Key + " " + value);});
        System.out.println(m.size());
        for(int i=0;i<m.size();i++){
            if(m.containsValue("Buji")){
                System.out.println("Maal Hai");
                break;
            }
            else{
                System.out.println("Nhai hai");
            }
        }
    }
}
