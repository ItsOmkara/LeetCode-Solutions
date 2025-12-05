public class Anagram {
    public boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        int arr[] = new int[256];

        for(int i=0;i<s1.length();i++){
            arr[s1.charAt(i)]++;
            arr[s2.charAt(i)]--;
        }

        for(int count:arr){
            if(count!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        Anagram m = new Anagram();
        String s1 = "anagram";
        String s2 = "nagaram";
        if(m.isAnagram(s1,s2)){
            System.out.println("Its Anagram");
        }
        else{
            System.out.println("Its not Anagram");
        }
    }
}
